package cn.iolove.lui.widget;

import java.util.ArrayList;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.UIModel;
import cn.iolove.lui.service.LuaService;
import cn.iolove.lui.utils.BitmapUtils;
import cn.iolove.lui.utils.LoadImageListener;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.View;

public  abstract class AbstractWidget {
	protected ColorDrawable  colorDrawable;
	protected BitmapDrawable  imageDrawable;

	public  abstract View getInnerView();
	protected UIModel model;
	protected String id=null;
	public  abstract void Ondestroy();
	public UIModel getModel()
	{
		return model;
	}
	protected  void loadModel()
	{
		if(model.backgroundcolor!=null)
		{
			colorDrawable = new ColorDrawable(Color.parseColor(model.backgroundcolor));
			
		}
		if(model.backgroundimage!=null)
		{
			BitmapUtils.loadImage(model.backgroundimage, new LoadImageListener() {
				
				@Override
				public void succeed(final Drawable rl) {
				RuntimeContext.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						
						imageDrawable=(BitmapDrawable) rl;
						
						
						Log.i("lui", "Õº∆¨º”‘ÿsucceed");
						
						
				
						
					}
				});
					
				}
				
				@Override
				public void fail() {
				Log.i("lui", "Õº∆¨º”‘ÿ ß∞‹");
				imageDrawable=null;
					
					
				}
			});
		
		}
	}

	public AbstractWidget(UIModel m)
	{
		model =m;
		id=m.id;
		if(id!=null)
		{
			LuaService.getInstance().pushGlobalObject(id, model);
			Log.i("lui", "add "+id);
		}
		
	}
	
	protected AbstractWidget findWidget(String ids) {
		if(ids.equals(id)) return this;
		return null;
	}
	public void  Refresh()
	{
		loadModel();
	}
	protected void reloadBackground(View view)
	{
		ArrayList list = new ArrayList(2);
		if (colorDrawable != null)
			list.add(colorDrawable);
		if (imageDrawable != null)
		{
			imageDrawable.setAlpha(255- ((model.alpha*255)/100));
			list.add(imageDrawable);
		}
		LayerDrawable drawable = new LayerDrawable((Drawable[])list.toArray(new Drawable[list.size()]));
			drawable.setAlpha(255- ((model.alpha*255)/100));		
		if (view != null&&imageDrawable!=null)
		{
			view.setBackgroundDrawable(imageDrawable);
			
		}
		
		else
			System.out.println("reloadBackground on empty view.");
	}
	




}
