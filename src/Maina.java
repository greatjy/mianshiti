import java.util.Scanner;

public class Maina
{
    static long res1 = 0;
    static int sum = 0;
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		sum = n+m+k;
		dfs1(n, m, k, 0,"");
		long  n1 = res1;
		System.out.println(n1);
		//long  n2 = dfs2(n,m,k,0);
		//long  n3 = dfs(n,m,k,0);		
	}
    public static void dfs1(int n,int m,int k,int i,String temp)
    {
    	if(i == sum)
    	{
    		res1++; 
    		//System.out.println(temp);
    	}
    	if( i == 0)
    	{
    		if(n > 0)
    		{
    			temp += "A";
    			dfs1(n-1, m, k, i+1, temp);
    			temp= temp.substring(0, i);
    		}
    		if(m > 0)
    		{
    			temp+="B";
    			dfs1(n, m-1, k, i+1, temp);
    			temp= temp.substring(0, i);
    		}
    		if(k>0)
    		{
    			temp+="C";
    			dfs1(n, m, k-1, i+1, temp);
    			temp= temp.substring(0, i);
    		}
    	}
    	else
    	{
    		//System.out.println(temp);
    		if(temp.charAt(i-1) == 'A')
    		{
    			if(m > 0)
        		{
        			temp+="B";
        			dfs1(n, m-1, k, i+1, temp);
        			temp= temp.substring(0, i);
        		}
        		if(k>0)
        		{
        			temp+="C";
        			dfs1(n, m, k-1, i+1, temp);
        			temp= temp.substring(0, i);
        		}
    		}
    		else if(temp.charAt(i-1) == 'B')
    		{
    			if(n > 0)
        		{
        			temp+="A";
        			dfs1(n-1, m, k, i+1, temp);
        			temp= temp.substring(0, i);
        		}
    			if(k>0)
        		{
        			temp+="C";
        			dfs1(n, m, k-1, i+1, temp);
        			temp= temp.substring(0, i);
        		}
    		}
    		else if(temp.charAt(i-1) == 'C')
    		{
    			if(n > 0)
        		{
        			temp+="A";
        			dfs1(n-1, m, k, i+1, temp);
        			temp= temp.substring(0, i);
        		}
        		if(m > 0)
        		{
        			temp+="B";
        			dfs1(n, m-1, k, i+1, temp);
        			temp= temp.substring(0, i);
        		}
    		}
    	}
    }
}
