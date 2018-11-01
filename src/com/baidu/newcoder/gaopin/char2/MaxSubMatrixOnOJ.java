package com.baidu.newcoder.gaopin.char2;
import java.util.Scanner;
public class MaxSubMatrixOnOJ
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
        	for(int j=0;j<N;j++)
        	{
        		arr[i][j] = in.nextInt();
        	}
        }
        System.out.println(findMaxMatrix(arr,N));        
    }
    public static int findMaxMatrix(int[][] arr,int N)
    {
    	int max = Integer.MIN_VALUE;
    	if(arr == null || arr.length == 0 || arr[0].length == 0)
    	{
    		return 0;
    	}
    	for(int i=0;i<N;i++)
    	{
    		int[] s= new int[N];
    		for(int j=i;j<N;j++)
    		{
    			int cur = 0;
    			for(int k =0;k<N;k++)
    			{
    				s[k] += arr[j][k];
    				cur += s[k];
    				max = Math.max(cur, max);
    				cur = cur<0? 0 : cur;
    			}
    		}
    	}
    	return max;    		
    }
}
    