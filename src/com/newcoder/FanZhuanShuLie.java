package com.newcoder;

import java.util.Scanner;

// ����ⷨʱ�临�Ӷȹ���
public class FanZhuanShuLie
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		System.out.println(getres(n,m));
	}
    
    public static int getres(int n,int m)
    {
    	int sum = 0;
    	if(n == m)
    	{
    		for(int i=1;i<=n;i++)
    		{
    			sum-=i;
    		}   		
    	}
    	for(int i=1;i<=n;i++)
		{
			if(((i-1)/m)%2 == 0)
			{
				sum -= i;
			}
			else
			{
				sum += i;
			}
			//System.out.println(sum);
		}
    	
    	return sum;
    }
}
