package mianshiti;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XiaoYiLIkeString
{
	  public static void main(String[] args)
	    {
	        Scanner in = new Scanner(System.in);
	        String str = in.nextLine();
	        System.out.println(doesLike(str));
	    }
	    public static String doesLike(String str)
	    {
	    	//System.out.println(isBigCha(str));
	    	//System.out.println(isNotEqual(str));
	    	//System.out.println(isNotXyxy(str));
	        if(isBigCha(str) && isNotEqual(str) && isNotXyxy(str))
	        	return "Likes";
	        else
	        	return "Dislikes";
	    }
	    public static boolean isBigCha(String str)
	    {
	        for(int i=0;i<str.length();i++)
	        {
	            if(str.charAt(i)<'A' || str.charAt(i)>'Z')
	                return false;
	        }
	        return true;
	    }
	    public static boolean isNotEqual(String str)
	    {
	        if(str.length() <= 1)
	            return true;
	        for(int i=1;i<str.length();i++)
	        {
	            if(str.charAt(i) == str.charAt(i-1))
	                return false;
	        }
	        return true;
	    }
	    public static boolean isNotXyxy(String str)
	    {
	        if(str.length() <= 3)
	            return true;
	        for(int i=str.length()-1;i>=4;i--)
	        {
	            if(!isSeq(str.substring(0,i),str.charAt(i)))
	            {
	                return false;
	            }
	        }
	        return true;
	    }
	    public static boolean isSeq(String string,char ch)
	    {
	        int count = 0;
	        for(int i=0;i<string.length();i++)
	        {
	        	if(string.charAt(i) == ch)
	        	{
	        		count++;
	        	}
	        }
	        if(count >= 4)
	        {
	        	//System.out.println("因为大于4个return false");
	        	return false;
	        }
	        HashSet<Character> set = new HashSet<>();
	        String[] str = string.split(ch+"");
	        int length = 0;
	        for(int i=0;i<str.length;i++)
	        {
	        	Set<Character> set1 = new HashSet<Character>();
	        	for(int j=0;j<str[i].length();j++)
	        	{
	        	    set1.add(str[i].charAt(j));
	        		set.add(str[i].charAt(j));
        
	        	}
	        	length+= set1.size();
	        	//System.out.println(length);
	        }
	        //System.out.println("因为不相等returnfalse");
	        return length == set.size();	
	    }
}
