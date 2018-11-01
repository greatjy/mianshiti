package com.mianshi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class QuanPaiLie
{
    public static void main(String[] args)
	{
		int[] nums = {1,2,3};
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		allPaiLie(res,nums,0);
		System.out.println(res);
	}
    
    public static void allPaiLie(List<List<Integer>> res,int[] nums,int i)
    {
    	//传入的i参数代表了 前面的i位数字已经排好列了
    	
    	//递归终止条件，当排好序的位数 等于 数组的长度
    	if(i == nums.length)
    	{
    		ArrayList<Integer> al = new ArrayList<Integer>();
    		for(int k=0;k<nums.length;k++)
    		{
    			al.add(nums[k]);   		
    		}
    		res.add(al);
    		return;
    	}
        for(int j=i;j<nums.length;j++)
        {
        	//首先交换 i，j位 
        	swap(nums, i, j);
        	allPaiLie(res, nums, i+1);
        	System.out.println(res+" "+i+" "+j);
        	swap(nums, i, j);
        }    	
    }
    
    public static void swap(int[] nums,int i,int j)
    {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
