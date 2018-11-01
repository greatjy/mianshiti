
package com.tiaozhan.char2;

import java.util.Scanner;

public class ProblemCoin
{
    public static void main(String[] args)
	{
		// 共有1、5、10、50 100、500 硬币数枚 现在用他们来支付 A元 最小使用多少硬币？
    	// 测试样例保证至少存在一种支付方案
    	// 时间复杂度 n
    	Scanner in = new Scanner(System.in);
    	int[] v = {1,5,10,50,100,500};
    	int[] count = new int[6];
    	for(int i=0;i<=5;i++)
    	{
    		count[i] = in.nextInt();
    	}
    	int A = in.nextInt();
    	int ans = solve(v,count,A);
    	System.out.println(ans);
	}

	private static int solve(int[] v, int[] count,int A)
	{
	    int ans = 0;
	    for(int i=5;i>=0;i--)
	    {
	    	int t = Math.min(A/v[i],count[i]);//使用硬币i的数量 从大到小
	    	A -= t*v[i];
	    	ans += t;
	    }
		return ans;
	}
}
