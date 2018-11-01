package com.newcoder.tobat;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindow
{
    public static void main(String[] args)
	{
		int[] array = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> list = findMaxInWindow(array,3);
		System.out.println(list);
	}

	private static ArrayList<Integer> findMaxInWindow(int[] array,int size)
	{
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(array == null || array.length == 0 || size <= 0 || size > array.length) 
		{
			return res;
		}
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<array.length;i++)
		{
			if(!queue.isEmpty())
			{
				if(i >= queue.peek()+size)
				{
					queue.poll();
				}
				
				while(!queue.isEmpty() && array[queue.getLast()] <= array[i])
				{
					//当当前插入的数字大于队尾的元素的时候
					//移除队尾元素，这就是必须使用双端队列的原因
					queue.removeLast();
				}
			}
			queue.offer(i);
			
			if(i+1>=size)
			{
				res.add(array[queue.peek()]);
			}
		}
		
		return res;
	}
}
