package mianshiti;


import java.util.LinkedList;
import java.util.Scanner;

public class ConstructQueue
{
    public static void main(String[] args)
    {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	while((n--)>0)
    	{
    		int m = in.nextInt();
    	    LinkedList<Integer> list = findPreQueue(m);
    	    int len = list.size();
    	    for(int i = 0;i<len-1;i++)
    	    {
    	    	System.out.print(list.get(i)+" ");
    	    }
    	    System.out.print(list.getLast());
    	}
    }

	private static LinkedList<Integer> findPreQueue(int n)
	{
		LinkedList<Integer> list = new LinkedList<>();
		list.add(n);
		if(n == 1)
		{
			return list;
		}
		if(n == 2)
		{
			list.add(1);
			return list;			
		}
		for(int i=n-1;i>=1;i--)
		{
			int last = list.getLast();
			list.removeLast();
			list.addFirst(last);
			list.addFirst(i);
		}
		int last = list.getLast();
		list.removeLast();
		list.addFirst(last);
		return list;
		
	}
}
