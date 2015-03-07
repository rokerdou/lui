package cn.iolove.lui.widget;

import java.util.ArrayList;
import java.util.List;

import org.keplerproject.luajava.LuaObject;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.controller.PageController;
import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.model.UIModel;
import cn.iolove.lui.service.LuaService;
import cn.iolove.lui.view.LuiView;
import android.graphics.Color;
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
		
		
	}

	private LuiView lv;
	protected List<AbstractWidget> subitems=new ArrayList<AbstractWidget>();
	public void addChild(LuaObject obj)
	{
		AbstractWidget childWidget = LuaService.getInstance().getWidget(obj);
		addChild(childWidget);
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

	@Override
	protected void loadModel() {
			int x=model.getMarginleft();
			int y = model.getMargintop();
			int w= model.getWidth();
			int h=model.getHeight();
	       lv.layout(x, y, x+w, y+h);
	       MarginLayoutParams margin=new MarginLayoutParams(w,h); 
	       margin.setMargins(x,y, x+w, y+h); 
	       FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(margin); 
	       lv.setLayoutParams(layoutParams); 
	       Log.i("System.err", id+"/marginleft: "+x);
	       Log.i("System.err", id+"/margintop: "+y);
	       lv.setBackgroundColor(Color.parseColor(model.getBackgroundcolor()));
	       
		
	}

	


}
