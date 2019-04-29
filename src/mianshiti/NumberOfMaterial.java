package mianshiti;

import java.util.HashSet;
import java.util.Scanner;

public class NumberOfMaterial
{
    public static void main(String[] args)
	{
    	 Scanner in = new Scanner(System.in);
         HashSet<String> set = new HashSet<>();
         //String s = null;
         while(in.hasNext())
         {
        	 String s = in.nextLine();
             String[] str = s.split(" ");
             for(int j=0;j<str.length;j++)
             {
                 set.add(str[j]);
             }
         }
         System.out.println(set.size());	
         set.clear();
	}
}
