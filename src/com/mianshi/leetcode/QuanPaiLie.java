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
    	//�����i���������� ǰ���iλ�����Ѿ��ź�����
    	
    	//�ݹ���ֹ���������ź����λ�� ���� ����ĳ���
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
        	//���Ƚ��� i��jλ 
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
