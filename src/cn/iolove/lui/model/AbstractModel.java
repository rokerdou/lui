package cn.iolove.lui.model;

import java.util.HashMap;

import android.view.View;
import cn.iolove.domain.LuaData;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.widget.AbstractWidget;

public class AbstractModel {
	protected HashMap hm = new HashMap();
	public AbstractWidget widget;
	public AbstractWidget parentwidget;
	public AbstractModel(LuaData data)
	{
		setAttrs(data.getAttrs());
	}
	public void setAttrs(HashMap hmm)
	{
		hm=(HashMap) hmm.clone();
	}
	public int getMargintop()
	{
		if(hm.get("margintop")!=null) return Integer.parseInt((String)(hm.get("margintop")));
		RuntimeContext.showLuaError("margintop no value");
		return (Integer) null;
	}
	public int getMarginleft()
	{
		if(hm.get("marginleft")!=null) return Integer.parseInt((String)(hm.get("marginleft")));
		RuntimeContext.showLuaError("marginleft no value");
		return (Integer) null;
	}
	public String getBackgroundcolor() {

		return (String) hm.get("backgroundcolor");
	}
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return Integer.parseInt((String)hm.get("width")) ;
	}

	
	public int getHeight() {
		// TODO Auto-generated method stub
		return  Integer.parseInt((String)hm.get("height"));
	}

	public AbstractWidget getWidget()
	
	{
		return widget;
	}
	public AbstractWidget getParenWidget()
	{
		return parentwidget ;
	}
	public void setWidget(AbstractWidget widgets,int index)
	{
		if(index==0) widget=widgets;
		parentwidget=widgets;
	}

}
