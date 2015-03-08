package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class ButtonModel extends UIModel {
	public String text=null;
	public String Onclick=null;

	public ButtonModel(LuaData data) {
		super(data);
		if(data.getAttrs().get("text")!=null)  text= (String) (data.getAttrs().get("text"));
		if(data.getAttrs().get("Onclick")!=null)  Onclick= (String) (data.getAttrs().get("Onclick"));

		// TODO Auto-generated constructor stub
	}
	public void setText(String texts)
	{
		text=texts;
	}

}
