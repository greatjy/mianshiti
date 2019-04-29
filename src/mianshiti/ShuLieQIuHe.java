package mianshiti;

import java.util.Scanner;

public class ShuLieQIuHe
{
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
            int n = in.nextInt();
            int m = in.nextInt();
            if(m == 1)
                //return n;
                System.out.println(n);
            double sum = n;
            for(int i=1;i<m;i++)
            {
                sum += Math.pow(n,1/(Math.pow(2,i)));
               // System.out.println(Math.pow(81,-2));
                System.out.println(sum);
            }
            System.out.println(String.format("%.2f", sum));
        }
    }
}
