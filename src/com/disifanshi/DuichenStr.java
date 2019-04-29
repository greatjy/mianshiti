package com.disifanshi;

import java.util.Scanner;


public class DuichenStr
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		int len = string.length();
		int[] dp = new int[len];
		dp[0] = 1;
		int max = 1;
		int maxindex = 0;
		for(int i=1;i<len;i++)
		{
		   for(int j=0;j<i;j++)
		   {
			   if(isSyn(string.substring(j,i+1)))
			   {
				   dp[i] = i-j+1;
				   //System.out.println(string.substring(j, i+1)+(i-j+1)+" "+i+" "+dp[i]);
                   break; 
			   }					   
		   }
		}
		for(int i=0;i<len;i++)
		{
			//System.out.println(dp[i]);
			if(dp[i]>max)
			{
				max = dp[i];
				maxindex = i;
			}
		}
	//System.out.println(isSyn("ccbaddabcc"));
		System.out.println(string.substring(maxindex-max+1,maxindex+1));
	}
    public static boolean isSyn(String s)
    {
    	for(int i=0;i<s.length()/2;i++)
    	{
    		if(s.charAt(i) == s.charAt(s.length()-i-1))
    		{}
    		else {
				return false;
			}
           
    	}
    	return true;
    }
}
