package com.newcoder;

import java.util.Scanner;

public class MeituanChoubin
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] product = new int[n][2];
		for(int i=0;i<n;i++)
		{
			product[i][0] = in.nextInt();
			product[i][1] = in.nextInt();
		}
		int[][] manjian = new int[m][2];
		for(int i=0;i<m;i++)
		{
			manjian[i][0] = in.nextInt();
			manjian[i][1] = in.nextInt();
		}
		double minPrice = calMin(product,manjian);
		System.out.println(String.format("%.2f", minPrice));
	}

	public static double calMin(int[][] product, int[][] manjian)
	{
		double buManJian = 0;
		for(int i=0;i<product.length;i++)
		{
			if(product[i][1] == 1)
			{
				buManJian += product[i][0]*0.8; 
			}
			else
			{
				buManJian += product[i][0];
			}
		}
		double manji = 0;
		for(int i =0;i<product.length;i++)
		{
			manji += product[i][0];
		}
		double sum = manji;
		for(int i=0;i<manjian.length;i++)
		{
			if(manjian[i][0] <= sum)
			{
				sum -= manjian[i][1];
				if( sum < manji)
				{
				      manji = sum;
				}
			}
			sum += manjian[i][1];
		}
		
		return Math.min(buManJian, manji);
		
	}
}
