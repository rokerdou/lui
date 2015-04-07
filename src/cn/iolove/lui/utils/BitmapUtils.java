package cn.iolove.lui.utils;

import java.io.IOException;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.service.ImageService;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.util.Log;

public class BitmapUtils {
	public static synchronized void loadImage(final String path,final int reqHeight,final int reqWidth,final LoadImageListener lis)
	{
		Bitmap bmp = ImageService.imcache.getBitmapFromCache(path);
		if(bmp!=null)
		{
			 Drawable drawable= new BitmapDrawable(bmp);
				

			lis.succeed(drawable);
			return;
		}else
		{
			loadDiskImage(path,reqHeight,reqWidth,lis);
		}
	


	}
	private static void loadDiskImage(final String path,final int reqHeight,final int reqWidth,final LoadImageListener lis)
	{
	ThreadFactory.getWorkThread(new Method() {
			
			@Override
			public void Work() {
				try {
					android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
					options.inJustDecodeBounds = true;
					if(path==null) {lis.fail();return;}
//					BitmapFactory.
					BitmapFactory.Options maskOpts = new BitmapFactory.Options();
					maskOpts.inJustDecodeBounds=true;
					maskOpts.inPreferredConfig = Bitmap.Config.ALPHA_8;

					 Bitmap mask1 = BitmapFactory.decodeStream(RuntimeContext.getInstance().rl.getActivityContext().getAssets().open("lua/"+path), null, maskOpts);
					 maskOpts.inSampleSize = calculateInSampleSize(maskOpts.outWidth,maskOpts.outHeight, reqWidth, reqHeight);				
					 maskOpts.inJustDecodeBounds=false;
					 maskOpts.inPurgeable = true;  
					 maskOpts.inInputShareable = true;  
					 Bitmap mask2 = BitmapFactory.decodeStream(RuntimeContext.getInstance().rl.getActivityContext().getAssets().open("lua/"+path), null, maskOpts);

					 Drawable drawable= new BitmapDrawable(mask2);
					 ImageService.imcache.putBitmapToCache(path, mask2);
					

					lis.succeed(drawable);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lis.fail();
				}
				
			}
		}).start();
	}
	private static int calculateInSampleSize(int srcWidth, int srcHeight,
            int reqWidth, int reqHeight) {
        int inSampleSize = 1;

        if (srcHeight > reqHeight || srcWidth > reqWidth) {
            float scaleW = (float) srcWidth / (float) reqWidth;
            float scaleH = (float) srcHeight / (float) reqHeight;

            float sample = scaleW > scaleH ? scaleW : scaleH;
            // 只能是2的次幂
            if (sample < 3)
                inSampleSize = (int) sample;
            else if (sample < 6.5)
                inSampleSize = 4;
            else if (sample < 8)
                inSampleSize = 8;
            else
                inSampleSize = (int) sample;

        }
        return inSampleSize;
    }
	public static Drawable  formatImage(BitmapDrawable drawable,String imageScale)
	{
		if (imageScale.equals("none"))
			drawable.setGravity(51);
		else
		if (imageScale.equals("center"))
			drawable.setGravity(17);
		else
		if (imageScale.equals("fill"))
		{
			drawable.setGravity(119);
		}
		if (imageScale.equals("repeat"))
		{
			drawable.setTileModeXY(android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.REPEAT);
			drawable.setDither(true);
		} 
		return drawable;
		
		
	}
}
