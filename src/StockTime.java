class StockTime
{
    public static int maxProfit(int[] prices)
    {
        if(prices == null || prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i] < min)
            {
                min = prices[i];
            }
            else
            {
                dp[i] = prices[i] - min;
            }
        }
        int result = dp[0];
        for(int i=0;i<dp.length;i++)
        {
            if(result<dp[i])
            {
                result = dp[i];
            }
        }
        return result;
    }
    
    public static void main(String[] args)
	{
		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}