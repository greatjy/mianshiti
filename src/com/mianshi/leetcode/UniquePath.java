package com.mianshi.leetcode;

public class UniquePath
{
    public static void main(String[] args)
	{
		int m = 3;
		int n = 7;
		System.out.println(uniquePath(m, n));
	}
    public static int uniquePath(int m,int n)
    {
    	int[][] dp = new int[m][n];
    	dp[0][0] = 1;
    	for(int i=1;i<n;i++)
    	{
    		dp[0][i] = 1;
    	}
    	for(int i=1;i<m;i++)
    	{
    		dp[i][0] = 1;
    	}
    	for(int i=1;i<m;i++)
    	{
    		for(int j=1;j<n;j++)
    		{
    			dp[i][j] = dp[i-1][j]+dp[i][j-1];
    		}
    	}
    	return dp[m-1][n-1];
    }
}
