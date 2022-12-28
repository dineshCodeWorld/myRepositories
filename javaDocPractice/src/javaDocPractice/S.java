package javaDocPractice;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class S {
	Object object = null;
	
	public synchronized void setObject(Object object)
	{
		this.object = object;
	}
	
	public synchronized Object getObject()
	{
		return this.object;
	}
	
//	public void setObj(Object o)
//	{
//		synchronized (this) {
//			this.object = o;
//		}
//	}
//	
//	public Object getObj()
//	{
//		synchronized (this) {
//			return this.object;	
//		}
//	}

	public static void main(String[] args) throws InterruptedException 
	{
		S s = new S();
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             	for(int i=0;i<1000;i++)
             	{
             		s.setObject(i);
             	}
			}
		});

		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public synchronized void run() {

				for(int i=0;i<1000;i++)
				{
                 System.out.println(s.getObject());
				}
			}
		});
		th.start();
		th1.start();
		

	}

}
