package com.newcoder;

import java.util.Scanner;

public class maxHappyCoco
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[k];
		int[] b = new int[k];
		int[] buy = new int[k];
		for(int i=0;i<k;i++)
		{
			a[i] = in.nextInt();
			b[i] = in.nextInt();
		}
		int ans = 0;
		for(int i=0;i<k;i++)
		{
			if(m*a[i]+(n-m)*b[i] >= m*a[ans]+(n-m)*b[ans])
			{
				ans =i;
			}
		}
		buy[ans] = n;
		System.out.print(buy[0]);
		for(int i=1;i<k;i++)
		{
			System.out.print(" "+buy[i]);
		}
	}
 
}
