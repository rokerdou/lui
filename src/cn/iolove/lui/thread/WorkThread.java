package cn.iolove.lui.thread;

/*
 getWorkThread.setMehod(new WorkThread.Method)
 */
public class WorkThread extends Thread {


	public Method m;
	public void setMehod(Method ms)
	{
		m=ms;
		
	}
	public void run()
	{
		m.Work();
		
	}
	
	

}
