package com.newcoder;

import java.util.Scanner;

public class CardGame
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int [] a = new int[3];
		int [] b = new int[3];
		for(int i=0;i<3;i++)
		{
			a[i] = in.nextInt();
		}
		for(int i=0;i<3;i++)
		{
			b[i] = in.nextInt();
		}
		//System.out.println(String.format("%.4f", gailv(a, b)));
		System.out.println(String.format("%.4f", answer(a, b)));
	}
    public static double gailv(int[] a,int[] b)
    { 
    	int suma = 0;
    	int sumb = 0;
    	int[] count = new int[14];
    	for(int i=0;i<=13;i++)
    	{
    		count[i] = 4;
    	}
    	for(int i=0;i<3;i++)
    	{
    		count[a[i]]--;
    		count[b[i]]--;
    	}
    	for(int i=0;i<3;i++)
    	{
    		suma += a[i];
    		sumb += b[i];
    	}
    	//System.out.println(suma+" "+sumb);
    	/*for(int i=0;i<14;i++)
    	{
    		System.out.print(count[i]+" ");
    	}*/
    	if(suma - sumb >= 13)
    	{
    		return 1.0;
    	}
    	if(sumb -suma >=13)
    	{
    		//System.out.println("1");
    		return 0.0;
    	}
    	
    	int number =0;
    	int solve = 0;
    	double result = 0.0;
    	for(int i=1;i<=13&&count[i]!=0;i++)
    	{
    		double p1 = count[i];
    		count[i]--;
    		for(int j=1;j<=13&&count[j]!=0;j++)
    		{
    			if((suma+i)>(sumb+j))
    			{
    				System.out.println(i+" "+j+" "+count[i]+" "+count[j]);
    				result += (p1)*(count[j]);
    			}
    		}
    		count[i]++;
    	}    	    	
    	return result/(46.0*45);
    }
    
    /**
     * 妞妞和妞妞可以取得46张牌，全部方静一个数组中两重循环遍历，总的枚举数目是分母，妞妞获胜
     * 概率为分子，最终结果为分子/分母
     * @return
     */
    public static double answer(int[] a,int[] b)
    {
    	int[] poker = new int[13];
    	int[] remain = new int[46];
    	int sum1 = 0;
    	int sum2 = 0;
    	for(int i=0;i<3;i++)
    	{
    		poker[a[i]] ++;
    		poker[b[i]] ++;
    		sum1 += a[i];
    		sum2 += b[i];    		
    	}
    	int count = 0;
    	double l=0;
    	double r=0;
    	for(int i=0;i<13;i++)
    	{
    		for(int j=0;j<4-poker[i];j++)
    		{
    			remain[count++] = i;
    		}
    	}
    	for(int i=0;i<count;i++)
    	{
    		sum1 += remain[i];
    		for(int j=0;j<count;j++)
    		{
    			if(i == j)
    				continue;
    			sum2+=remain[j];
    			r++;
    			if(sum1>sum2)
    				l++;
    			sum2 -= remain[j];
    		}
    		sum1 -= remain[i];
    	}
    	return l/r;    	
    }
}
