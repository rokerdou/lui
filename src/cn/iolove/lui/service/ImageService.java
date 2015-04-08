package cn.iolove.lui.service;

import cn.iolove.cache.ImageCache;

public class ImageService {
	private static ImageService obj = new ImageService();
	private ImageService(){};
	
	public static ImageCache imcache = new ImageCache((int) (Runtime.getRuntime().maxMemory()/8));
	public ImageService getInstance()
	{
		return obj;
	}

}
