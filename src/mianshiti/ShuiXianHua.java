package mianshiti;

import java.util.Scanner;

public class ShuiXianHua
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		while(in.hasNext())
		{
		   int n = in.nextInt();
		   int m = in.nextInt();
		   printHasShui(n,m);
		   System.out.println();
		}
	}
    private static void printHasShui(int n,int m)
	{
    	int total = 0;
		// TODO Auto-generated method stub
    	for(int i =n;i<=m;i++)
    	{
    		int temp = i;
    		int sum = 0;
    		while(temp != 0)
    		{
    			int num = temp%10;
    			sum += num*num*num;
    			temp = temp/10; 
    			//System.out.println(temp+"i");
    		}
    		//10System.out.println(sum);
    		if(sum == i)
    		{
    			System.out.print(sum+" ");
    			total++;
    		}
    	}
    	if(total == 0)
    	{
    		System.out.print("no");
    	}		
	}
	
} 
