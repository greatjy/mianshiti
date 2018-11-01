
package com.tiaozhan.char2;

import java.util.Scanner;

public class ProblemCoin
{
    public static void main(String[] args)
	{
		// ����1��5��10��50 100��500 Ӳ����ö ������������֧�� AԪ ��Сʹ�ö���Ӳ�ң�
    	// ����������֤���ٴ���һ��֧������
    	// ʱ�临�Ӷ� n
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
	    	int t = Math.min(A/v[i],count[i]);//ʹ��Ӳ��i������ �Ӵ�С
	    	A -= t*v[i];
	    	ans += t;
	    }
		return ans;
	}
}
