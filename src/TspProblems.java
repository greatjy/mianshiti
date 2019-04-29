import java.util.Scanner;

// ����������
public class TspProblems
{
   public static void main(String[] args)
   {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] fee = new int[n][n];
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		fee[i][j] = in.nextInt();
        	}
        }
		System.out.println(minRoadFee(fee));
   }

	private static int minRoadFee(int[][] fee)
	{
		int n = fee.length;
		int[] x = new int[n];
		int[] bestx = new int[n];
		int bestp = 65535;
		int cp = 0;
		int t = 2;
	     if(t>n){
	         if((fee[x[n]][1]) !=0 &&(fee[x[n]][1]+cp<bestp)){
	               bestp = fee[x[n]][1]+cp;
	               for(int i = 1;i<=n;i++){
	                  bestx[i] = x[i];
	               }
	         }
	      }else{
	          for(int i = t;i<=n;i++){
	              /*Լ��Ϊ��ǰ�ڵ㵽��һ�ڵ�ĳ��Ȳ�Ϊ0,�޽�Ϊ�߹��ĳ���+��ǰҪ�ߵĳ���֮��С�����ų���*/
	             if((fee[x[t-1]][x[i]]!=0)&&(cp+fee[x[t-1]][x[i]]<bestp)){
	                 swap(x[t],x[i]);
	                 cp+=fee[x[t-1]][x[t]];
	                 //(t+1);
	                 cp-=fee[x[t-1]][x[t]];
	                 swap(x[t],x[i]);
	             }
	          }
	     }
		return t;
	}

	private static void swap(int i, int j)
	{
		// TODO Auto-generated method stub
		
	}
}
