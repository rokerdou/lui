package cn.iolove.lui.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.iolove.domain.Device;
import cn.iolove.domain.LuaData;

import android.content.Context;

public class Utils {

	/**
	 * @param args
	 */
	public static LuaData getMap4Json(String jsonString)  {        

		LuaData root = new LuaData();
        JSONObject jsonObject = null;
       
		try {
			jsonObject = new JSONObject(jsonString);

        Iterator keyIter = jsonObject.keys();         
        String key;         
        Object value;         
              
        
        while (keyIter.hasNext()) {         
        	
            key = (String) keyIter.next();   
            if(key.equals("subitems"))
            {
            	JSONArray arr = new JSONArray(jsonObject.get(key).toString());  
            	for (int i = 0; i < arr.length(); i++) {  
            	    JSONObject temp = (JSONObject) arr.get(i);  
            	    root.addChild( getMap4Json(temp.toString()));
            	}  
            
            }
            else
            {
            value = jsonObject.get(key);         
            if(key.toLowerCase().equals("marginleft")||key.toLowerCase().equals("width"))
            {
            	String v = jsonObject.get(key).toString();
            	v=v.substring(0, v.length()-1);
            	int relativev= Integer.parseInt(v);
            	int w=Device.getInstance().getScreenWidth();
            	int realv=(w*relativev)/100;
            	
            	root.addAttrs(key,new Integer(realv).toString());
            }
            else
            	if(key.toLowerCase().equals("margintop")||key.toLowerCase().equals("height"))
            	{
                	String v = jsonObject.get(key).toString();
                	v=v.substring(0, v.length()-1);
                	int relativev= Integer.parseInt(v);
                	int h=Device.getInstance().getScreenHeight();
                	int realv=(h*relativev)/1000;
                	
                	root.addAttrs(key,new Integer(realv).toString());
            		
            	}
            	else

            	root.addAttrs(key, jsonObject.get(key).toString());
            }
        }         
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return root;         
    }         
	public static String loadAssetsString(String resPath,Context co) {
		InputStream isread = null;
		byte[] luaByte = new byte[1];
		try { 
			isread = co.getAssets().open(resPath);
			int len = isread.available();
			luaByte = new byte[len];
			isread.read(luaByte);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (isread != null) {
				try {
					isread.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return EncodingUtils.getString(luaByte, "UTF-8");
	} 
	
}
