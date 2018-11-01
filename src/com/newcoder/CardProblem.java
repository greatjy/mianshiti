package com.newcoder;

import java.util.Arrays;
import java.util.Scanner;

public class CardProblem
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] A = new int[N];
		for(int i=0;i<N;i++)
		{
			A[i] = in.nextInt();
		}
		System.out.println(calSub(A));
	}
    public static int calSub(int[] A)
    {
    	Arrays.sort(A);
    	int sum = 0;
    	if(A.length %2 ==0)
    	{
	    	for(int i=0;i<A.length;i++)
	    	{
	    		if(i%2 == 0)
	    		{
	    			sum-= A[i];
	    		}
	    		else
	    		{
	    			sum+=A[i];
	    		}
	    	}
    	}
    	else
    	{
    		for(int i=0;i<A.length;i++)
    		{
    			if(i%2 == 0)
	    		{
	    			sum+= A[i];
	    		}
	    		else
	    		{
	    			sum-=A[i];
	    		}
    		}
    	}
    	return sum;
    }
}
