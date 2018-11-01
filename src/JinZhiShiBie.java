import java.util.Scanner;



public class JinZhiShiBie
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		String space = in.nextLine();
		for (int i = 0; i < t; i++)
		{
			int N = in.nextInt();
			int M = in.nextInt();
			String string = in.next();
			System.out.println(findNum(string, N, M));
		}
	}

	private static int findNum(String string, int n, int m)
	{
		int result = 0;
		if (string == null || string == "")
			return 0;
		int tempA, tempB;
		for (int i = 0; i < string.length(); i++)
		{
			tempA = calc1(string, n, i);
			tempB = calc2(string, m, i);
			//System.out.println(i+" "+tempA+" "+tempB);
			if (tempA == tempB)
			{
				return tempA;
			}
		}
		return 0;
	}

	private static int calc2(String string, int n, int i)
	{
		int res = 0;
		for (int j = i + 1; j < string.length(); j++)
		{
			if ('0' <= string.charAt(j) && string.charAt(j) <= '9')
				res += Integer.parseInt(string.charAt(j) + "") * Math.pow(n, string.length() - j - 1);
			else

			{
				int temp = 10 + (string.charAt(j) - 'A');
				res += temp * Math.pow(n, string.length() - j - 1);

			}

		}
		return res;
	}

	private static int calc1(String string, int n, int i)
	{
		int res = 0;
		for (int j = 0; j <= i; j++)
		{
			if ('0' <= string.charAt(j) && string.charAt(j) <= '9')
			res += Integer.parseInt(string.charAt(j) + "") * Math.pow(n, i - j);
			else
			{
				int temp = 10 + (string.charAt(j) - 'A');
				res += temp * Math.pow(n, i - j);

			}
		}
		return res;
	}
}