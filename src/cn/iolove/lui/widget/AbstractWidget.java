package cn.iolove.lui.widget;

import cn.iolove.lui.model.UIModel;
import android.view.View;

public  abstract class AbstractWidget {

	public  abstract View getInnerView();
	protected UIModel model;
	protected String id;
	public UIModel getModel()
	{
		return model;
	}
	protected abstract void loadModel();

	public AbstractWidget(UIModel m)
	{
		model =m;
		id=m.getValueByKey("id");
		
	}
	
	protected abstract AbstractWidget findWidget(String ids);



}
