package com.baidu.test;

import java.util.LinkedList;
import java.util.Scanner;

public class TestMushRoom
{
	public static long count = 0;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		backtrace(n, list, m);
		System.out.println((int)(count % (Math.pow(10, 9)+7)));
	}

	public static void backtrace(int n, LinkedList<Integer> list, int m)
	{
		if (list.size() == n)
		{
			count++;
			//System.out.println(list);
			return;
		}
		if (list.size() == n - 1)
		{
			for (int i = 2; i <= m; i++)
			{
				if (i != list.getLast())
				{
					list.add(i);
					backtrace(n, list, m);
					list.removeLast();
				}
			}
		} else
		{

			for (int i = 1; i <= m; i++)
			{
				if (i != list.getLast())
				{
					list.add(i);
					backtrace(n, list, m);
					list.removeLast();
				}
			}
		}
	}
}
