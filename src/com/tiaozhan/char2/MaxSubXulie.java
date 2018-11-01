package com.tiaozhan.char2;

public class MaxSubXulie
{
    public static void main(String[] args)
	{
		int[] arr = {1,2,-3,5,2,6,3,2};
		System.out.println(solveSubXu(arr));
	}

	private static int solveSubXu(int[] arr)
	{
		int[] dp = new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			dp[i] = 1;//±ß½çÌõ¼þ
			for(int j=0;j<i;j++)
			{
				if(arr[i] > arr[j])
				{
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		int max = 0;
		for(int i=0;i<arr.length;i++)
		{
			max = Math.max(dp[i], max);
		}
		
		return max;
	}
}
