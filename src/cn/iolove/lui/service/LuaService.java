package cn.iolove.lui.service;

import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import android.util.Log;

import cn.iolove.domain.LuaData;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;
import cn.iolove.lui.thread.WorkThread;
import cn.iolove.lui.utils.WidgetFactory;
import cn.iolove.lui.widget.AbstractWidget;

public class LuaService {

private static LuaService obj = new LuaService();
private LuaService(){

}
public static LuaService getInstance(){return obj;}
class log
{
	public void i(String text)
	{
		Log.i("lui", text);
	}
}
public void init()
{
	pushGlobalObject("Log",new log());
	
}
public LuaState getLuaState()
{
	return PageService.getInstance().getTopPage().getState();
}
public void pushGlobalObject(String name,Object obj)
{
	LuaHelper.setGlobalObject(getLuaState(), name, obj);
}
public void excuteLuaFunctionCallBack(final String mehodName,final Object[] args,final int returnnumber)
{
	RuntimeContext.runOnWorkThread(ThreadFactory.getWorkThread(new Method() {
		
		@Override
		public void Work() {
			LuaHelper.excuteLuaFunction(PageService.getInstance().getTopPage().getState(), mehodName, args, returnnumber);
			RuntimeContext.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					PageService.getInstance().Refresh();
				}
			});
		}
	}));


}
public AbstractWidget getWidget(LuaData data)
{
	
	return WidgetFactory.createWidgetTree(data);
}
public AbstractWidget getWidget(LuaObject obj)
{
	LuaData data =	LuaHelper.toLuaDataByLuaScript(getLuaState(), obj);
	return WidgetFactory.createWidgetTree(data);
}
}
