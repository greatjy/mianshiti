package mianshiti;

import java.util.Scanner;

public class LuckyNUmber
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
        System.out.println(totalLucky(n));
		
	}
    public static int totalLucky(int n)
    {
    	int count = 0;
    	for(int i =1;i<=n;i++)
		{
			int num1 = 0;
			int num2 = 0;
			int temp1 = i;
			int temp2 = i;
			while(temp1 != 0)
			{
				num1 += temp1%10;
				temp1 /= 10;
			}
			//System.out.println(num1);
			while(temp2 !=0)
			{
				num2 += temp2 & 1;
				temp2 >>>= 1;
			}
			//System.out.println(num2);
			if(num1 == num2)
			{
				count++;
			}
		}
		return count;
    }
}
