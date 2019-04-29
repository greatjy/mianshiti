package com.baidu.newcoder.gaopin.char2;

import java.util.Scanner;

public class JinjiShuSan
{
    public static void main(String[] args)
	{
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String space = in.nextLine();
        int[][] path = new int[n][2];
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            String[] strs = str.split(" ");
            path[i][0] = Integer.parseInt(strs[0]);
            path[i][1] = Integer.parseInt(strs[1]);
            //path[Integer.parseInt(strs[0])] = Integer.parseInt(strs[1]);
        }
        System.out.println(findMinTime(path,n));

    
	}

	private static int findMinTime(int[][] path,int n)
	{
        int[] ans = new int[n];
        for(int i=0;i<path.length;i++)
        {
        	if(path[i][1] == 1)
        	{
        		ans[i] = 1;        		
        	}
        }
        for(int i=1;i<path.length;i++)
        {
        	if(ans[path[i][1]] != 0)
        	{
        		int count = findParent(path[i][0],path);
        		ans[i] = count + ans[path[i][1]];
        	}
        }
		return n;        
	}

	private static int findParent(int index,int[][] path)
	{
		int count = 0;
	     for(int i=0;i<path.length;i++)
	     {
	    	 if(path[i][1] == index)
	    	 {
	    		 count++;
	    	 }
	     }
	     return count;
	}
}
