package mianshiti;

import java.util.Arrays;
import java.util.Scanner;

public class SmallestCannotZucheng
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] data = new int[n];
		for(int i=0;i<n;i++)
		{
			data[i] = in.nextInt();
		}
		System.out.println(findSmallestCannot(data));
	}

	private static int findSmallestCannot(int[] data)
	{
		Arrays.sort(data);
		if(data[0] != 1)
		{
			return 1;
		}
		int[] sum = new int[data.length];
		sum[0] = data[0];
		for(int i=1;i<data.length;i++)
		{
			sum[i] = sum[i-1]+data[i];
		}
		for(int i=0;i<data.length-1;i++)
		{
			if((sum[i]+1)<data[i+1])
			{
				return sum[i]+1;
			}
		}
		return sum[data.length-1]+1;
	}
}
