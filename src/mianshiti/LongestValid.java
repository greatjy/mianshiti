package mianshiti;

public class LongestValid
{
    public static void main(String[] args)
	{
		String string  ="()";
		System.out.println(longestValidParentheses(string));
	}
    public static int longestValidParentheses(String s)
    {
        if(s == null || s.equals("")) 
        {
            return 0;
        }
        char[] chas = s.toCharArray();
        int[] dp = new int[chas.length];
        int k = 0;
        int res = 0;
        for(int i=1;i<chas.length;i++)
        {
            if(chas[i] == ')')
            {
                k = i-dp[i-1]-1;//�ص�֮ǰ���Ǹ��ڵ���
                if(k>=0 && chas[k] == '(')//dp[i-1]��Ч������֮�� ���Ǹ��ڵ��ֵ
                {
                    dp[i] = dp[i-1]+2+(k>0 ? dp[k-1] : 0);
                }
                //System.out.println("k="+k);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
     }
}
