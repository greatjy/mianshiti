package com.newcoder;

import java.nio.file.attribute.AclEntryFlag;
import java.util.Scanner;

public class MaxLenOfDna
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(MaxLenOfDna(s));		
	}

	private static int MaxLenOfDna(String s)
	{
	    int count = 0;
	    int sum = 0;
	    int[] dp = new int[s.length()];
	    for(int i=0;i<s.length();i++)
	    {
	    	if(isValid(s.charAt(i)))
	    	{
	    		count++;
	            sum = Math.max(sum, count);
	    	}
	    	else 
	    	{  
	    		count = 0;
	    	}
	    }
	    return sum;
	}
	
	public static boolean isValid(char c)
	{
		 if(c == 'A' || c == 'T'||c == 'C'
		    		||c == 'G')
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}
    
}
