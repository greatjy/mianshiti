package mianshiti;

import java.util.Scanner;

public class NiuNIuDeDaXiao
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int A = in.nextInt();
		int[] arr = new int[len];
		for(int i=0;i<len;i++)
		{
			arr[i] = in.nextInt();
		}
		System.out.println(lastDaXiao(A, arr));
	}
    public static int lastDaXiao(int A,int[] arr)
    {
    	for(int i=0;i<arr.length;i++)
    	{
    		if(arr[i] == A)
    		{
    			A *= 2;
    		}
    	}
    	return A;
    }
}
