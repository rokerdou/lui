package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class EditTextModel extends TextViewModel {
	public String type="text";

	public EditTextModel(LuaData data) {
		super(data);
		if(data.getAttrs().get("type")!=null)  
			type=  (String) (data.getAttrs().get("type"));

		// TODO Auto-generated constructor stub
	}



}
