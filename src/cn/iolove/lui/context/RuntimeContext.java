package cn.iolove.lui.context;

import cn.iolove.lui.view.LuiView;

import android.app.AlertDialog;
import android.content.Context;

public class RuntimeContext {
	public static Context context;
	private RuntimeContext(){};
	private static RuntimeContext obj = new RuntimeContext();
	public static interface RuntimeContextListener{
		public abstract void setView(LuiView v);
		public abstract void RunOnUiThread(final Runnable runnable );
		
	}
	public static RuntimeContextListener rl;
	public RuntimeContext getInstance()
	{
		return obj;
	}
	public static void init(Context cont,RuntimeContextListener cb)
	{
		context=cont;
		rl=cb;
		cb.setView(v);
		
	}
	public void  runOnWorkThread(Thread action)
	{
		action.start();
		
	}
	public  void  runOnUiThread(Runnable action)
	{
	
		rl.RunOnUiThread(action);
	}
	
	public static void showLuaError(String str)
	{
		new AlertDialog.Builder(context).setTitle("LUA´íÎó").setMessage(str).setPositiveButton("È·¶¨", null).show();
		
	}


	/**
	 * @param args
	 */

}
