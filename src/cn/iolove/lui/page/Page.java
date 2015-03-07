package cn.iolove.lui.page;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import android.view.View;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.service.LuaService;
import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.widget.AbstractWidget;

public class Page {
	private AbstractWidget root;
	private LuaState luastate;

	/**
	 * @param args
	 */
	public Page(String name)
	{
		LuaState	mLuaState = LuaStateFactory.newLuaState();
		
    	mLuaState.openLibs();
    	luastate=mLuaState;
    	root = LuaService.getInstance().getWidget(LuaHelper.loadScript(mLuaState,name));
	}
	public LuaState getState()
	{
		return luastate;
	}
	public LuiView getRootView()
	{
		return (LuiView) root.getInnerView();
	}

}
