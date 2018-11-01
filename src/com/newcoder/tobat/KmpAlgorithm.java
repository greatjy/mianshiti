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
     * ʵ��kmp�㷨 ƥ��һ���ַ��� ������ֲ�ƥ�䲻��������� ���ǲ�������ǰ׺�ַ���
     * ��ͷ���ַ������Ƿ��а���ƥ���ַ����������Դ�ַ�����ĩβ���ϲ�ƥ�������ַ�����ƥ���ַ�����
     * һ���֣� ����next ����Ҳ����������ƥ���ַ���
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
     * ������kmp�㷨�е�next���� ��ʾ�����ǰ��׺�ַ���
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
