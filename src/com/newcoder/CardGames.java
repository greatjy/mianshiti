package com.newcoder;

import java.time.chrono.MinguoChronology;
import java.util.function.IntPredicate;

import javax.print.attribute.standard.RequestingUserName;

public class CardGames
{
	public static void main(String[] args)
	{
		int[] arr = {26,51,91,97,28,84};
		System.out.println(cardGame(arr, arr.length));
		//System.out.println(cardGame1(arr, arr.length));
	}
	public static  int cardGame(int[] A, int n)
    {
        // write code here
        if( n == 0)
            return 0;
        if(n == 1)
            return A[0];
        if(n == 2)
            return Math.max(A[0],A[1]);
        int[][] dp = new int[n][n];
        int sum = 0;
        for(int i = 0;i<n;i++)
        {
            dp[i][i] = A[i];
            sum+=A[i];
        }
        System.out.println("sum="+sum);
        for(int i=0;i<n-1;i++)
        {
            dp[i][i+1] = Math.max(A[i],A[i+1]);
        }
        for(int j=2;j<n;j++)
        {
        	for(int i=0;i<n-j;i++)
        	{
        		 dp[i][i+j] = Math.max((A[i]+Math.min(dp[i+1][j-1+i],dp[i+2][j+i])),
                         A[i+j]+Math.min(dp[i][j-2+i],dp[i+1][i+j-1]));
        	}
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		System.out.print(dp[i][j]+" ");
        		if(j == n-1)
        		{
        			System.out.println();
        		}
        	}
        }
        return Math.max(dp[0][n-1],sum-dp[0][n-1]);
    }
	public static int cardGame1(int[] A,int n)
	{
		    if( n == 0)
	            return 0;
	        if(n == 1)
	            return A[0];
	        if(n == 2)
	            return Math.max(A[0],A[1]);
	        int[][] f = new int[n][n];
	        int[][] s = new int[n][n];
	        for(int i=0;i<n;i++)
	        {
	        	f[i][i] = A[i];
	        }
	        for(int j=1;j<n;j++)
	        {
	        	for(int i=0;i<n-j;i++)
	        	{
	        		f[i][i+j] = Math.max(A[j+i]+s[i][j-1+i], s[i+1][j+i]+A[i]);
	        		s[i][i+j] = Math.min(f[i][i+j-1], f[i+1][j+i]);
	        	}
	        }
	        for(int i=0;i<n;i++)
	        {
	        	for(int j=0;j<n;j++)
	        	{
	        		System.out.print(f[i][j]+" ");
	        		if(j == n-1)
	        		{
	        			System.out.println();
	        		}
	        	}
	        }
	        for(int i=0;i<n;i++)
	        {
	        	for(int j=0;j<n;j++)
	        	{
	        		System.out.print(s[i][j]+" ");
	        		if(j == n-1)
	        		{
	        			System.out.println();
	        		}
	        	}
	        }
	        return Math.max(f[0][n-1], s[0][n-1]);
	}
}
