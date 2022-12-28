package javaDocPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {

	public static void main(String[] args) 
	{
//      String regex = "[A-Z]{3}";
//      Pattern p = Pattern.compile(regex);
//      String input = "HII";
//      Boolean b  = Pattern.matches(regex, input);
//      System.out.println(b);
		
//		String regex = "[a-z]";
//		Pattern p = Pattern.compile(regex,Pattern.DOTALL);
//		String input = "G";
//		Matcher matcher = p.matcher(input);
//		int n =0;
//		while(matcher.find())
//		{
//			++n;
//		}
//		System.out.println("number of matches " + n);
		
		String regex = "\\d";
		regex.matches(regex);
		String input = "hi1hello2world";
		Pattern pattern = Pattern.compile(regex);
		String[] s = pattern.split(input);
        for(String s1 : s)
        {
        	System.out.println(s1);
        }

	}

}
