package mianshiti;

import java.util.Scanner;

public class GameFlag
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt();
		int n2 = in.nextInt();
		if(!(n1>=1 && n1<= 1024 && n2>=1 && n2 <=1024))
		{
			System.out.println(-1);
		}
		else
		{
			if(n2 == n1)
			{
				System.out.println(1);
			}
			else
			{
				System.out.println(0);
			}
		}
	}
}
