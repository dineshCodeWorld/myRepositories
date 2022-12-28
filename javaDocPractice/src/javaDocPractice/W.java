package javaDocPractice;

class V extends W
{
	public void run()
	{
		try {
			m1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class W implements Runnable
{
	   public void m1() throws InterruptedException 
	   {	
	      int[] i = {0,1,2,3,4,5,6,7,8,9};
	      for(int j=0;j<i.length;j++)
	      {
	    	  if(Thread.interrupted())
	    	  {
					System.out.println("interepted");
	    	  }
		    	  Thread.sleep(100);
		    	  System.out.println(i[j]);
	      }
	   }
	
	@Override
	public void run(){
		try {
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
       Thread th1 = new Thread(new V(),"");
       th1.join();
       th1.start();
		
		Thread th = new Thread(new W());
		th.setDaemon(true);
		th.start();
		
		W w = new W();
		w.m1();
		

        
	}



}
