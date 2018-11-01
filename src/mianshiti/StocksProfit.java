package mianshiti;

public class StocksProfit
{
	//参考 leetcode 188 待续。。。 TODO
	public static void main(String[] args)
	{
		int[] profits = {5,15,56,26,62,65,57,69};
		System.out.println(calculateMax(profits));
	}
	public static int calculateMax(int[] prices)
    {
        int len = prices.length;
        if(len<=1)
            return 0;
        int[] dp = new int[len];
        dp[0] = 0;
        for(int i =1;i<len;i++)
        {
           for(int j = 0;j<i;j++)
           {
        	   if(prices[i]>prices[j])
        	   {
        		   
        	   }
           }
        }
        int max = 0;
        int secmax = 0;
        for(int i =1;i<len;i++)
        {
            if(dp[i]>=max && dp[i]>= secmax)
            {
                secmax = max;
                max = dp[i];              
            }
            else if(dp[i]<max && dp[i]>= secmax)
            {
                secmax = dp[i];
            }  
            System.out.println("第"+i+"次"+dp[i]+" ");
        }
        return max + secmax;
    }
}
