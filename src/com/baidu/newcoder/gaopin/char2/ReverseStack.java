package com.baidu.newcoder.gaopin.char2;

import java.util.Stack;

public class ReverseStack
{
    public static void main(String[] args)
	{
		
	}
    
    public static void reverse(Stack<Integer> s)
    {
    	if(s == null || s.isEmpty())
    	{
    		return;
    	}
    	int res = getAndRemove(s);
    	reverse(s);
    	s.push(res);
    }
    
    public static int getAndRemove(Stack<Integer> s)
    {
    	int res = s.pop();
    	if(s.isEmpty())
    	{
    		return res;
    	}
    	int last = getAndRemove(s);
    	s.push(res);
    	return last;
    }
}
