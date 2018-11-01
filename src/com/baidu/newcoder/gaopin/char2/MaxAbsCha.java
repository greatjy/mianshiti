package com.baidu.newcoder.gaopin.char2;

public class MaxAbsCha
{
	 public static void main(String[] args)
		{
			int[] arr = {-1,3,4,-9,1,2};
			System.out.println(maxCha(arr));
			System.out.println(maxCha1(arr));
		}
	 
	    public static int maxCha1(int[] arr)
	    {
	    	if(arr == null || arr.length<=1)
	    		return 0;
	    	int max = Integer.MIN_VALUE;
	    	for(int i=0;i<arr.length;i++)
	    	{
	    		max = Math.max(max, arr[i]);
	    	}
	    	return Math.max(max-arr[0],arr[arr.length-1]);
	    }
	    
	    public static int maxCha(int[] arr)
	    {
	    	if(arr == null || arr.length == 0)
	    		return 0;
	    	int len = arr.length;
	    	int[] left = new int[len];
	    	int[] right = new int[len];
	    	int cur1 = 0;
	    	int max1 = Integer.MIN_VALUE;
	    	for(int i=0;i<len;i++)
	    	{
	    	    max1 = Math.max(max1, arr[i]);
	    	    left[i] = max1;
	    	}
	    	int cur2 = 0;
	    	int max2 = Integer.MIN_VALUE;
	    	for(int i=len-2;i>=0;i--)
	    	{
	    		max2 = Math.max(max2, arr[i]);
	    	    right[i] = max2;
	    	}
	    	int res = 0;
	    	for(int i=0;i<len;i++)
	    	{
	    		res = Math.max(res, Math.abs(left[i]-right[i]));
	    	}
	    	return res;    		    	
	    }
}
