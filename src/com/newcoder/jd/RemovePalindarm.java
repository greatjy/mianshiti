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
	    			//���������ǰ�涼�������� �������ģ�˵�����滹��ͬ�������������ſ���ƥ�� ���Ծ���size��ѡ��
	    			count *= size;
	    			stack.pop();//����һ���Ѿ�ƥ�䵽������
	    		}
	    	}
	    	return count;
	    }
	}
