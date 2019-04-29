package mianshiti;

import java.util.Scanner;

public class IsSubSequence
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String t = in.nextLine();
		System.out.println(isSubsequence(s,t));
	}

	private static String isSubsequence(String s, String t)
	{
		// TODO Auto-generated method stub
		int slen = s.length();
		int tlen = t.length();
		if(slen < tlen)
		{
			return "No";
		}
		if(tlen == 0)
			return "Yes";
		int j = 0;
		for(int i=0;i<tlen;i++)
		{
			char ch = t.charAt(i);
			while(j<slen)
			{
				if(s.charAt(j) == ch)
				{
					if(i == tlen-1)
						return "Yes";
					j++;
					break;
				}
				else
				{
					j++;
				}
			}
			if(j == slen && i<tlen)
				return "No";

		}
		return "Yes";
		
	}
}
