import java.util.Scanner;

public class Main4
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int[][] des = new int[N][2];
		for(int i=0;i<N;i++)
		{
			des[i][0] = in.nextInt();
			des[i][1] = in.nextInt();
		}
		for(int j=0;j<M;j++)
		{
			int x = in.nextInt();
			int y = in.nextInt();
			System.out.println(calc(x,y,des));
		}		
	}

	private static int calc(int x, int y, int[][] des)
	{
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i=0;i<des.length;i++)
		{
			sum+=(Math.abs(x-des[i][0])+Math.abs(y-des[i][1]));
		}
		return sum;
	}
}
