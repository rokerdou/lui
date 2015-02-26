package cn.iolove.lui.thread;

public class ThreadFactory {

	/**
	 * @param args
	 */
	public static WorkThread getWorkThread()
	{
		return new WorkThread();
		
	}

}
