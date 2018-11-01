package com.baidu.newcoder.gaopin.char2;

public class WaterProblem
{
    public static void main(String[] args)
	{
		int[] arr = {3,1,2,4};
		System.out.println(maxWater(arr));
		System.out.println(waterProblem2(arr));
		System.out.println(maxWater1(arr));
	}
    
    public static int maxWater(int[] arr)
    {
    	if(arr == null || arr.length == 0)
    		return 0;
    	int maxValue = 0;
    	for(int i=1;i<arr.length-1;i++)
    	{
    		int maxLeft = 0;
    		int maxRight = 0;
    		for(int l=0;l<i;l++)
    		{
    			maxLeft = Math.max(arr[l], maxLeft);
    		}
    		for(int r=arr.length-1;r>i;r--)
    		{
    			maxRight = Math.max(maxRight, arr[r]);
    		}
    		maxValue += Math.max(0, Math.min(maxLeft, maxRight)-arr[i]);
    	}
    	return maxValue;
    }
    
    //改良版 使用两个数组来记录每一个元素左边和右边的最大值，降低时间复杂度
    public static int waterProblem2(int[] arr)
    {
    	if(arr  == null || arr.length <3)
    		return 0;
    	int[] leftMax = new int[arr.length];
    	int[] rightMax = new int[arr.length];
    	for(int i=1;i<arr.length-1;i++)
    	{
    	    leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
    	}
    	for(int i=arr.length-2;i>=1;i--)
    	{
    		rightMax[i] = Math.max(rightMax[i+1], arr[i+1]);
    	}
    	
    	int maxValue = 0;
    	for(int i=0;i<arr.length;i++)
    	{
    		maxValue += Math.max(0, Math.min(leftMax[i], rightMax[i])-arr[i]);
    	}
    	return maxValue;
    	
    }
    
    //最优解 但是这种思路是根据题目而得出来的 时间复杂度n 空间复杂度 1
    public static int maxWater1(int[] arr)
    {
    	if(arr == null || arr.length <3)
    	{
    		return 0;
    	}
    	
    	int maxValue = 0;
    	int maxLeft = arr[0];
    	int maxRight = arr[arr.length-1];
    	int l = 1;
    	int r = arr.length-1;
    	while(l<=r)
    	{
    		//从左右两边的最大值得较小值 开始向内滑动 直到相遇
    		if(maxLeft<maxRight)
    		{
    			//首先结算当前位置 因为当前位置 可以保证左边的最大值较小
    			maxValue += Math.max(0, maxLeft - arr[l]);
    			
    			//然后更新maxLeft 循环判断左右最大值得较小值
    			maxLeft = Math.max(maxLeft, arr[l]); 
    			
    		// 最后l自增 遍历下一个位置
    			l++;
    		}
    		else
    		{
    			
    			//首先结算当前位置 因为当前位置 可以保证右边的最大值较小
    			maxValue += Math.max(0, maxRight - arr[r]);
    			
    			//然后更新maxLeft 循环判断左右最大值得较小值
    			maxLeft = Math.max(maxRight, arr[r]);
    			r--;
    		}
    	}
    	return maxValue;
    			
    }
}
