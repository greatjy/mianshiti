package mianshiti;


import java.util.Scanner;

public class MaxUpSum
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] data = new int[9];
        for(int i=1;i<=8;i++)
		{
			data[i] = in.nextInt();
		}
		int sum = maxSum(data);
		System.out.println(sum);
	}

	private static int maxSum(int[] data)
	{
       int [] dp = new int[9];
       for(int i=1;i<=8;i++)
       {
    	   dp[i] = data[i];
    	   for(int j=1;j<i;++j)
    	   {
    		   if(data[i]>data[j] && dp[i]<dp[j]+data[i])
    		   {
    			   //当前数字的前面这个数字小于，并且加上这个数字后要比原来打
    			   dp[i] = dp[j] + data[i];
    		   }
    	   }
       }
       int max = -1;
       for(int j=1;j<=8;j++)
       {
    	   System.out.println(dp[j]);
    	   max = Math.max(max, dp[j]);
       }
       return max;
       
	}
}
