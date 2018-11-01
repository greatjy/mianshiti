package mianshiti;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NumberProblem
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int[] cishu = new int[10];
		for(int i=0;i<10;i++)
		{
			cishu[i] = in.nextInt();
		}
		
		//int j = 9;
	    List<String> ans = new ArrayList<String>();
	    dfs(ans,"",0,cishu);
        Collections.sort(ans, new mySortByValue());
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
			
		}

	    
    }
    public static void dfs(List<String> res,String temp,int i,int[] cishu)
    {
    	if(i>9)
    	{
    		res.add(temp);
    		return;
    	}
    	if(cishu[i] == 1)
    	{
    		temp+=i;
    		dfs(res, temp, i+1, cishu);
    		int len = temp.length();
    		temp = temp.substring(0, len-1);
    	}
    	else
    	{ 
    		for(int j=0;j<2;j++)
    		{
    			if(j == 1)
    			{
    				temp+=i;
    	    		dfs(res, temp, i+1, cishu);
    	    		int len = temp.length();
    	    		temp = temp.substring(0, len-1);
    			}
    			else
    			{
    				temp += "";
    				dfs(res, temp, i+1, cishu);
    			}
    		}
    	}
    }
}
class mySortByValue implements Comparator {
	 
	public int compare(Object o1, Object o2) {
 
		String s1 = (String) o1;
		String s2 = (String) o2;
		if (s1.compareToIgnoreCase(s2)<0){
			return -1;
		}
		return 1;
 
	}
}

