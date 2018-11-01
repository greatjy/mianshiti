package com.newcoder;

import java.util.Scanner;

public class TanChiQ
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		System.out.println(maxChoc(N, M));
	}
    
    public static int maxChoc(int N,int M)
    {
    	int minNumber = (int) Math.pow(2, N-1)-1;
    	return M-minNumber;
    }
}
