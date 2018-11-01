package com.newcoder;

import java.util.HashMap;
import java.util.Map;

import mianshiti.SumSTwoNum;

public class MaxLenOfSumK
{
    public static void main(String[] args)
	{
	    int[] arr = {1,2,3,4,-1,2,4,-4,2,5,34,2};
	    int k = 9;
	    System.out.println(maxLen2(arr, k));
	}
    public static int maxLen2(int[] arr, int k)
    {
    	Map<Integer, Integer> map = new HashMap<>();
    	map.put(0, -1);
    	int sum = 0;
    	int len = 0;
    	for(int i =0;i<arr.length;i++)
    	{
    		sum += arr[i];
    		if(map.containsKey(sum-k))
    		{
    			len = Math.max(len, i-map.get(sum-k));
    		}
    		if(!map.containsKey(sum))
    		{
    			map.put(sum, i);
    		}
    	}
    	return len;
    }
    
    
}
