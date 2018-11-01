package com.newcoder.tobat;

import java.util.HashSet;

public class IsBianxingOrRetote
{
    public static void main(String[] args)
	{
		String s1 = "abccd";
		String s2 = "bccda";
		String s3 = "";
		String s4 = "";
		System.out.println(isBianxing(s1, s2));
		System.out.println(isRotation(s3, s4));
		
	}
    public static boolean isBianxing(String str1,String str2)
    {
    	if(str1 == null || str2 == null || str1.length() != str2.length())
    		return false;
    	char[] chas1 = str1.toCharArray();
    	char[] chas2 = str2.toCharArray();
    	int[] map = new int[256];
    	for(int i=0;i<chas1.length;i++)
    	{
    		map[chas1[i]]++;
    	}
    	for(int i=0;i<chas2.length;i++)
    	{
    		if(map[chas2[i]]-- == 0)
    		{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean isRotation(String str1,String str2)
    {
    	if(str1 == null || str2 == null || str1.length() != str2.length())
    		return false;
    	if(str1=="" && str2=="")
    		return true;
    	StringBuffer sBuffer = new StringBuffer(str1);
    	sBuffer.append(str1);
    	String string = sBuffer.toString();
    	int[] next = kmpNext(str2);
    	return kmp(string, str2, next);
    	
    }
    public static boolean kmp(String str1,String str2,int[] next)
    {
    	for(int i=0,j=0;i<str1.length();i++)
    	{
    		while(j>0 && str1.charAt(i) != str2.charAt(j))
    		{
    			j = next[j-1];
    		}
    		if(str1.charAt(i) == str2.charAt(j))
    		{
    			j++;
    		}
    		if( j == str2.length())
    		{
    			return true;
    		}
    	}
    	return false;
    }
    public static int[] kmpNext(String str)
    {
    	int[] next = new int[str.length()];
    	next[0] = 0;
    	for(int i=1,j=0;i<str.length();i++)
    	{
    		while(j>0 && str.charAt(i) != str.charAt(j))
    		{
    			j = next[j-1];
    		}
    		if(str.charAt(i) == str.charAt(j))
    		{
    			j++;
    		}
    		next[i] = j;
    	}
    	return next;
    }
}
