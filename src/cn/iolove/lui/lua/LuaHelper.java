package cn.iolove.lui.lua;

import org.keplerproject.luajava.JavaFunction;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

import android.util.Log;

import cn.iolove.domain.LuaData;
import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.utils.Utils;

public class LuaHelper {

	public  synchronized static LuaObject[] excuteLuaFunction(LuaState ls ,String mehodName,Object[] args,int returnnumber)
	{
		LuaState l = ls.newThread();
		
		int top = l.getTop();
	try {
			
			
			l.getField(LuaState.LUA_GLOBALSINDEX, mehodName);
			int i=0;
			for(i=0;i<args.length;i++)
			{
	
				l.pushObjectValue(args[i]);
			}
			int status = l.pcall(args.length, returnnumber, 0);
			if(status!=0)
			{
				throw new LuaException(l.toString(-1));
			}
			LuaObject[] returns = new  LuaObject[returnnumber];
			for(i=-1;i>=(0-returnnumber);i--)
			{
				
				returns[0-i-1]=l.getLuaObject(i);
			}
			
			l.setTop(top);
			return returns; 
			
		} catch (LuaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RuntimeContext.showLuaError(l.toString(-1));
			
		}finally
		{
			l.setTop(top);
			
		}
		return null;
		
	}
	public static void setGlobalObject(LuaState mLuaState,String name,Object obj)
	
	{
		//mLuaState.pushObjectValue(obj);
		
		mLuaState.pushJavaObject(obj);

		mLuaState.setGlobal(name);
	}
	public static LuaData toLuaDataByLuaScript(LuaState l,LuaObject obj)
	{
		LuaObject rs;
		rs = (excuteLuaFunction(l,"table2json",new Object[]{obj},1))[0];
		return Utils.getMap4Json(rs.getString());
	}
	public static LuaData loadScript(LuaState l,String pagename)
	{
	
		int error = l.LdoString(Utils.loadAssetsString("framework/ui.lua",RuntimeContext.context)+Utils.loadAssetsString("lua/"+pagename+".lua",RuntimeContext.context));
		if(error!=0)
		{
			RuntimeContext.showLuaError(l.toString(-1));
			RuntimeContext.showLuaError(l.dumpStack());
			

		}
		LuaObject obj = (excuteLuaFunction(l,"onCreated",new Object[]{},1))[0];
		LuaObject rs;

		
			rs = (excuteLuaFunction(l,"table2json",new Object[]{obj},1))[0];

		if(rs.isString())
		{
			rs.getString();
			Log.i("lui", "get luaUIJson :" +rs.getString());
			//RuntimeContext.getInstance().showLuaError(rs.getString());
			return Utils.getMap4Json(rs.getString());
			
		}

		
		return null;
		
	}

}
