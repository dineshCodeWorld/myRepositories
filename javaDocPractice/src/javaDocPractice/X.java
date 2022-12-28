package javaDocPractice;

class Y
{
   public static void show(int numberOfCopies,String s)
   {
	   for(int i=0;i<=numberOfCopies;i++)
	   {
		   System.out.println(s + i);
	   }
   }
}

class T1 extends Thread
{
	Y y;
	
	T1(Y y)
	{
		this.y =y;
	}
	
	@Override
	public void run()
	{
		synchronized (y) {
			y.show(10, "Thread T1 with copy number: ");
		}
	}
}
 class T2 extends Thread
{
	 Y y;
	 T2(Y y)
	 {
		 this.y = y;
	 }
	 
   @Override
   public void run()
   {
		synchronized (y) {
	   y.show(10, "Thread T2 woth Copy number: ");
		}
   }
}


public class X {

	public static void main(String[] args) throws InterruptedException
	{
   System.out.println("====application started=====");
   Y y1 = new Y();
   T1 t1 = new T1(y1);
   
   T2 t2 = new T2(y1);
   t1.start();
   t2.start();
   System.out.println("====application ended======");

	}

}
