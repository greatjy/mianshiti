package mianshiti;

import java.util.Scanner;

public class JinZhiJunZhi
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
		{
			int n = in.nextInt();
			if (n == 1)
				System.out.println("1/1");
			if (n == 2)
			{
				System.out.println("2/1");
			} else
			{
				int count = 0;
				for (int i = 2; i < n; i++)
				{
					int temp = n;
					while (temp != 0)
					{
						count += temp % i;
						temp /= i;
					}
				}
				// System.out.println(count);
				int gcd = findGCD(count, n - 2);
				count /= gcd;
				int fenmu = (n - 2) / gcd;
				System.out.println(count + "/" + fenmu);
			}
		}
	}
    public static int findGCD(int x,int y)
    {
    	if(y == 0)
    		return x;
    	else
    		return findGCD(y,x%y);
    }
}
