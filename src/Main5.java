import java.util.Scanner;

public class Main5
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int[] data = new int[len];
		for(int i=0;i<len;i++)
		{
			data[i] = in.nextInt();
		}
		int k = in.nextInt();
		if(len== 0)
			System.out.println(0);
		if(len == 1)
			System.out.println(Math.abs(data[0]));
		if(k == 0)
		{
		int[] dp1 = new int[len];
		int[] dp2 = new int[len];
		dp1[0] = data[0];
		dp2[0] = data[0];
		int max = Math.abs(data[0]);
		for(int i=1;i<len;i++)
		{
			if(dp1[i-1]>0)
			{
				dp1[i] = data[i]+dp1[i-1];
			}
			else
			{
				dp1[i] = data[i];
			}
			if(dp2[i-1]<0)
			{
				dp2[i] = data[i]+dp2[i-1];
			}
			else
			{
				dp2[i] = data[i];
			}
			max = Math.max(max, Math.max(dp1[i], Math.abs(dp2[i])));
			//System.out.println(max);
		}
		System.out.println(max);
		}
	}
}
