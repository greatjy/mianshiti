package com.tiaozhan.char2;

public class PackageProblem
{
    public static void main(String[] args)
	{
		int[] w = {2,1,3,2};
		int[] v = {3,2,4,2};
		int W = 5;
		int value = mostValue(w,v,W);
		System.out.println(value);
	}

	private static int mostValue(int[] w, int[] v,int W)
	{
		int[][] dp = new int[w.length+1][W+1];
		//dp数组用来保存当前可以拿到的最大价值 dp[i][j] 表示在背包容量为j的情况下 在前i件物品中
		//得到的价值的最大值
		//边界条件是dp[0][j] 和 dp[i][0] 都是0 java中数组已经初始化好了
		for(int i=1;i<=w.length;i++)
		{
			for(int j=1;j<=W;j++)
			{
				if(j<w[i-1])
				{
					dp[i][j] = dp[i-1][j];//第i件物品拿不下 只能选择不拿
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
					//分别考虑第i件物品拿还是
					//不拿得到的最大价值的对比
				}
			}
		}
				
		return dp[w.length][W];
	}
    
}
