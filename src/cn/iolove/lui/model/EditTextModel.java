package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class EditTextModel extends TextViewModel {

	public EditTextModel(LuaData data) {
		super(data);
		if(data.getAttrs().get("text")!=null)  text= (String) (data.getAttrs().get("text"));
	//	if(data.getAttrs().get("Onclick")!=null)  Onclick= (String) (data.getAttrs().get("Onclick"));

		// TODO Auto-generated constructor stub
	}

}
