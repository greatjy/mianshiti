package com.newcoder;

import java.util.Scanner;

public class WorldCup
{
    public static void main(String[] args)
	{
		Scanner in  = new Scanner(System.in);
		double [][] pi = new double[17][17];
		double [][] dp = new double[17][5];
		for(int i=1;i<=16;i++)
		{
			for(int j=1;j<=16;j++)
			{
				pi[i][j] = in.nextDouble(); 
			}
		}
		for(int num = 1;num<=16;num++)
		{
			if(num %2 ==0)
	    	      dp[num][1] = pi[num][num-1];
	    	else
	    		  dp[num][1] = pi[num][num+1];
		}

		for(int i=2;i<=4;i++)
		{
			int sub = 1<<i;
			for(int j=1;j<=16;j++)
			{
				for(int k=1;k<=16;k++)
				{
					if((k-1)/sub == (j-1)/sub)
					{
						//在同一个半区里面
						if((k-1)/(sub/2) != (j-1)/(sub/2))
						{
							//并且是这一轮要相遇 而不是上一轮
							
							//j 和 k 全部晋级 并且 j获胜
							dp[j][i] += dp[j][i-1]*dp[k][i-1]*pi[j][k];
						}
					}
							
				}
			}
		}
		System.out.print(dp[1][4]);
		for(int i=2;i<=16;i++)
		{
			System.out.print(" "+dp[i][4]);
		}
    
	}
}
