package javaDocPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;


public class O {

	public static void main(String[] args) throws IOException 
	{
//		Properties p = new Properties();
//		p.setProperty("name", "dinesh");
//		System.out.println(p.getProperty("name"));
//		
//		FileOutputStream fo = new FileOutputStream("C:\\ioFiles\\props.txt");
//		p.store(fo, "");
//		fo.close();
//		FileInputStream fi = new FileInputStream("C:\\ioFiles\\props.txt");
//		p.load(fi);
//		System.out.println(p.getProperty("name"));
//		fi.close();
		
//		Map<String, String> m = System.getenv();
//		for(String envName:m.keySet())
//		{
//			System.out.println(envName +"=" +m.get(envName));
//		}
//		System.setProperty("os.name", "Mac 12");
//		Properties p = System.getProperties();
//		System.out.println(p);
//
//		System.getProperty("subliminal.message", "Buy StayPuft Marshmallows!");
//		System.exit(0);
//		
//		System.out.println(System.getSecurityManager());
//		FileReader f = new FileReader("app.properties");
//		
//		Properties p = new Properties();
//		p.load(f);
//		System.out.println(p.propertyNames());
//		System.out.println(p.getOrDefault("user", "root"));
//		Enumeration<?> enumeration = p.propertyNames();
//		while(enumeration.hasMoreElements())
//		{
//			String key = (String)enumeration.nextElement();
//			String value = p.getProperty(key);
//           System.out.println("key = "+key +", value ="+ value);
//		}
//		f.close();
//		
//		Properties p = System.getProperties();
//		Set<String> set = p.stringPropertyNames();
//		Iterator<String> itr = set.iterator();
//		 int i =1;
// 		while(itr.hasNext())
//		{
//			String keys = itr.next();
//			String values = p.getProperty(keys);
//           
//			System.out.println(i+") "+ keys +" ==> "+values);
//			++i;
//			
//		}

//		Properties p = new Properties();
//		p.put("name", "dinesh");
//		p.put("email", "dinesh@gmail.com");
//		p.setProperty("id", "1");//note : put and set works similarly
//		p.setProperty("id", "2");
//		p.put("id", "3");
//	    p.list(System.out);
//		FileOutputStream f = new FileOutputStream("app.properties");
//           p.store(f, "profile");
           
//         System.out.println(System.currentTimeMillis());
//         Date date = new Date(System.currentTimeMillis());
//         System.out.println(date);
		
//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.nanoTime());
      for(String s :args)
      {	
		System.out.println(s);
      }
       long time1 = System.currentTimeMillis();
		int i = 1;
		while(i<1000)
		{
			++i;
		}
		long time2 = System.currentTimeMillis();
		long time3 = time2=time1;
		System.out.println(time3);
		
	}

}
