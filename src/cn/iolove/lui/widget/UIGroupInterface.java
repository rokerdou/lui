package cn.iolove.lui.widget;

import cn.iolove.luajava.LuaObject;



public interface UIGroupInterface {
	public void _LUA_addChild(LuaObject obj) ;
	void addChild(AbstractWidget child);
	abstract AbstractWidget findWidget(String ids);
	public void _LUA_removeChild(final String id);
	void removeChild(AbstractWidget w);

}
