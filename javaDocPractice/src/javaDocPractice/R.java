package javaDocPractice;

public class R extends Thread{


	public static void main(String[] args) 
	{
       ThreadLocal<String> tl = new ThreadLocal<>();   
            Thread th = new Thread(()->{tl.set("dinesh");
                                             System.out.println("thread from th "+tl.get());
                                             tl.remove();
                                          });
            
            Thread th1 = new Thread(()->{tl.set("lokesh");
                                         System.out.println("thread from th1 "+tl.get());    
                                         });
            th.start();
            th1.start();
		
		
                              
	}

}
