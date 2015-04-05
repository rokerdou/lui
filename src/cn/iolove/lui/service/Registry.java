package cn.iolove.lui.service;

import java.util.HashMap;
import java.util.Map;

import cn.iolove.lui.lua.LuaHelper;
import cn.iolove.lui.sandbox.AppSandbox;

public class Registry {

private static Registry obj = new Registry();
private Registry(){}
public static Registry getInstance(){return obj;}
private static  Map ServiceMapping = new HashMap();

public static void register(String qName)
{
	Object obj= ServiceMapping.get(qName);
	LuaHelper.setGlobalObject(PageService.getInstance().getTopPage().getState(), qName, obj);
}
public static void register(String qName,Object obj)
{
	ServiceMapping.put(qName, obj);
	
}
public static void pushServiceInLua()
{
	register("Registry",getInstance());
	register("Registry");
	register("App",AppSandbox.getInstance());
	register("App");
}
static
{
	register("Registry",getInstance());
	register("Registry");
	register("App",AppSandbox.getInstance());
	register("App");

}

}
