package cn.iolove.lui.model;


import cn.iolove.domain.LuaData;
import cn.iolove.luajava.LuaObject;
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
	public void removaAllChild()
	{
		((ViewWidget)widget).removeAllChild();
	}


}
