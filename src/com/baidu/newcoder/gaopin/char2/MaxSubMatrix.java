package com.baidu.newcoder.gaopin.char2;

public class MaxSubMatrix
{
    public static void main(String[] args)
	{
		int[][] arr= {{-90,48,78},{68,-40,64},{-81,-7,66}};
		System.out.println(getMaxMatrixSum(arr));
	}
    
    public static int getMaxMatrixSum(int[][] arr)
    {
    	if(arr == null || arr.length == 0 || arr[0].length == 0)
    		return 0;
    	int max= Integer.MIN_VALUE;
    	for(int i=0;i<arr.length;i++)
    	{
    		int[] s = new int[arr[0].length];
    		for(int j=i;j<arr.length;j++)
    		{
    			int cur = 0;
    			for(int k=0;k<s.length;k++)
    			{
    				s[k] += arr[j][k];
    				cur += s[k];
    				max = Math.max(cur, max);
    				cur = cur < 0? 0:cur;     					
    			}
    		}
    	}
    	return max;
    }
}
