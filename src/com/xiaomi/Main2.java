package com.xiaomi;

import java.util.Scanner;

public class Main2
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[] zichan = new int[n];
		int[] value = new int[n];
		for(int i=0;i<n;i++)
		{
			zichan[i] = in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			value[i] = in.nextInt();
		}
		int ans = solution(m, n, zichan, value);
		System.out.println(ans);
	}

	private static int solution(int m,int n,int[] zichan,int[] value)
	{
		// dp 表示前i件物品中 总额度为m时的最大价值
		/*String[] array = _data.split(",");
		int m = Integer.valueOf(array[0]);
		int n = Integer.valueOf(array[1]);
		String[] wupin = array[2].split(" ");
		String[] jiazhi = array[3].split(" ");
 		int[] zichan = new int[n];
		int[] value = new int[n];
		for(int i=0;i<n;i++)
		{
			zichan[i] = Integer.valueOf(wupin[i]);
		}
		for(int j=0;j<n;j++)
		{
			value[j] = Integer.valueOf(jiazhi[j]);
		}
		*/
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			dp[i][0] = 0;
		for (int j = 0; j < m + 1; j++)
			dp[0][j] = 0;
		for (int i = 1; i < n + 1; i++)
		{
			for (int j = 1; j < m + 1; j++)
			{
				if (zichan[i - 1] <= j)
				{
					//第i件物品到底应不应该拿
					if (dp[i - 1][j] < (dp[i - 1][j - zichan[i - 1]] + value[i - 1]))
						dp[i][j] = dp[i - 1][j - zichan[i - 1]] + value[i - 1];
					else
						dp[i][j] = dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][m];
	}
}
