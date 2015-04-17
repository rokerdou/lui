package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class CheckBoxModel extends UIModel {
	public boolean ischeck=false;
	public String Onclick=null;

	public boolean getIscheck() {
		return ischeck;
	}

	public void setIscheck(boolean oncheck) {
		ischeck = oncheck;
	}

	public CheckBoxModel(LuaData data) {
		super(data);
		if(data.getAttrs().get("Onclick")!=null)  Onclick= (String) (data.getAttrs().get("Onclick"));

		// TODO Auto-generated constructor stub
	}
	

}
