package com.baidu.newcoder.gaopin.char2;

import java.util.Scanner;

public class FindMaxSubString
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String temp = in.nextLine();
	    String[] strings = new String[n];
	    for(int i=0;i<strings.length;i++)
	    {
	    	strings[i] = in.nextLine();
	    }
	    String T = in.nextLine();
	    System.out.println(findMaxSubString(strings,T));
	}

	private static int findMaxSubString(String[] strings,String T)
	{
		int count = 0;
		int len = T.length();
		char[] TC = T.toCharArray();
		int i = 0;
		A:while(i<len)
		{
			for(int j=i;j<len;j++)
			{
				if(isContains(TC,i,j,strings))
				{
					count++;
					i = j+1;
					System.out.println(i+" i");
				}
			}
			break A;
		}
		return count;
	}
	private static boolean isContains(char[] Tc,int i,int j,String[] strings)
	{
		String string = new String(Tc,i,j-i+1);
		boolean flag = false;
		for(String s:strings)
		{
			if(string.contains(s))
			{
				flag = true;
				return flag;
			}
		}
		return flag;
	}
}
