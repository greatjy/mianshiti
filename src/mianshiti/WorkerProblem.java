package mianshiti;

import java.util.Scanner;

public class WorkerProblem
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] wupin = new int[n];
		for(int i=0;i<n;i++)
		{
			wupin[i] = in.nextInt();
		}
		System.out.println(maxWorker(wupin,m));
	}

	private static int maxWorker(int[] wupin, int m)
	{
		if(wupin.length == 1)
			return 1;
		int len = wupin.length;		
		int[] gongren = new int[len+1];
		int[] dp = new int[len+1];
		dp[1] = 1;
		gongren[1] = wupin[1-1];
		int num = 1; 
		A :for(int i=1;i<len;i++)
		{
			for(int j=1;j<=num;j++)
			{
				if(gongren[j] + wupin[i] <= 5)
				{
					// do nothing
					gongren[j] += wupin[i];
					continue A;
				}				
			}
			num++;
			gongren[num] = wupin[i];
		}
		return num;
	}
}
