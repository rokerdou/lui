package cn.iolove.lui.sandbox;

public class AppSandbox {
	private AppSandboxCallback bs;
	public  interface AppSandboxCallback
	{
		abstract public void pushPage(String obj);
		abstract public void switchPage(String obj);
		abstract public void popPage();
	}
	private AppSandbox(){};
	private static AppSandbox obj=new AppSandbox();
	public static  AppSandbox getInstance(){return obj;}
	public void init(AppSandboxCallback b)
	{
		bs=b;
	
	}
	public void popPage()
	{
		bs.popPage();
	}
	public void switchPage(String obj)
	{
		bs.switchPage(obj);
	}
	public void pushPage(String obj)
	{
		bs.pushPage(obj);
		
		
	}


}
