package cn.iolove.lui.service;

import cn.iolove.cache.ImageCache;

public class ImageService {
	private static ImageService obj = new ImageService();
	private ImageService(){};
	
	public static ImageCache imcache = new ImageCache(3*1024*1024);
	public ImageService getInstance()
	{
		return obj;
	}

}
