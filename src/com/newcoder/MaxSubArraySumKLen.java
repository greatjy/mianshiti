package com.newcoder;

public class MaxSubArraySumKLen
{
    public static void main(String[] args)
	{
		int[] arr = {1,23,4,5,6,8,6,4,2,3,45,5};
		int k  = 9;
		System.out.println(maxLen1(arr, k));
    }
    public static int maxLen1(int[] arr,int k)
    {
    	if(arr == null || arr.length == 0)
    	{
    		return 0;
    	}
    	int left = 0;
    	int right = 0;
    	int sum = 0;
    	int len = 0;
    	while(right <= arr.length)
    	{
    		if(sum < k)
    		{    			
    			if(right == arr.length)
			    	 break;
    			sum += arr[right];
    			right++;
    		}
    		else if(sum>k)
    		{
    			sum -= arr[left];
    			left++;
    		}
    		else
    		{
			     len = Math.max(len,right-left);
			     System.out.println("sum="+sum+" "+left+" "+right+" "+len);
			     if(right == arr.length)
			    	 break;
			     sum += arr[right];
			     right++;
			}
    	}
    	return len;
    }
}
