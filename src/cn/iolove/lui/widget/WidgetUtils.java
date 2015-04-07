package cn.iolove.lui.widget;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import cn.iolove.debug.LOG;
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
       lv.getBackground().setAlpha((int) (255-(model.alpha*255)/100));
       LOG.i(WidgetUtils.class, "model "+ model.id+" "+ model.hidden);
	   if(model.hidden)
	   {
		   lv.setVisibility(View.GONE);
	   }
	   else
	   {
		   lv.setVisibility(View.VISIBLE);
	   }
	   
	}

}
