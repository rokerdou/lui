package cn.iolove.lui.context;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import cn.iolove.domain.Device;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.sandbox.AppSandbox;
import cn.iolove.lui.sandbox.AppSandbox.AppSandboxCallback;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;
import cn.iolove.lui.view.LuiView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

public class RuntimeContext {
	public static Context context;
	private RuntimeContext(){};
	private static RuntimeContext obj = new RuntimeContext();
	public  interface RuntimeContextListener{
		public abstract void setView(View v);
		public abstract void RunOnUiThread(final Runnable runnable );
		public abstract Activity getActivityContext();
		
		
	}
	public static RuntimeContextListener rl;
	public static RuntimeContext getInstance()
	{
		return obj;
	}
	void   registerActivityRuntimeContextLintener(RuntimeContextListener cb)
	{
		rl=cb;
	}
	public static void init(Context cont,RuntimeContextListener cb,AppSandboxCallback b)
	{
		context=cont;
		rl=cb;
		AppSandbox.getInstance().init(b);
		
		Device.getInstance().setScreenWidthAndHeight(rl.getActivityContext().getWindowManager().getDefaultDisplay().getWidth(),rl.getActivityContext().getWindowManager().getDefaultDisplay().getHeight());


		//cb.setView(v);
		start();
		
	}
	public static void start()
	{
		runOnWorkThread(ThreadFactory.getWorkThread((new Method() {
			
			@Override
			public void Work() {
			
				try {
					PageService.getInstance().start();
					runOnUiThread(new Runnable() {
						
						@Override
						public void run() {

							rl.setView((PageService.getInstance().getTopPage().getRootView()));
				
						}
					});
				} catch (LuaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					showLuaError(e.getMessage());
				}
						
			}
		})));
	}
	public static void  runOnWorkThread(Thread action)
	{
		action.start();
		
	}
	public static void  runOnUiThread(Runnable action)
	{
	
		rl.RunOnUiThread(action);
	}
	
	public static void showLuaError(final String str)
	{
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			AlertDialog.Builder	alert = new AlertDialog.Builder(rl.getActivityContext());
			alert.setTitle("LUA´íÎó");
			alert.setMessage(str);
			alert.setPositiveButton("ok", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					arg0.dismiss();
					
				}
			});
			alert.show();
			}
		});
		
	}


}
