package javaDocPractice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class P extends Thread{
	
	@Override
	public void run()
	{
		try {
			set(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private long c = 0;
	private Lock lock = new ReentrantLock();
	public void set(int i) throws InterruptedException
	{
		try {
	    lock.lockInterruptibly();
		lock.lock();
		lock.lock();
		for(int j =0;j<i;j++)
		{
		   c++;
		   System.out.println(c);
		}
		}finally {
			lock.unlock();
			lock.unlock();
		}
	}

	public static void main(String[] args) 
	{
		P p = new P();
		
        Thread th = new Thread(p);
        th.start();
        Thread th1 = new Thread(p);
        th1.start();
        Thread th2 = new Thread(p);
        th2.start();
	}

}
