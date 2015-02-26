package cn.iolove.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LuaData {

private HashMap hm = new HashMap();
private List subitems = new ArrayList();
public LuaData addChild(LuaData c)
{
	subitems.add(c);
	return c;

}

public boolean hasChild()
{
	return !subitems.isEmpty();
	
}
public HashMap getAttrs()
{
	return hm;
}
public List getChild()
{
	return subitems;
}
public String toString()
{
	String str = new String();
	for (Object key : hm.keySet()) {

	   String  value = (String) hm.get(key);
	   str= str+ " "+key+":"+value;
	}
	for(int i=0;i<subitems.size();i++)
	{
		str= str+" Child_"+i+" {"+subitems.get(i).toString()+"}";
	}
	return str;
	
}

}
