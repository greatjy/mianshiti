package com.t360;

import java.util.Scanner;

public class MinFeeProblem
{
    public static void main(String[] args)
	{
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] fee= new int[n][n];
        for(int i=0;i<n;i++)
        {
        	for(int j=i;j<n;j++)
        	{
        		fee[i][j] = in.nextInt();
        	}
        }
        int[] dp = new int[n];
        dp[0] = Math.min(fee[0][0],fee[0][1]);
        dp[n-1] = Math.min(fee[n-1][n-1],fee[n-2][n-1]);
        //System.out.println(dp[0]);
        int ans = dp[0];
        for(int i=1;i<n;i++)
        {
        	dp[i] = Math.min(fee[i-1][i], fee[i][i]);
        }
        for(int i=n-2;i>=0;i--)
        {
        	if(Math.min(fee[i][i], fee[i][i+1])<dp[i])
        	{
        		dp[i] = Math.min(fee[i][i], fee[i][i+1]);
        	}
        }
        for(int i=0;i<n;i++)
        {
        	ans+= dp[i];
        }
        System.out.println(ans);
        
	}

}
