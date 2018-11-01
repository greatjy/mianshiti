package com.newcoder.jd;

	import java.util.Stack;
	
	public class RemovePalindarm
	{
	    public static void main(String[] args)
		{
			String string = "(((())))";
			System.out.println(numberOfRemoveValid(string));
		}
	    
	    public static int numberOfRemoveValid(String s)
	    {
	    	Stack<Character> stack = new Stack<>();
	    	int count = 1;
	    	for(int i=0;i<s.length();i++)
	    	{
	    		if(s.charAt(i) == '(')
	    		{
	    			stack.push(s.charAt(i));
	    		}
	    		if(s.charAt(i) == ')')
	    		{
	    			int size = stack.size();
	    			//这个右括号前面都是左括号 （处理后的）说明后面还有同等数量的有括号可以匹配 所以就有size中选择
	    			count *= size;
	    			stack.pop();//弹出一个已经匹配到的括号
	    		}
	    	}
	    	return count;
	    }
	}
