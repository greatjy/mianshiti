package mianshiti;

import java.util.Scanner;

public class CandyProblen
{
	 public static void main(String[] args)
	 {
	        Scanner in = new Scanner(System.in);
	        int x = in.nextInt();
	        int y = in.nextInt();
	        int z = in.nextInt();
	        int w = in.nextInt();
	        if((w-y) != (z-x-2*y))
	        {
	        	System.out.println("No");
	        }
	        int C = (z-x-2*y)/2;
	        int B = y+C;
	        int A = x+y+C;
	        System.out.println(A+" "+B+" "+C);
	 }
}
