package cn.iolove.lui.utils;

import java.util.HashMap;
import java.util.Map;

public final class WidgetFactory {

	private static final Map modelMapping = new HashMap();
	private static final Map widgetMapping = new HashMap();

	public static void register(String qName, Class modelClass, Class widgetClass)
	{
		if (qName.equals(""))
			
			
			throw new IllegalArgumentException("qName must not be empty.");

		if (widgetClass == null)
		{
			throw new IllegalArgumentException("widgetClass");
		} else
		{
			modelMapping.put(qName, modelClass);
			widgetMapping.put(modelClass, widgetClass);
			return;
		}
	}
	static 
	{
	
		register("view", cn.iolove.lui.view.LuiView.class, cn.iolove.lui.model.AbstractModel.class);
	}

}
