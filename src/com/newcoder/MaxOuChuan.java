package com.newcoder;

import java.util.Scanner;

public class MaxOuChuan
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		System.out.println(maxOuChuan(s));
	}
    public static int maxOuChuan(String s)
    {
    	 for(int i=s.length()-1;i>=0;i--)
    	 {
    		 if(isOuChuan(s.substring(0, i)))
    			 return i;
    		 
    	 }
    	 return 0;
    }
    public static boolean isOuChuan(String s)
    {
    	int len = s.length();
    	if(len%2 != 0)
    		return false;
    	for(int i=0;i<len/2;i++)
    	{
    		if(s.charAt(i)!=s.charAt(i+len/2))
    		{
    			return false;
    		}
    	}
    	return true;
    }
}
