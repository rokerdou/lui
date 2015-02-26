package cn.iolove.lui.context;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;
import cn.iolove.lui.view.LuiView;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;

public class RuntimeContext {
	public static Context context;
	private RuntimeContext(){};
	private static RuntimeContext obj = new RuntimeContext();
	public  interface RuntimeContextListener{
		public abstract void setView(LuiView v);
		public abstract void RunOnUiThread(final Runnable runnable );
		public abstract Context getActivityContext();
		
		
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
	public static void init(Context cont,RuntimeContextListener cb)
	{
		context=cont;
		rl=cb;
		//cb.setView(v);
		start();
		
	}
	public static void start()
	{
		runOnWorkThread(ThreadFactory.getWorkThread().setMehod(new Method() {
			
			@Override
			public void Work() {
			
				LuaState	mLuaState = LuaStateFactory.newLuaState();
			
		    	mLuaState.openLibs();
		   
		    	LuaHelper.loadScript(mLuaState, "main");
				
			}
		}));
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
				new AlertDialog.Builder(rl.getActivityContext()).setTitle("LUA´íÎó").setMessage(str).setPositiveButton("È·¶¨", null).show();
			
			}
		});
		
	}


}
