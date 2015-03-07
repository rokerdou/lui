package cn.iolove.lui.utils;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import cn.iolove.domain.LuaData;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.UIModel;
import cn.iolove.lui.widget.AbstractWidget;
import cn.iolove.lui.widget.ViewWidget;

public final class WidgetFactory {

	private static final Map modelMapping = new HashMap();
	private static final Map widgetMapping = new HashMap();
	

	public static void register(String qName, Class widgetClass , Class modelClass)
	{
		if (qName.equals(""))
			
			
			throw new IllegalArgumentException("qName must not be empty.");

		if (widgetClass == null)
		{
			throw new IllegalArgumentException("widgetClass");
		} else
		{
			modelMapping.put(qName, modelClass);
			widgetMapping.put(qName, widgetClass);
			return;
		}
	}
	private static Class getWidgetClass(String qName)
	{
		return (Class) widgetMapping.get(qName);
	}
	private static Class getModelClass(String qName)
	{
		return (Class) modelMapping.get(qName);
	}
	public static AbstractWidget createWidgetTree(LuaData data)
	{
		AbstractWidget root =createWidget(data);
		root.getModel().setWidget(root, 0);

		if(data.hasChild())
		{
			int i=0;
			for(i=0;i<data.getChild().size();i++)
			{
				LuaData childData=(LuaData) data.getChild().get(i);
				AbstractWidget child = createWidgetTree(childData);
				child.getModel().setWidget(root, 1);
				((ViewWidget)root).addChild(child);
				Log.i("System.err", child.getModel().getValueByKey("id"));
			}
			
		}
		return root;
	
		
	}
	public static AbstractWidget createWidget(LuaData data)
	{
		
		Class c = getWidgetClass(data.getAttrs().get("qName").toString());
		
		Class [] params={UIModel.class};
		Object[] paray={createModel(data)};
		Constructor cons;
		AbstractWidget widget=null;
		try {
			cons = c.getConstructor(params);
			widget = (AbstractWidget)cons.newInstance(paray);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			throw new IllegalArgumentException("creating Widget failed!");
		}
		return widget;
		
		
	}
	private static UIModel createModel(LuaData data)
	{
		Class c = getModelClass(data.getAttrs().get("qName").toString());
		Class [] params={LuaData.class};
		Object[] paray={data};
		Constructor cons;
		try {
			cons = c.getConstructor(params);
			UIModel model = (UIModel)cons.newInstance(paray);
			return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new IllegalArgumentException("creating model failed!");
		}

		

		
	}
	static 
	{
	
		register("view", cn.iolove.lui.widget.ViewWidget.class, cn.iolove.lui.model.ViewModel.class);
		register("button", cn.iolove.lui.widget.ButtonWidget.class, cn.iolove.lui.model.ButtonModel.class);

	}

}
