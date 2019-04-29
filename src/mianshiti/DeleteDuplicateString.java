package mianshiti;

import java.util.HashSet;
import java.util.Scanner;

public class DeleteDuplicateString
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		System.out.println(afterDelete(str1,str2));
	}

	private static String afterDelete(String str1, String str2)
	{
		HashSet<Character> set = new HashSet<>();
		for(int i=0;i<str2.length();i++)
		{
			set.add(str2.charAt(i));
		}
		char[] str = str1.toCharArray();
		for(int i=0;i<str.length;i++)
		{
			if(set.contains(str[i]))
			{
				str[i]='\0';
			}
		}
		String ans = new String(str);
		String[] resString = ans.split("\0");
		StringBuffer result = new StringBuffer();
		for(int i=0;i<resString.length;i++)
		    result.append(resString[i]);
		return result.toString();
	}
}
