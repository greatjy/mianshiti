package com.nowcoder.meituan.codeM;

import java.util.Scanner;

public class QiZi
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];
		for(int i=0;i<n;i++)
		{
			A[i] = in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			B[i] = in.nextInt();
		}
		System.out.println(yiBu(A, B, 0));
	}
    public static int yiBu(int[] A,int[] B,int count)
    {
    	for(int i=0;i<A.length;i++)
    	{
    		if(B[i] > A[i])
    		{
    			int num = B[i] - A[i];
    			for(int j=0;j<A.length;j++)
    			{
    				if(A[j] > B[j])
    				{
    					if(j < i)
    					{
    						int num2 = A[j] - B[j];
    						if(num2 >= num)
    						{
    						    count += (j-0+i)*num;
    						    A[j] -= num;
    						    A[i] += num;
    						    return yiBu(A, B, count);
    						}
    					    else
    					    {
    							count += (j-0+i)*num2;
    						    A[j] -= num2;
    						    A[i] += num2;
    						    return yiBu(A, B, count);
    					    }    						
    					}
    					else if(j>i)
    					{
    						int num2 = A[j] - B[j];
    						if(num2 >= num)
    						{
	    						count +=  (j-i)*num;
	    						A[j] -= num;
	    						A[i] += num;
	    						return yiBu(A, B, count);
    						}
    						else
    						{
    							count += (j-i)*num2;
    							A[j] -= num2;
    							A[i] += num2;
    							return yiBu(A, B, count);
    						}
    					}
    				}
    			}
    		}
    	}
    	return count;
    }
}
