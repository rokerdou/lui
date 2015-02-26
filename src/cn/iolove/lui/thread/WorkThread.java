package cn.iolove.lui.thread;

/*
 getWorkThread.setMehod(new WorkThread.Method)
 */
public class WorkThread extends Thread {


	public Method m;
	public boolean busy;
	public Thread setMehod(Method ms)
	{
		m=ms;
		return this;
		
	}
	public void run()
	{
		busy=true;
		m.Work();
		busy=false;
		
		
	}
	
	

}
