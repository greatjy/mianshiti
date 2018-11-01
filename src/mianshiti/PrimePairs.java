package mianshiti;

import java.util.Scanner;

public class PrimePairs
{
	private static int[] primes = new int[168];
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum=0;
		isPrme();
        for(int i=0;i<primes.length;i++)
        {
        	for(int j=i;j<primes.length;j++)
        	{
        		if(primes[i]+primes[j] == n)
        		{
        			//System.out.println(primes[i]+" "+primes[j]);
        			sum++;
        		}
        	}
        }
        System.out.println(sum);
	}
    public static void isPrme()
    {
    	int count = 0;
    	A : for(int i=2;i<=1000;i++)
    	{
    		for(int j=2;j<=Math.sqrt(i);j++)
    		{
    			if(i % j == 0)
    			{
    			      continue A;
    			}
    		}
    		primes[count++] = i;    		
    	}
    	
    }
}
