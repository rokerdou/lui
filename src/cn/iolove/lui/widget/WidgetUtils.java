package cn.iolove.lui.widget;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import cn.iolove.lui.model.UIModel;

public class WidgetUtils {
	public static void loadModel(UIModel model,AbstractWidget widget)
	{
		View lv = widget.getInnerView();
		int x=model.getMarginleft();
		int y = model.getMargintop();
		int w= model.getWidth();
		int h=model.getHeight();
       lv.layout(x, y, x+w, y+h);
       MarginLayoutParams margin=new MarginLayoutParams(w,h); 
       margin.setMargins(x,y, x+w, y+h); 
       FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(margin); 
       lv.setLayoutParams(layoutParams); 

       lv.setBackgroundColor(Color.parseColor(model.getBackgroundcolor()));
		
	}

}
