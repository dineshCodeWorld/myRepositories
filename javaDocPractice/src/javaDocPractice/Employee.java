package javaDocPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Employee implements Serializable{

	int id ;
	String name;

	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
	//	InputStreamReader i = InputStreamReader(System.in);
		
//		Console c = System.console();
//		
//		c.readLine();
		
//		Path p = Paths.get("C:Users\\dinesh");
//		System.out.println(p);
//		
//		File f = new File("D:\\dinesh\\f2.txt");
//		if(f.exists() && f.canExecute() && f.canRead())
//		{	
//		f.delete();
//		System.out.println("success");
//		}else {
//			System.out.println("error");
//		}
//		Path p = Path.of("C:\\ioFiles\\f1.txt");
//		Path p1 = Path.of("D:\\dinesh\\f.txt");
//		// Files.copy(p,p1,StandardCopyOption.REPLACE_EXISTING);
//		 Files.move(p, p1, StandardCopyOption.REPLACE_EXISTING);
//		
		
		
//	String s = "dinesh";
//	System.out.println(s.charAt(-1));
//		
		
		
		
		
		
		
//		FileWriter fw = new FileWriter("D:\\dinesh\\f2.txt");
//		BufferedWriter bw = new BufferedWriter(fw);
//		String sw = "Hello @12345 World.dinesh";
//		bw.write(sw);
//		bw.flush();
//		FileReader fr = new FileReader("D:\\dinesh\\f2.txt");
//		BufferedReader br = new BufferedReader(fr);
////		String sr = new String(br.readLine());
////		System.out.println(sr);
//		Scanner s = new Scanner(br);
//		while(s.hasNext())
//		{
//			System.out.println(s.next());
//		}

		

//		Employee e = new Employee();
		
//		e.id = 1;
//		e.name = "dinesh";
//		
//		try {
//			FileOutputStream = new FileOutputStream("D:\\dinesh\\f1.txt");
//		     ObjectOutputStream o = new ObjectOutputStream(f);
//		     o.writeObject(e);
//		     o.close();
//		     f.close();
//		     System.out.println("object serialized");
//		}catch (IOException e1) {
//         e1.printStackTrace();
//		}
		
//		FileInputStream f = new FileInputStream("D:\\dinesh\\f1.txt");
//        ObjectInputStream o =new ObjectInputStream(f);
//        e = (Employee)o.readObject();
//        System.out.println(e.name);
		
		
		
		
//		File f = new File("D:\\dinesh");
//		if(!f.exists())
//		{
//			if(f.mkdir())//make directory
//			{
//				System.out.println("directory created");
//			}else {
//				System.out.println("failed to create directory");
//			}
//		}else {
//			System.out.println("directory exists");
//		}
//		File f1 = new File("D:\\dinesh\\f.txt");
//		f1.mkdirs();//make directories
//		
//		System.out.println("f1 successfull");
//		
//		for(String s:f.list())
//		System.out.println(s);
//		
//		
		
//		InputStreamReader i = null;
//		try {
//		i = new InputStreamReader(System.in);
//		System.out.println("enter key q to quit");
//		
//		char c;
//		do {
//			c= (char)i.read();
//			System.out.println(c);
//		}while(c!='q');
//		}finally {
//			if(i!=null)
//			{
//				i.close();
//			}
//		}
//		

		
//         FileOutputStream o = new FileOutputStream("C:\\ioFiles\\f1.txt");
//		
//		o.write(65);
//		
//		InputStream i = new FileInputStream("C:\\ioFiles\\f1.txt");
//		System.out.println(i.read());
//       System.out.println("-------------------------------");		
//		String s = "Hello World";
//		o.write(s.getBytes());
////		String s1 = new String(i.readAllBytes());
////		System.out.println(s1);
//		int i1 =0;
//		while((i1=i.read())!=-1)
//		{
//			System.out.print((char)i1);
//		}
//		o.close();
//		i.close();
		

		
//		FileWriter fw = new FileWriter("C:\\ioFiles\\f1.txt");
//		fw.write("Hello World");
//		fw.close();
//		FileReader fr = new FileReader("C:\\ioFiles\\f1.txt");
//		int i =0;
//		while((i=fr.read())!=-1)
//		{
//			System.out.print((char)i);
//		}
		
		
				
		
		
		
//		InputStream i = new FileInputStream("C:/ioFiles/f1.txt");
//		String s = new String(i.readAllBytes());
//		System.out.println(s);
		
	
//		OutputStream o = new FileOutputStream("C:/ioFiles/f2.txt");
//		 o.write(i.readAllBytes());
//			InputStream i1 = new FileInputStream("C:/ioFiles/f2.txt");
//		String s1 = new String(i1.readAllBytes());
//		System.out.println(s1);
//		InputStream i = null;
//		try {
//	    i = new FileInputStream("C:/Users/dinesh/Documents/workspace-spring-tool-suite-4-4.16.1.RELEASE/tesla/tesla.log/spring.txt");
//		String s = new String(i.readAllBytes());
//		System.out.println(s);
//		}finally {
//			i.close();
//		}
		

	}

}
