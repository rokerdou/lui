package cn.iolove.domain;
public class Device {
	private  static Device obj = new Device();
	public static Device getInstance() {return obj;}
	public int ScreenWidth;
	public int ScreenHeight;
	private Device(){}
	public Device setScreenWidthAndHeight(int w,int h)
	{
		ScreenWidth=w;
		ScreenHeight=h;
		
       return this;	
	}
	public int getScreenWidth()
	{
		return ScreenWidth;
		
	}
	public int getScreenHeight()
	{
		return ScreenHeight;
		
	}

}
