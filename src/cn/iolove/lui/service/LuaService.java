package cn.iolove.lui.service;

import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

import cn.iolove.domain.LuaData;
import cn.iolove.lui.controller.PageController;
import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.utils.WidgetFactory;
import cn.iolove.lui.widget.AbstractWidget;

public class LuaService {

private static LuaService obj = new LuaService();
private LuaService(){}
public static LuaService getInstance(){return obj;}
public LuaState getLuaState()
{
	return PageController.getInstance().getTopPage().getState();
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
