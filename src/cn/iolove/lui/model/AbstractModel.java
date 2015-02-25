package cn.iolove.lui.model;

import cn.iolove.lui.view.LuiView;

public class AbstractModel {
	private LuiView view;

	/**
	 * @param args
	 */
	public void bindView(LuiView v)
	{
		view=v;
		
	}

}
