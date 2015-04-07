package cn.iolove.debug;

import android.util.Log;

public class LOG
{
	public static void i(Object obj,String msg)
	{
		if(obj instanceof Class)
		Log.i("lui",((Class) obj).getName()+" "+msg);
		else
		{
			Log.i("lui", obj.getClass().getName()+" "+msg);
		}
	}


}
