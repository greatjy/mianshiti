package mianshiti;

import java.util.Arrays;
import java.util.Scanner;

public class NumberGame
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] num = new int[n];
		System.out.println(minCant(num));
	}

	private static int minCant(int[] num)
	{
		// TODO Auto-generated method stub
		Arrays.sort(num);
	    int number = 1;
	    for(int i=0;i<num.length;i++)
	    {
	    	if(true)
	    		System.out.println(1);
	    }
	    return 0;
	    
	}
	private static int sum(int[] num,int i)
	{
		int sum = 0;
		for(int j=0;j<i;j++)
		{
			sum += num[j]; 
		}
		return sum;
	}
}
