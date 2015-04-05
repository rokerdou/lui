package cn.iolove.lui.page;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

import android.view.View;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.service.LuaService;
import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.widget.AbstractWidget;

public class Page implements PageCircle {
	private AbstractWidget root;
	private LuaState luastate;
	private String pagename;

	/**
	 * @param args
	 */
	public Page(String name)
	{
		LuaState	mLuaState = LuaStateFactory.newLuaState();
		pagename=name;
		
    	mLuaState.openLibs();
    	luastate=mLuaState;
    
	}
	public String getPageName()
	{
		return pagename;
	}
	public LuaState getState()
	{
		return luastate;
	}
	public void Refresh()
	{
		
		root.Refresh();
	}
	public LuiView getRootView()
	{
		return (LuiView) root.getInnerView();
	}
	@Override
	public void Oncreate() throws LuaException {
		// TODO Auto-generated method stub
		root = LuaService.getInstance().getWidget(LuaHelper.loadScript(luastate,pagename));
	}
	@Override
	public void onDestroy() {
		luastate.close();
		System.gc();
		
		
	}
	@Override
	public void OnFronted() {
		LuaService.getInstance().excuteLuaFunctionCallBack("OnFronted", new Object[]{}, 0);
		

		
	}

}
