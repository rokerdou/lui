package cn.iolove.lui.page;

import org.keplerproject.luajava.LuaState;

import cn.iolove.lui.view.LuiView;

public class Page {
	private LuiView root;
	private LuaState luastate;

	/**
	 * @param args
	 */
	public LuiView getRootView()
	{
		return root;
	}

}
