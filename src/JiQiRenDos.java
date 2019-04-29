import java.util.Scanner;

public class JiQiRenDos
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String spaceString = in.nextLine();
		int[] H = new int[n];
		for(int i=0;i<n;i++)
		{
			H[i] = in.nextInt();
			//System.out.println(H[i]);
		}
		System.out.println(findMinEnergy(H));
	}

	private static int findMinEnergy(int[] h)
	{		
		int sum = 0;
		boolean flag = true;
		int i=0;
	    A:while(i<10000)
		{ 
	       // System.out.println(i);
	       sum = 0;
	       int j = 0;
	       int currentEnergy = i;
	       while(j < h.length)
	       {
	    	   //System.out.println(sum + " "+i+" "+j);
	    	   sum += h[j];	    	   
	    	   if(2*currentEnergy - h[j] < 0)
	    	   {
	    		   i++;
	    		   //System.out.println(i+" "+j+" ");
	    		   continue A;
	    	   }
	    	   else {
				currentEnergy = 2*currentEnergy-h[j];
			}
	    	   j++;
	       }
	       return i;
		}
	return -1;
	}
}
