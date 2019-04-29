package mianshiti;

import java.util.Scanner;

public class LonestDigitalSeq
{
	  public static void main(String[] args)
	    {
	        Scanner in = new Scanner(System.in);
	        String s = in.nextLine();
	        int len = s.length();
	        int count = 0;
	        int curr = 0;
	        int[] dp = new int[len];
	        for(int i=0;i<len;i++)
	        {
	            if(isDigital(s.charAt(i)))
	            {
	                curr++;
	                dp[i] = curr;
	                if(curr >= count)
	                {
	                    count = curr;
	                }
	            }
	            else
	            {
	                curr = 0;
	            }
	        }
	        //System.out.println(count);
	        for(int i=0;i<len;i++)
	        {
	            int m = 0;
	            if(dp[i] == count)
	            {
	                m = i-dp[i]+1;
	                String ss = s.substring(m,i+1);
	                System.out.println(ss);
	            }
	        }
	    }
	    public static boolean isDigital(char ch)
	    {
	        
	            if(ch<='9' && ch>='0')
	            {
	               return true;
	            }
	        return false;
	    }
}
