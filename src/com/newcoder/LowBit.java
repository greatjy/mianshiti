package com.newcoder;

import java.awt.print.Printable;
import java.util.Scanner;

public class LowBit
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String string  = in.nextLine();
		//int len = string.length();
		if(string == null || string.length() == 0)
			System.out.println(0);
		if(string.length() == 1)
		{
			if(string.equals("0"))
				System.out.println(1);
			else
				System.out.println(0);
		}
		System.out.println(fn(string,0));
	}

	private static long fn(String string,long ans)
	{
		// TODO Auto-generated method stub
	    if(string.length() == 2)
	    {
	    	if(string.equals("00"))
	    	{
	    		ans += 0;
	    		return ans;
	    	}
	    	else if(string.equals("01") || string.equals("10"))
	    	{
	    		ans += 1;
	    		return ans;
	    	}
	    	else {
			    ans += 2;
			    return ans;
			}	
	   
	   }
	   if(string.charAt(0) == '1')
	   {
		   ans += Math.pow(2,string.length()-1);
		   ans -= Math.pow(2, string.length()-3);
	   }
	   //System.out.println("cishide ans=" + ans);
	   string = string.substring(1, string.length());
	   return fn(string,ans);
	}   
}
