package cn.iolove.lui.page;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.view.LuiView;

public class Page {
	private LuiView root;
	private LuaState luastate;

	/**
	 * @param args
	 */
	public Page(String name)
	{
		LuaState	mLuaState = LuaStateFactory.newLuaState();
		
    	mLuaState.openLibs();
    	luastate=mLuaState;
    	LuaHelper.loadScript(mLuaState,name);
	}

	public LuiView getRootView()
	{
		return root;
	}

}
