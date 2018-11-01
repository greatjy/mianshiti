package mianshiti;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MajorityNumber
{ 
    public static void main(String[] args)
	{
    	Scanner in = new Scanner(System.in);
    	String s = in.nextLine();
		String[] ss = s.split(" ");
		int len = ss.length;
		int[] a = new int[len];
		for(int i =0;i<len;i++)
		{
			a[i] = Integer.parseInt(ss[i]);
		}
		//aList.toArray(a);
		//for(int i =0;i<len;i++) System.out.println(a[i]);
		System.out.println(findMajor(a));
	}

	private static int findMajor(int[] a)
	{
		// TODO Auto-generated method stub
		//return null;
		if(a == null || a.length==0 )
		{
			return 0;
		}
		int result = a[0];
		int count = 1;
		for(int i=1;i<a.length;i++)
		{
			if(count>0)
			{
				if(result == a[i])
				{
					count++;
				}
				else
				{
					count--;
				}
			}
			else
			{
				count = 1;
				result = a[i];
			}
		}
		return result;
	}

	
}
