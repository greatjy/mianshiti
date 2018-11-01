package mianshiti;

import java.util.Scanner;

public class ClassifyId
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	    while (in.hasNext())
		{
			String s = in.nextLine();
			classify(s);			
		}	
	}

	private static void classify(String s)
	{
		int n = s.length();
		if(n<=6)
			System.out.println(s);
		else if(n<=14)
		{
			System.out.print(s.substring(0,6));
			System.out.print(" ");
			System.out.println(s.substring(6));
		}
		else {
			System.out.print(s.substring(0,6));
			System.out.print(" ");
			System.out.print(s.substring(6,14));
			System.out.print(" ");
			System.out.println(s.substring(14));
		}
	}
}
