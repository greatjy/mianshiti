package com.mianshi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForSum
{
    public static void main(String[] args)
	{
		int[] nums = {1,0,-1,0,-2,2,4,6,3,2,6,9,4,0};
		int target = 0;
		System.out.println(fourSum(nums,target));
	}
    
    public static List<List<Integer>> fourSum(int[] nums,int target)
    {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length-3;i++)
    	{
    		//第一个数字
    		if(i>0 && nums[i]==nums[i-1])
    			continue;
    		for(int j=nums.length-1;j>i+2;j--)
    		{
    			//第二个数字
    			if(j<nums.length-1 && nums[j] == nums[j+1])
    				continue;
    			int ab = nums[i] + nums[j];//前两个数字之和 
    			//在剩下的数组中夹逼得到另外两个数字
    			int key = target - ab;
    			int m = i+1;
    			int n = j-1;
    			while(m<n)
    			{
    				int sum = nums[m] + nums[n];
    				if(sum == key)
    				{
    				    ArrayList<Integer> list = new ArrayList<>();
    				    list.add(nums[i]);
    				    list.add(nums[m]);
    				    list.add(nums[n]);
    				    list.add(nums[j]);
    				    res.add(list);
    				    
    				    
    				    while(m<n && nums[m+1] == nums[m])
    				    {
    				    	m++;
    				    }
    				    
    				    m++;
    				    
    				    while(m<n && nums[n-1] == nums[n])
    				    {
    				    	n--;
    				    }
    				    
    				    n--;
    				}
    				else if(sum < key )
    				{
    					//m 过小 造成得到的sum太小
    					m++;
    				}
    				else {
						n--;
					}
    			}
    			
    		}
    	}
    	return res;
    }
}

