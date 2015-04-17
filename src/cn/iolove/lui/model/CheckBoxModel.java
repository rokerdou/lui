package cn.iolove.lui.model;

import cn.iolove.domain.LuaData;

public class CheckBoxModel extends UIModel {
	public boolean Oncheck=false;

	public boolean getOncheck() {
		return Oncheck;
	}

	public void setOncheck(boolean oncheck) {
		Oncheck = oncheck;
	}

	public CheckBoxModel(LuaData data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	

}
