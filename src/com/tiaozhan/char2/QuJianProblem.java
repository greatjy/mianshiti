package com.tiaozhan.char2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class QuJianProblem
{
    public static void main(String[] args)
	{
		//在可选的工作中，每次都选择结束最早的工作
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] start = new int[n];
    	int[] end = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		start[i] = in.nextInt();
    		end[i] = in.nextInt();
    	}
    	
    	/*for(int i=0;i<n;i++)
    	{
    		end[i] = in.nextInt();
    	}*/
    	
    	int res = solve(start,end);
    	System.out.println(res);
	}

	private static int solve(int[] start, int[] end)
	{
		// 在可选的工作中每次都选择结束时间最早的工作
		// 可以将所有的结束时间进行排序
		List<Pair> list = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
        	Pair pair = new Pair(start[i], end[i]);
        	list.add(pair);
        }
        
        Collections.sort(list, new Comparator<Pair>()
		{

        	@Override
			public int compare(Pair o1, Pair o2)
			{
				if(o1.getSecond() > o2.getSecond())
				{
					return 1;
				}
				else
				{
					return -1;
				}
				
			}
        
		});
        System.out.println(list);
        
        int ans = 0;
        int t = 0;
        for(int i=0;i<start.length;i++)        	
        {
             if(t <= list.get(i).getFirst()) //带等于号表示端点可以重复 不带则不行
             {
            	 //寻找结束最早的 可选工作
            	 ans ++;
            	 t = list.get(i).getSecond();
             }
        }
		return ans;
	}
	
}
class Pair
{
    @Override
	public String toString()
	{
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	public int getFirst()
	{
		return first;
	}
	public void setFirst(int first)
	{
		this.first = first;
	}
	public int getSecond()
	{
		return second;
	}
	public void setSecond(int second)
	{
		this.second = second;
	}
	private int first;
    private int second;
	public Pair(int first, int second)
	{
		super();
		this.first = first;
		this.second = second;
	}
    
}
