package cn.iolove.cache;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class ImageCache {
	private LruCache<String, Bitmap> mBitmapCache;
	public static Object file=new Object();
	public ImageCache(int size)
	{
		mBitmapCache=new LruCache<String, Bitmap>(size)
		{
			
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				
				return (value.getRowBytes() * value.getHeight());
			}
			
			
		};
		Log.i("luiImageCache", "ImageCache..create "+size);
		
	}
	public void putBitmapToCache(String key, Bitmap bitmap) { 
		synchronized (file) {
			
		
		    if (getBitmapFromCache(key) == null) { 
		    	Log.i("luiImageCache", "ImageCache..add "+key);
		    	mBitmapCache.put(key, bitmap); 
		    	Log.i("luiImageCache", "ImageCache"+key+".height "+bitmap.getHeight()+".size "+ (bitmap.getRowBytes() * bitmap.getHeight())/1024/1024+"MB");
		    } 
		}
	    
	} 
	public Bitmap getBitmapFromCache(String key) { 
		synchronized (file) {
			
		
		Bitmap bmp =mBitmapCache.get(key);
		if(bmp!=null)
		{
			
		Log.i("luiImageCache", "ImageCache used "+mBitmapCache.putCount()*3 +"M");//3 is just avaerage bitmap memory
		Log.i("luiImageCache", "Cache  not used "+mBitmapCache.size()/1024/1024 +"M");
		//Log.i("luiImageCache", "ImageCache..get "+key);
    	Log.i("luiImageCache", "ImageCache get "+key+".height "+bmp.getHeight()+".size "+ (bmp.getRowBytes() * bmp.getHeight())/1024+"KB");
    	Log.i("luiImageCache", "ImageCache hit "+mBitmapCache.hitCount());
       	Log.i("luiImageCache", "ImageCache  not hit "+mBitmapCache.missCount());
          	
    	
		}
		return bmp; 
	}
	}

	  
}
