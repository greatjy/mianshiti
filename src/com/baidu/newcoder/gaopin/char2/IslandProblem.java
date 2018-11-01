package com.baidu.newcoder.gaopin.char2;

import javax.management.relation.InvalidRoleInfoException;

public class IslandProblem
{
    public static void main(String[] args)
	{
		int[][] arr = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 1, 1, 1, 0, 1, 1, 1, 0 }, 
		        { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
		        { 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
		        { 0, 0, 0, 0, 0, 1, 1, 0, 0 }, 
		        { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
		        { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(islandAccount(arr));
	}
    
    public static int islandAccount(int[][] arr)
    { 
    	if(arr == null || arr.length == 0 || arr[0].length == 0)
    		return 0;
    	int N = arr.length;
    	int M = arr[0].length;
    	int res = 0;
    	for(int i=0;i<N;i++)
    	{
    		for(int j=0;j<M;j++)
    		{
    			if(arr[i][j] == 1)
    			{
    				res++;
    			    inflect(arr, i, j, N, M);
    			}
    		}   		
    	}   
    	return res;
    }
    
    public static void inflect(int[][] m,int i,int j,int N,int M)
    {
    	if(i<0 || i>=N || j>=M || j<0 || m[i][j] != 1)
    	{
    		return;
    	}
    	m[i][j] = 2;//infected
    	inflect(m, i+1, j, N, M);
    	inflect(m, i-1, j, N, M);
    	inflect(m, i, j+1, N, M);
    	inflect(m, i, j-1, N, M);
    }
}
