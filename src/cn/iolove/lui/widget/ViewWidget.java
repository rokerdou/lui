package cn.iolove.lui.widget;

import java.util.ArrayList;
import java.util.List;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;

import cn.iolove.lui.context.RuntimeContext;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.model.UIModel;
import cn.iolove.lui.service.LuaService;
import cn.iolove.lui.utils.BitmapUtils;
import cn.iolove.lui.utils.LoadImageListener;
import cn.iolove.lui.view.LuiView;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;

public class ViewWidget extends AbstractWidget {
	
	public ViewWidget(UIModel m) {
		super(m);
		lv = new LuiView(RuntimeContext.getInstance().rl.getActivityContext());
		loadModel();
		//lv.setVerticalScrollBarEnabled(true);
		
		
		
	}

	private LuiView lv;
	protected List<AbstractWidget> subitems=new ArrayList<AbstractWidget>();
	public void _LUA_addChild(LuaObject obj) 
	{
		final AbstractWidget childWidget;
		try {
			childWidget = LuaService.getInstance().getWidget(obj);
			childWidget.model.parentwidget=this;
			RuntimeContext.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					addChild(childWidget);
					
				}
			});
		
		} catch (LuaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RuntimeContext.showLuaError(e.getMessage());
		}
		
	}
	
	public void addChild(AbstractWidget child)
	{
		lv.addView(child.getInnerView());
		
		subitems.add(child);
		
	}
	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		 return lv;
	}
	
	protected  AbstractWidget findWidget(String ids)
	{
		if(ids.equals(id)) return this;
		int i=0;
		for(i=0;i<subitems.size();i++)
		{
			AbstractWidget child = subitems.get(i);
			if(child.findWidget(ids)!=null)
			{
				return child;
			}
			
		}
		return null;
		
	}
	public void _LUA_removeChild(final String id)
	{
		final AbstractWidget w =findWidget(id);
		if(w!=null)
		{
			RuntimeContext.runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					((ViewWidget)(w.getModel().getParenWidget())).removeChild(w);
					LuaService.getInstance().removeGlobalObject(id);
				
				}
			});
			
			
		}
		else
		RuntimeContext.showLuaError("not "+id +" widget");
	}
	protected void removeChild(AbstractWidget w)
	{
		subitems.remove(w);
		lv.removeView(w.getInnerView());
		
		
	}
	public void  Refresh()
	{
		loadModel();
		int i=0;
		for(i=0;i<subitems.size();i++)
		{
			AbstractWidget child = subitems.get(i);

				 child.Refresh();
		
			
		}
		
	}

	@Override
	protected void loadModel() {

		WidgetUtils.loadModel(model, this);
		super.loadModel();

		reloadBackground(lv);
	       
		
	}

	@Override
	public void Ondestroy() {
		// TODO Auto-generated method stub
		int i=0;
		for(i=0;i<subitems.size();i++)
		{
			AbstractWidget child = subitems.get(i);
			
			child.Ondestroy();
			
		}	
		lv.removeAllViews();
	}

	


}
