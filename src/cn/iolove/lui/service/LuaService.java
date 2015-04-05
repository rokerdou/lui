package cn.iolove.lui.service;

import org.keplerproject.luajava.LuaException;
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
public void error()
{
	RuntimeContext.showLuaError(getLuaState().toString(-1));
}
public LuaState getLuaState()
{
	return PageService.getInstance().getTopPage().getState();
}
public void pushGlobalObject(String name,Object obj)
{
	LuaHelper.setGlobalObject(getLuaState(), name, obj);
}
public void removeGlobalObject(String name)
{
	LuaHelper.removeGlobalObject(getLuaState(), name);
}
public void excuteLuaFunctionCallBack(final String mehodName,final Object[] args,final int returnnumber)
{
	RuntimeContext.runOnWorkThread(ThreadFactory.getWorkThread(new Method() {
		
		@Override
		public void Work() {

			RuntimeContext.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					try {
						LuaHelper.excuteLuaFunction(PageService.getInstance().getTopPage().getState(), mehodName, args, returnnumber);
					} catch (LuaException e) {
						// TODO Auto-generated catch block
						if(mehodName.equals("OnNavBack")||mehodName.equals("OnFronted"))
						{
							
						}
						else
						{
						RuntimeContext.showLuaError("mehodName:"+mehodName+" "+e.getMessage());
						}
						e.printStackTrace();
					}

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
public AbstractWidget getWidget(LuaObject obj) throws LuaException
{
	LuaData data =	LuaHelper.toLuaDataByLuaScript(getLuaState(), obj);
	return WidgetFactory.createWidgetTree(data);
}
}
