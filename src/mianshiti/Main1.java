package mianshiti;

import java.util.Scanner;

public class Main1
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n < 2 )
		{
			System.out.println(0+" "+0);
		}
		else if(n == 2)
		{
			System.out.println(1+" "+0);
		}
		else
		{
			System.out.println(3*(n-2)+" "+(3*n-8));
		}		
	}

}
