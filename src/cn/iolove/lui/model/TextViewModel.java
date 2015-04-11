package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class TextViewModel extends UIModel {
	public String textcolor="#000000";
	public String text=null;
	public TextViewModel(LuaData data) {
		super(data);
		if(data.getAttrs().get("textcolor")!=null)  textcolor= (String) (data.getAttrs().get("textcolor"));
		if(data.getAttrs().get("text")!=null)  text= (String) (data.getAttrs().get("text"));
	
	}
	public void setText(String texts)
	{
		text=texts;
	}
	public String getTextcolor() {
		return textcolor;
	}
	public void setTextcolor(String textcolor) {
		this.textcolor = textcolor;
	}
	public String getText() {
		return text;
	}

	

}
