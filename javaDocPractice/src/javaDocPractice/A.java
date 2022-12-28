package javaDocPractice;

class Z implements Runnable
{
	@Override
	public void run()
	{
		for(int playing=1;playing<=10;playing++)
		{
			System.out.println("Playing..." + playing);
		}
	}
}

public class A implements Runnable
{
	@Override
	public void run() 
	{
       download();
	}
	
	
	public void download()
	{
		for(int download=1;download<=10;download++)
		{
			System.out.println("downloading..........."+download);
		}
	}
	
    public static void main(String[] args) throws InterruptedException 
    {
    	
    	System.out.println("------application started -----------");
        
    	Thread th = new Thread(new A());
    	th.setDaemon(true);
    	th.start();
    	
    	for(int task=1;task<=10;task++)
    	{
    		System.out.println("task is running " +task );
    	}
    	
    	Thread th1 = new Thread(new Z());
    	th1.setDaemon(true);
    	th1.start();
    	
    	System.out.println("---------application finished-------");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
//        Thread th = new Thread(new A());
//        th.start();
//        System.out.println(th.currentThread().getName() +" fisrt running");
//        
//        
//        Thread thh = new Thread(new A());
//        System.out.println(thh.currentThread().getName() +" second running");
//     //-----------------------------   
//        Runnable r = new Runnable() {
//			
//			@Override
//			public void run() {
//                System.out.println("inside anonymoys run");	
//			}
//		};
//		Thread th1 = new Thread(r);
//		th1.start();
//		
//	//-------------------------------
//		Runnable r1 = ()->{System.out.println("inside lamda runnable");};
//		Thread th2 = new Thread(r1);
//
//		th1.setDaemon(true);
    }


}

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
   


