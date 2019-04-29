package com.t360;

import java.util.*;
public class TestTencent3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(in.hasNext())
        {
        int t = in.nextInt();
        int[] num = new int[t];
        for(int i=0;i<t;i++)
        {
            num[i] = in.nextInt();
        }
        int min = num[0];
        int minCount = 0;
        int maxCount = 0;
        int max = num[0];
        for(int i=0;i<t;i++)
        {
            if(max == num[i])
            {
                maxCount++;
            }
            if(max < num[i])
            {
                max = num[i];
                maxCount = 1;
            }
            if(min == num[i])
            {
                minCount++;
            }      
            if(min > num[i])
            {
                min = num[i];
                minCount=1;
            }
        }
        //System.out.println(minCount+" "+maxCount);
        int[] dp = new int[t];
        for(int i=0;i<t-1;i++)
        {
            dp[i] = num[i];
            for(int j=i+1;j<t;j++)
            {
                 if(Math.abs(num[j]-num[i])<dp[i])
                 {
                     dp[i] = Math.abs(num[j]-num[i]);
                 }
                
            }
        }
        int less = dp[0];
        int lessCount = 1;
        for(int i=1;i<dp.length-1;i++)
        {
            if(dp[i] == less)
            {
                lessCount++;
            }
            if(dp[i] < less)
            {
                less = dp[i];
                lessCount = 1;
            }
            
        }
        int maxNumber = minCount*maxCount;
        System.out.println(lessCount+" "+maxNumber);
        }
    }
}