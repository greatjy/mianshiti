import java.util.Scanner;

public class Main2
{
	public static int[][] ch = new int[10010][30];
	public static int[] word = new int[10010];
	public static int n=0;
	public static int sz = 1;
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String xx = in.nextLine();
		String[] strings = new String[n];
		for(int i=0;i<n;i++)
		{
			strings[i] = in.nextLine();
			insert(strings[i]);
			//System.out.println(strings[i]);
		}
		for(int j=0;j<n;j++)
		{
			find(strings[j]);
			System.out.println();
		}
	}
     public static int idx(char x)
     {
    	 return x-'a';
     }
     public static void insert(String s)
     {
    	 int i,j,len = s.length();
    	 int u=0;
    	 for(i=0;i<len;i++)
    	 {
    		 int c = idx(s.charAt(i));
    		 if(ch[u][c] == 0)
    		 {
    			 ch[u][c] = sz;
    			 sz++;
    		 }
    		 u = ch[u][c];
    		 word[u]++;
    	 }
     }
     public static void find(String s)
     {
    	 int i,j,len = s.length();
    	 int u = 0;
    	 for( i=0;i<len;i++)
    	 {
    		 int c = idx(s.charAt(i));
    		 u = ch[u][c];
    		 System.out.print(s.charAt(i));
    		 if(word[u] == 1)
    			 return;
    	 }
     }
}
