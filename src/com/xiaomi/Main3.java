package com.xiaomi;

import java.util.Scanner;

public class Main3
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long  n = in.nextLong();
		if(isTriple(n))
		{
			System.out.println("ok");
		}
		
		
		
	}
    public static boolean isTriple(long n)
    {
    	int num = (int)Math.pow(n, 1.0/3);
    	if(num * num * num == n)
    		return true;
    	else
    		return false;
    }
}
