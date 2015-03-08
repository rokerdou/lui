package cn.iolove.lui.widget;

import cn.iolove.lui.model.UIModel;
import cn.iolove.lui.service.LuaService;
import android.util.Log;
import android.view.View;

public  abstract class AbstractWidget {

	public  abstract View getInnerView();
	protected UIModel model;
	protected String id=null;
	public UIModel getModel()
	{
		return model;
	}
	protected abstract void loadModel();

	public AbstractWidget(UIModel m)
	{
		model =m;
		id=m.id;
		if(id!=null)
		{
			LuaService.getInstance().pushGlobalObject(id, model);
			Log.i("lui", "add "+id);
		}
		
	}
	
	protected AbstractWidget findWidget(String ids) {
		if(ids.equals(id)) return this;
		return null;
	}
	public void  Refresh()
	{
		loadModel();
	}

	



}
