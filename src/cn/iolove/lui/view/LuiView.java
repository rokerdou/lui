package cn.iolove.lui.view;

import java.util.ArrayList;
import java.util.List;

import cn.iolove.lui.model.AbstractModel;

import android.content.Context;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import android.widget.FrameLayout;

public class LuiView extends FrameLayout {



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
		
	}
	@Override
	public void removeView(View view) {
		// TODO Auto-generated method stub
		super.removeView(view);
	
	}
	@Override
	public void removeAllViews() {
		// TODO Auto-generated method stub
		super.removeAllViews();
	
	}
@Override
public boolean dispatchTouchEvent(MotionEvent ev) {
	// TODO Auto-generated method stub
	 super.dispatchTouchEvent(ev);
	 return true ;
}

}
