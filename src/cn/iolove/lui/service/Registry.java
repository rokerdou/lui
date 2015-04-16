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
public RegistryAdapter a=null;
public  interface  RegistryAdapter
{
	public void addRegister(Registry r);
}
public void  bindAdapter(RegistryAdapter adp)
{
	a=adp;
	
}

public  void registerInlua(String qName)
{
	Object obj= ServiceMapping.get(qName);
	LuaHelper.setGlobalObject(PageService.getInstance().getTopPage().getState(), qName, obj);
}
public  Object register(String qName)
{
	Object obj= ServiceMapping.get(qName);
	return obj;

}
public  void register(String qName,Object obj)
{
	ServiceMapping.put(qName, obj);
	
}
public  void pushServiceInLua()
{
	register("Registry",getInstance());
	registerInlua("Registry");
	register("App",AppSandbox.getInstance());
	registerInlua("App");
	if(a!=null)
	a.addRegister(obj);
}


}
