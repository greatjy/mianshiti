package mianshiti;

import java.util.Scanner;

public class BuyApple
{
   //±¨À—Ω‚Ã‚
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
		System.out.println(minBag(n));
	}

private static int minBag(int n)
{
	// TODO Auto-generated method stub
	int minbag = 10000;
	for(int i = 0;i<18;i++)
	{
		for(int j = 0;j<14;j++)
		{
			if(n == i*6+8*j)
			{
				if(i+j<minbag)
				{
					minbag = (i+j);
				}
			}
		}
	}
	if(minbag == 10000)
	{
		return -1;
	}
	return minbag;
}
}
