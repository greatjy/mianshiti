package mianshiti;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindBaoShi
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		HashSet<Character> set = new HashSet<>();
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		set.add('E');
		while(in.hasNext())
		{
			String string = in.nextLine();
			int len = string.length();
			int min = len;
			for(int i=0;i<len;i++)
			{
				if(set.contains(string.charAt(i)))
				{
					int count = findAllBaoShi(i,string);
					//System.out.println(count);
					if(count < min)
					{
						min = count;
					}
				}
			}
			System.out.println(len-min);
		}
	}

	private static int findAllBaoShi(int i, String string)
	{
		HashSet<Character> set = new HashSet<>();
		set.add('A');
		set.add('B');
		set.add('C');
		set.add('D');
		set.add('E');
		int count = string.length();
		int ans = 0;
		for(int j = i;j<string.length();j++)
		{
			if(set.contains(string.charAt(j)))
			{
				set.remove(string.charAt(j));
			}
			ans++;
			if(set.isEmpty())
			{
				return ans;
			}
		}
		for(int j=0;j<i;j++)
		{
			if(set.contains(string.charAt(j)))
			{
				set.remove(string.charAt(j));
			}
			ans++;
			if(set.isEmpty())
			{
				return ans;
			}
		}
		return count;
	}
}
