package javaDocPractice;

public class U implements Runnable{
	volatile int c= 0;
	@Override
	public  void run()
	{
		if(Thread.interrupted())
		{
			System.out.println("inerepted");
		}
		for(int i=0;i<100000;i++)
		{
		           c++;	
		}
		System.out.println(c);
	}
	
	public static void main(String[] args) 
	{
		Runnable u = new U();
	//	Runnable u1 = new U();
		Thread  th = new Thread(u);
		th.start();
		Thread th1 = new Thread(u);
		th1.start();
		
	}

}
