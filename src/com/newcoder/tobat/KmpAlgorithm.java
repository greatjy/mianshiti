package com.newcoder.tobat;

public class KmpAlgorithm
{
    public static void main(String[] args)
	{
		String str1 = "bcabacabbcababefgabab";
		String str2 = "abab";
		int[] next = kmpnext(str2);
		int res = kmp(str1,str2,next);
		System.out.println(res);
	    System.out.println(str1.indexOf(str2));
		for(int i:next)
		{
		     System.out.print(i+" ");
		}
		//System.out.println(next.length);
	}

    /**
     * 实现kmp算法 匹配一段字符串 如果出现不匹配不再逐个查找 而是查找他的前缀字符串
     * 开头的字符串中是否有包含匹配字符串的情况（源字符串的末尾加上不匹配的这个字符串是匹配字符串的
     * 一部分） 所以next 数组也被称作部分匹配字符串
     * @param str1
     * @param str2
     * @param next
     * @return
     */
    private static int kmp(String str1, String str2, int[] next)
	{
		int len1 = str1.length();
		int len2 = str2.length();
		for(int i=0,j=0;i<str1.length();i++)
		{
			while(j>0 && str1.charAt(i) != str2.charAt(j))
			{
				j = next[j-1];
			}
			if(str1.charAt(i) == str2.charAt(j)){
				j++;
			}
			if(j == len2)
			{
				return i-j+1;
			}
		}
		return -1;
	}

	/**
     * 来创建kmp算法中的next数组 表示的是最长前后缀字符串
     * @param str2
     * @return
     */
	private static int[] kmpnext(String str2)
	{
		int[] next = new int[str2.length()];
		next[0] = 0;
		for(int i=1,j=0;i<str2.length();i++)
		{
			while(j>0 && str2.charAt(i) != str2.charAt(j))
			{
				j = next[j-1];
			}
			if(str2.charAt(i) == str2.charAt(j))
			{
				j++;
			}
			next[i] = j;
		}
		return next;
	}	
}
