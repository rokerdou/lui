package cn.iolove.lui.model;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;

import cn.iolove.domain.LuaData;
import cn.iolove.lui.widget.ViewWidget;

public class ViewModel  extends UIModel{

	public ViewModel(LuaData data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	public void addChild(LuaObject obj)
	{
		((ViewWidget)widget)._LUA_addChild(obj);
	}
	public void removeChild(AbstractModel models)
	{
		

		
		((ViewWidget)widget)._LUA_removeChild(models.id);
	}


}
