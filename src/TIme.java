import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TIme
{
   public static void main(String[] args)
   {
	    Scanner in = new Scanner(System.in);
	    int len = in.nextInt();
	    String time = in.next();
	    String[][] record = new String[len][3];
	    for(int i=0;i<len;i++)
	    {
	    	for(int j=0;j<3;j++)
	    	{
	    		record[i][j] = in.next();
	    	}
	    }
	    List<String> list = new ArrayList<String>();
	    for(int k=0;k<len;k++)
	    {
	    	if(record[k][1].compareTo(time) <0  && record[k][2].compareTo(time)>0)
	    	{
	    		list.add(record[k][0]);
	    	}
	    }
	    for(String string : list)
	    {
	    	System.out.println(string);
	    }
   }
}
