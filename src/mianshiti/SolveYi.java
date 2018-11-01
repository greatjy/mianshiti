package mianshiti;

import java.util.Scanner;

public class SolveYi
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i =0;i<n;i++)
		{
			x[i] = in.nextInt();
		}
		for(int i =0;i<n;i++)
		{
			y[i] = in.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++)
		{
			if((x[i]+y[i]-2)<min)
			{
				min = x[i]+y[i]-2;
			}
		}
		System.out.println(min);
	}
}

