package com.baidu.newcoder.gaopin.char2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.management.monitor.CounterMonitor;

import org.w3c.dom.css.ElementCSSInlineStyle;

// TODO 我的设想 是其余数字 cn2 + 2n 倒数第二是 cn2 + n/ cn2 + 2n
//  倒数第一个数字是cn2 n是每个数字出现的次数
public class ProtectCity
{
    public static void main(String[] args)
	{
		
	}
    
    public static class Pair {
		public int value;
		public int times;

		public Pair(int value) {
			this.value = value;
			this.times = 1;
		}
	}
    
    public static long cn2(int n)
    {
    	return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }
    
    public static int findWays(int[] arr)
    {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	HashSet<Integer> set = new HashSet<>();
    	for(int i=0;i<arr.length;i++)
    	{
    	    if(set.contains(arr[i]))
    	    {
    	    	int count = map.get(arr[i]);
    	    	count ++;
    	    	map.put(arr[i],count);
    	    }
    	    else
    	    {
    	    	map.put(arr[i],1);
    	    }
    	}
    	int size = map.size();
    	int[][] count = new int[size][2];
    	int i =0;
     	Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
    	while(iterator.hasNext())
    	{
    		Map.Entry<Integer, Integer> entry=iterator.next(); 
    		count[i][0] = entry.getKey();
    		count[i][1] = entry.getValue();
    		i++;
    	}
    	if(count.length == 1)
    	{
    		return (int) cn2(count[0][1]);
    	}
    	if(count.length == 2)
    	{
    		if(count[0][0] > count[1][0])
    		{
    			if(count[0][1] == 1)
    			{
    				return (int) (cn2(count[1][1]) + count[1][1]);
    			}
    			else
    			{
    				return (int) (cn2(count[1][1]) + count[1][1]*2);
    			}
    		}
    		else
    		{
    			if(count[1][1] == 1)
    			{
    				return (int) (cn2(count[0][1]) + count[0][1]);
    			}
    			else
    			{
    				return (int) (cn2(count[0][1]) + count[0][1]*2);
    			}
    		}
    	}
    	
    	int max = Math.max(count[0][0], count[1][0]);
    	int sec = Math.min(count[0][0], count[1][0]);
    	
    	for(int j=2;j<count.length;j++)
    	{
    		if(count[i][0]>max)
    		{
    			sec = max;
    			max = count[i][0];
    		}
    		else if(count[i][0]>sec)
    		{
    			sec = count[i][0];
    		}
    	}
    	return 0;
    }
}
