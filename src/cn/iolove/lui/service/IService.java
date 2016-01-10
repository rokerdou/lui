package cn.iolove.lui.service;



import cn.iolove.luajava.LuaObject;
import cn.iolove.luajava.LuaState;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;

public abstract class IService {


public abstract void fail(Object[] agrs);
public abstract void success(Object[] agrs);
LuaObject succFunc;
LuaObject failFunc;
LuaObject endedFunc;
private LuaState stat =PageService.getInstance().getTopPage().getState();
public void work( Method m,LuaObject succ,LuaObject fail,LuaObject end)
{
	ThreadFactory.getWorkThread(new Method() {
		
		@Override
		public void Work() {
	
		}
	}).start();
}
}
