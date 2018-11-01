package com.newcoder.tobat;

import java.util.ArrayList;
import java.util.Stack;

public class StackDemo
{
    public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		reverse(stack);
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		int [] nums= {
			54695,46580,6418,52304,5595,5149,51943,11454,23596,6444,61037,94146,50220,98642,97292,57898,11745,7286,31224,5160,41550,25277,59350,53353,68663,9642,30406,5396,3222,67194,7124,54247,15077,97688,36939,62888,80307,65467,6882,97071,39652,38268,88226,89088,92198,39003,9858,73803,83078,24648,49891,34551,57649,24443,30685,68740,55407,53155,87465,89282,41856,96218,37292,24551,67663,31715,46363,25573,61921,56333,69576,55919,19818,26409,21590,70392,67648,36909,89175,74443,41856,11755,24788,25975,25116,57360,80998,62093,40691,91189,29337,68914,57653,64272,53653,5975,27967,
			59600,25803,13937,93725,26457,16603,18360,79926,63243,94958,45131};
		System.out.println(twoStacksSort(nums));
	}
    
    //得到栈顶元素并将其移除，并返回
    public static int get(Stack<Integer> stack)
    {
    	int result = stack.pop();
    	if(stack.isEmpty())
    	{
    		return result;
    	}
    	else
    	{
    		int last = get(stack);
    		stack.push(result);
    		return last;
    	}
    }
    
    public static void reverse(Stack<Integer> stack)
    {
    	if(stack.isEmpty())
    	{
    		return;
    	}
    	else
    	{
    		int result = get(stack);
    		reverse(stack);
    		stack.push(result);
    	}
    }
    
    public static void sortStack(Stack<Integer> stack)
    {
    	Stack<Integer> stackHelp = new Stack<>();
    	int cur;//用来保存从正常栈中弹出的元素
    	while(!stackHelp.isEmpty())
    	{
    		//直到正常栈的所有元素都被压入到help栈汇总
    		cur = stack.pop();
    		if(stackHelp.isEmpty() || stackHelp.peek() >= cur)
    		{
    			//只有当正常栈中弹出的元素比排序栈的栈顶元素小于等于
    			//直接将元素压入排序栈
    			stackHelp.push(cur);
    		}
    		else
    		{
    			//否则将排序栈中的元素弹出并压回正常栈，直到正常栈刚刚弹出的那个元素
    			//小于或者等于排序栈的栈顶元素 或者排序栈被压空了 
    			//把那个元素压入排序栈（找到了他的位置）
    			while(!stackHelp.isEmpty() && stackHelp.peek()<cur)
    			{
    				stack.push(stackHelp.pop());
    			}
    			stackHelp.push(cur);
    		}
    	}
    	while(!stackHelp.isEmpty())
    	{
    		//将排序栈压入正常栈实现排序
    		stack.push(stackHelp.pop());
    	}
    }
    
    public static  ArrayList<Integer> twoStacksSort(int[] numbers)
    {
        // write code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<numbers.length;i++)
        {
            stack.push(numbers[i]);
        }
        System.out.println(stack.size());
        Stack<Integer> stackHelp = new Stack<Integer>();
        while(!stack.isEmpty())
        {
            int cur = stack.pop();
            if(stackHelp.isEmpty() || stackHelp.peek() >= cur)
            {
                stackHelp.push(cur);
            }
            else
            {
                while(!stackHelp.isEmpty() && stackHelp.peek()<cur)
                {
                    stack.push(stackHelp.pop());
                }
                stackHelp.push(cur);
            }
        }
        System.out.println(stackHelp.size());
        while(!stackHelp.isEmpty())
        {
            list.add(stackHelp.pop());
        }
        return list;
    }

} 
