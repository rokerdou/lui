package cn.iolove.lui.utils;

import java.io.IOException;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.service.PageService;
import cn.iolove.lui.thread.Method;
import cn.iolove.lui.thread.ThreadFactory;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;

public class BitmapUtils {
	public static void loadImage(final String path,final LoadImageListener lis)
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
//					bitmap.compress(Bitmap.CompressFormat.PNG, 90, );
					 Bitmap mask2 = BitmapFactory.decodeStream(RuntimeContext.getInstance().rl.getActivityContext().getAssets().open("lua/"+path), null, maskOpts);
					 
					 Drawable drawable= new BitmapDrawable(mask2);
					

					lis.succeed(drawable);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lis.fail();
				}
				
			}
		}).start();


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
