package com.t360;

import java.util.Arrays;
import java.util.Scanner;

public class Probelm1
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		//String string = in.nextLine();
		int[] taoqi = new int[N];
		for(int i=0;i<N;i++)
		{
			taoqi[i] = in.nextInt();
			
		}
		Arrays.sort(taoqi);
		int danzhuo = 2*M-N;
		//System.out.println("µ¥×À"+danzhuo);
		if(danzhuo >= N)
		{
			System.out.println(0);
		}
		int[] doublezhuo = new int[(N-M)*2];
		for(int i=0;i<doublezhuo.length;i++)
		{
			doublezhuo[i] = taoqi[i];
		}
		int max = doublezhuo[0] + doublezhuo[doublezhuo.length-1];
		//System.out.println(max+"max");
		for(int i=0;i<=doublezhuo.length/2;i++)
		{
			if(max<(doublezhuo[i]+doublezhuo[doublezhuo.length-i-1]))
			{
				max = doublezhuo[i]+doublezhuo[doublezhuo.length-i-1];
			}
		}
		System.out.println(max);
	}
}
