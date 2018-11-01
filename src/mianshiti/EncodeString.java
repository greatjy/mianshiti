package mianshiti;

import java.util.Scanner;

public class EncodeString
{
    public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);
	    String string  = in.nextLine();
	    encode(string);
	}
    public static void encode(String s)
    {
    	if(s==null || s.trim().length() == 0)
    	{
    		System.out.println("");
    	}
    	char[] arr = s.toCharArray();
    	for(int i=0;i<arr.length;i++)
    	{
    		if(('a'<=arr[i]&&arr[i]<='y')||('A'<=arr[i]&&arr[i]<='Z'))
    		{
    			arr[i] = (char)(arr[i]+1);
    		}
    		else if(arr[i] == 'z' || arr[i] =='Z')
    		{
    			arr[i] = (char)(arr[i]-25);
    		}
    	}
    	String ans = String.valueOf(arr);
    	System.out.println(ans);
    }
}
