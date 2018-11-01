package com.newcoder;

import java.util.Scanner;

public class StarProblem
{
    public static void main(String[] args)
	{
	   Scanner in = new Scanner(System.in);
	   int n = in.nextInt();
	   int[][] pos = new int[n][2];
	   for(int i=0;i<n;i++)
	   {
		   pos[i][0] = in.nextInt();
		   pos[i][1] = in.nextInt();
	   }
	   int m = in.nextInt();
	   while (m-- != 0)
	   {
		     int a1 = in.nextInt();
		     int b1 = in.nextInt();
		     int a2 = in.nextInt();
		     int b2 = in.nextInt();
		     int count = 0;
		     for(int i=0;i<n;i++)
		     {
		    	 if(a1<=pos[i][0] && a2>=pos[i][0] && b1<=pos[i][1] && b2>= pos[i][1] )
		    	 {
		    		 count++;
		    	 }
		     }
		     System.out.println(count);
	   }

	}
        
}
