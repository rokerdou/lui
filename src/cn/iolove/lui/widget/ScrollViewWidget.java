package cn.iolove.lui.widget;

import org.keplerproject.luajava.LuaObject;

import android.view.View;
import android.widget.ScrollView;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.UIModel;

public class ScrollViewWidget extends AbstractWidget {

	private ScrollView scroll ;
	public ScrollViewWidget(UIModel m) {
		super(m);
	
		scroll = new ScrollView(RuntimeContext.getInstance().rl.getActivityContext());
		// TODO Auto-generated constructor stub
	}
	@Override
	protected AbstractWidget findWidget(String ids) {
		// TODO Auto-generated method stub
		return super.findWidget(ids);
	}
	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void Ondestroy() {
		// TODO Auto-generated method stub
		
	}
	
	public void _LUA_addChild(LuaObject obj) {
		// TODO Auto-generated method stub
		
	}

	protected void addChild(AbstractWidget child) {
		// TODO Auto-generated method stub
		
	}
	
	public void _LUA_removeChild(String id) {
		// TODO Auto-generated method stub
		
	}

	protected void removeChild(AbstractWidget w) {
	
		
	}

}
