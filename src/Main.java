import java.util.Scanner;

public class Main
{
     public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		long num = in.nextLong();
		int count = 0;
		while(num != 0)
		{
			if(num % 2 ==1)
			{
				count++;
			}
			num /= 2;
		}
		System.out.println(count);
	}
}
