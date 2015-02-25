package cn.iolove.lui.view;

import java.util.ArrayList;
import java.util.List;

import cn.iolove.lui.model.AbstractModel;

import android.content.Context;
import android.view.View;

import android.widget.FrameLayout;

public class LuiView extends FrameLayout {

	protected AbstractModel model;
	protected List<LuiView> subitems=new ArrayList<LuiView>();
	public LuiView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	@Override
	public void addView(View child) {
		// TODO Auto-generated method stub
		super.addView(child);
		subitems.add((LuiView) child);
	}
	@Override
	public void removeView(View view) {
		// TODO Auto-generated method stub
		super.removeView(view);
		subitems.remove(view);
	}
	@Override
	public void removeAllViews() {
		// TODO Auto-generated method stub
		super.removeAllViews();
		subitems.clear();
	}


}
