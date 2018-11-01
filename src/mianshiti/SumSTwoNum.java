package mianshiti;

import java.util.ArrayList;
import java.util.function.IntPredicate;

public class SumSTwoNum
{
     public static void main(String[] args)
	{
	    int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,14,15,16};
	    int target = 16;
	    System.out.println(FindNumbersWithSum(arr, target));
	}
     public static  ArrayList<Integer> FindNumbersWithSum(int [] array,int sum)
     {
         ArrayList<Integer> al = new ArrayList<Integer>();
         int i = 0;
         int j = array.length-1;
         while(i<j)
         {
             if(array[i]+array[j] == sum)
             {
                 al.add(array[i]);
                 al.add(array[j]);
                 return al;
             }
             else if(array[i]+array[j]>sum)
             {
                 j--;
             }
             else
             {
                 i++;
             }
             System.out.println(i+" 0"+j);
         }
         return al;
     }
}
