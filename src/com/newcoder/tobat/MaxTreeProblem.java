package com.newcoder.tobat;

import java.awt.Image;
import java.util.Stack;

public class MaxTreeProblem
{
    public static void main(String[] args)
	{
		int[] array = {340,1387,2101,847,1660,733,36,528};
		//int[] res = getMaxTree(array);
		int[] res = buildMaxTree(array);
		//int[] res = buildMaxTree1(array, array.length);
		for(int i: res)
		{
			System.out.print(i+" ");
		}
	}

	private static int[] getMaxTree(int[] array)
	{
		if(array == null || array.length == 0)
		{
			return null;
		}
		int len = array.length;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		
		//单调栈，用来记录左边距离最近的大值，和右边距离最近的大致
		Stack<Integer> stack = new Stack<Integer>();
		int[] res = new int[len];
		for(int i=0;i<len;i++)
		{
			//遍历数组，如果新加入的数字大于栈顶元素，则弹出栈顶元素
			//直到栈顶元素大于当前元素 或者 栈为空
			
			while(!stack.isEmpty() && array[stack.peek()]<array[i])
			{
				System.out.println(stack.peek()+" "+i);
				stack.pop();
			}
			if(stack.isEmpty())
			{
				stack.push(i);
				leftMax[i] = -1;//他的左边没有比他大的值				
			}
			else
			{
				leftMax[i] = stack.peek();//它左边理他最近的比他大的值就是stack的栈顶元素
				stack.push(i);
			}
		}
		stack.clear();
		//清空栈，同样的方法从数组的右边向左边遍历 得到数组的rightMax 数组
        for(int i=len-1;i>=0;i--)
        {
        	while(!stack.isEmpty() && array[stack.peek()] < array[i])
        	{
        		stack.pop();
        	}
        	if(stack.empty())
        	{
        		rightMax[i] = -1;
        	}
        	else
        	{
        		rightMax[i] = stack.peek();
        	}
        	stack.push(i);
        }
        for(int i=0;i<len;i++)
        {
        	if(leftMax[i] == -1 && rightMax[i] == -1)
        	{
        		res[i] = -1;
        	}
        	else if(leftMax[i] != -1 && rightMax[i] == -1)
        	{
        		res[i] = leftMax[i];
        	}
        	else if(leftMax[i] == -1 && rightMax[i] != -1)
        	{
        		res[i] = rightMax[i];
        	}
        	else {
				res[i] = Math.min(leftMax[i], rightMax[i]);
			}
        }
        return res;
	}
	
	public static int[] buildMaxTree(int[] nums)
	{
		if(nums == null || nums.length == 0)
		{
		    return null;
		}
		int len = nums.length;
		Stack<Integer> stack = new Stack<Integer>();
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		int[] res = new int[len];
		for(int i=0;i<len;i++)
		{
		    while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
			{
				stack.pop();
			}
			if(stack.isEmpty())
			{
				leftMax[i] = -1;
			}
			else
			{
			    leftMax[i] = stack.peek();
			}
			stack.push(i);
		}
		stack.clear();
		for(int i=len-1;i>=0;i--)
		{
			while(!stack.isEmpty() && nums[stack.peek()]<nums[i])
			{
				stack.pop();
			}
			if(stack.isEmpty())
			{
				rightMax[i] = -1;
			}
			else
			{
				rightMax[i] = stack.peek();
			}
			stack.push(i);
		}
		for(int i=0;i<len;i++)
		{
			if(leftMax[i] == -1 && rightMax[i] == -1)
			{
				res[i] = -1;
			}
			else if(leftMax[i] == -1 && rightMax[i] != -1)
			{
				res[i] = rightMax[i];
			}
			else if(leftMax[i] != -1 && rightMax[i] == -1)
			{
				res[i] = leftMax[i];
			}
			else
			{
				if(nums[leftMax[i]] < nums[rightMax[i]])
				{
					res[i] = leftMax[i];
				}
				else {
					res[i] = rightMax[i];					
				}
			}
		}
		
		return res;
	}
}
