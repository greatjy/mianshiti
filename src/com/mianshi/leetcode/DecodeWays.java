package com.mianshi.leetcode;

public class DecodeWays
{
	public static void main(String[] args)
	{
		String string ="501";
		System.out.println(numDecodings(string));
	}
	 public static int numDecodings(String s)
	    {
	             if(s.length() == 0 || s== null || s == "0")
	            return 0;
	        int length = s.length();
	        int[] dp = new int[length+1];
	        dp[0] = 1;//代表着一种策略 
	        if(isValid(s.substring(0,1)))
	            dp[1] = 1;
	        else
	            dp[1] = 0;
	        for(int i=2;i<=length;i++)
	        {
	            if(isValid(s.substring(i-1,i)))
	                dp[i] += dp[i-1];
	            if(isValid(s.substring(i-2,i)))
	                dp[i]+= dp[i-2];
	        }
	        return dp[length];
	    }
	    public static boolean isValid(String s)
	    {
	        if(s.charAt(0) == '0')
	            return false;
	        int ans = Integer.parseInt(s);
	        return ans >= 0 && ans<=26;
	    }
}
