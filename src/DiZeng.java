import java.util.Scanner;


public class DiZeng
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for(int i=0;i<t;i++)
		{
			String string = in.nextLine();
			System.out.println(transfor(string));
		}
	}

	private static String transfor(String string)
	{
		String result = new String();
		if(string == null || string == "" || string.length() == 0)
			return result.toString();
		int count = 0;
		int len = string.length();
		for(int i=0;i<string.length();i++)
		{
			if(count >=3 && string.charAt(i)-string.charAt(i-1) != 1)
			{
				String temp = ""+string.charAt(i-count-1)+"-"+string.charAt(i-1);
				result = result.substring(0, result.length()-count-1);
				result += temp;
				result += string.charAt(i);
				count = 0;
			}
			else if(count >=2 && i == len-1)
			{
				String temp = ""+string.charAt(i-count-1)+"-"+string.charAt(i);
				result = result.substring(0, result.length()-count-1);
				result += temp;
				count = 0;
			}
			else if (i == 0)
			{
				result += string.charAt(0);
			}
			else if(string.charAt(i)-string.charAt(i-1) == 1)
			{
				count++;
				result+=string.charAt(i);
			}
			else {
				count = 0;
				result+=string.charAt(i);
			}
		}
		return result;
	}
}
