package com.newcoder.tobat.binarySearch;

public class FastGetPower
{
    public static void main(String[] args)
	{
		int k = 2;
		int n = 8;
		System.out.println(getPower(k, n));
	}
    
    public static int getPower(int k,int n)
    {
    	long temp = k;
    	long res = 1;
    	long mm = 100000007;
    	if(n == 1)
    		return k;
    	if(n == 0)
    		return 1;
    	for(;n>0;n>>=1)
    	{
    		if((n&1) !=0)
    		{
    			res = res*temp;
    			System.out.println(res);
    		}
    		temp = (temp*temp) % mm;//temp 每一次扩张一倍
    		System.out.println(temp);
    		res = res %mm;
    	}
    	return (int)res;
    }
}
