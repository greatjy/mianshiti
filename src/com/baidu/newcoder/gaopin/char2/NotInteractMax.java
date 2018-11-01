package com.baidu.newcoder.gaopin.char2;

public class NotInteractMax
{
    public static void main(String[] args)
	{
		int[] arr = {-1,3,4,-9,1,2};
		System.out.println(maxNotInterSubArray(arr));
	}
    
    public static int maxNotInterSubArray(int[] arr)
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
    	    cur1 += arr[i];
    	    max1 = Math.max(max1,cur1);
    	    left[i] = max1;
    	    cur1 = cur1 < 0 ? 0 : cur1;
    	    System.out.println("left[]"+i+" "+left[i]);
    	}
    	int cur2 = 0;
    	int max2 = Integer.MIN_VALUE;
    	for(int i=len-2;i>=0;i--)
    	{
    		cur2 += arr[i+1];
    		max2 = Math.max(max2, cur2);
    		right[i] = max2;
    		cur2 = cur2<0 ? 0:cur2;
    		System.out.println("right[]"+i+" "+right[i]);
    	}
    	int res = 0;
    	for(int i=0;i<len;i++)
    	{
    		res = Math.max(res, left[i]+right[i]);
    	}
    	return res;    	
    	
    }
}
