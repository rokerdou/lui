package cn.iolove.lui.model;

import java.util.HashMap;

import android.view.View;
import cn.iolove.domain.LuaData;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.view.LuiView;
import cn.iolove.lui.widget.AbstractWidget;

public class AbstractModel {
	
	public AbstractWidget widget;
	public AbstractWidget parentwidget;
	public int margintop=100;
	public int marginleft=100;
	public int width=100;
	public int height=100;
	public String backgroundcolor="#000000";
	public String id=null;
	public boolean hidden=false;
	public int alpha=0;
	public AbstractModel(LuaData data)
	{
		//setAttrs(data.getAttrs());
		if(data.getAttrs().get("margintop")!=null)  margintop= Integer.parseInt((String)(data.getAttrs().get("margintop")));
		if(data.getAttrs().get("marginleft")!=null)  marginleft= Integer.parseInt((String)(data.getAttrs().get("marginleft")));
		if(data.getAttrs().get("width")!=null)  width= Integer.parseInt((String)(data.getAttrs().get("width")));
		if(data.getAttrs().get("height")!=null)  height= Integer.parseInt((String)(data.getAttrs().get("height")));
		if(data.getAttrs().get("backgroundcolor")!=null)  backgroundcolor= (String) (data.getAttrs().get("backgroundcolor"));
		if(data.getAttrs().get("id")!=null)  id= (String) (data.getAttrs().get("id"));
		if(data.getAttrs().get("hidden")!=null)  hidden= Boolean.parseBoolean((String) data.getAttrs().get("hidden"));
		if(data.getAttrs().get("alpha")!=null)  alpha= Integer.parseInt((String) data.getAttrs().get("alpha"));

	}
	public void setHidden(boolean f)
	{
		hidden=f;
		
	}
	public boolean getHidden()
	{
		return hidden;
		
	}
	public int getMargintop()
	{
		
		return (Integer) margintop;
	}
	public int getMarginleft()
	{

		return (Integer) marginleft;
	}
	public String getBackgroundcolor() {

		return backgroundcolor;
	}
	
	public int getWidth() {
		// TODO Auto-generated method stub
		return width ;
	}

	
	public int getHeight() {
		// TODO Auto-generated method stub
		return  height;
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
