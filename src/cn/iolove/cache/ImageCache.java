package cn.iolove.cache;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class ImageCache {
	private LruCache<String, Bitmap> mBitmapCache;
	public ImageCache(int size)
	{
		mBitmapCache=new LruCache<String, Bitmap>(size)
		{
			
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				
				return value.getRowBytes() * value.getHeight()/1024;
			}
			
			
		};
		Log.i("luiImageCache", "ImageCache..create "+size);
		
	}
	public void putBitmapToCache(String key, Bitmap bitmap) { 
	    if (getBitmapFromCache(key) == null) { 
	    	Log.i("luiImageCache", "ImageCache..add "+key);
	    	mBitmapCache.put(key, bitmap); 
	    	Log.i("luiImageCache", "ImageCache"+key+".height "+bitmap.getHeight()+".size "+bitmap.getRowBytes() * bitmap.getHeight());
	    } 
	    
	} 
	public Bitmap getBitmapFromCache(String key) { 
		Bitmap bmp =mBitmapCache.get(key);
		if(bmp!=null)
		Log.i("luiImageCache", "ImageCache..get "+key);
	    return bmp; 
	}
	  
}
