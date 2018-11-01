package com.newcoder;

import java.text.FieldPosition;

public class NianZhongJiang
{
    public static void main(String[] args)
	{
		int [][] arr =  {{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,45,6,7},{1,2,35,3,6,4,3},
				{1,2,3,4,5,6},{1,2,34,54,3,2}};
		System.out.println(maxProfit(arr));
	}
    
    public static int maxProfit(int [][] board)
    {
    	int dp[][] = new int[6][6];
    	dp[0][0] = board[0][0];
    	for(int i=1;i<6;i++)
    	{
    		dp[i][0] = board[i][0] + dp[i-1][0];
    		dp[0][i] = board[0][i] + dp[0][i-1];
    	}
    	for(int i=1;i<6;i++)
    	{
    		for(int j=1;j<6;j++)
    		{
    			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+board[i][j];
    		}
    	}
    	return dp[5][5];
    }
}
