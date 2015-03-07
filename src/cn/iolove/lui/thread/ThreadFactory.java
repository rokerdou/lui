package cn.iolove.lui.thread;

public class ThreadFactory {

	/**
	 * @param args
	 */
	public static WorkThread getWorkThread(Method m)
	{
		WorkThread obj = new WorkThread();
		obj.setMehod(m);
		return obj;
		
	}

}
