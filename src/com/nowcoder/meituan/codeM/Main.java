package com.nowcoder.meituan.codeM;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n-- != 0)
		{
			String s = in.next();
			System.out.println(minButton(s));
		}
	}

	public static int minButton(String s)
	{
		
		int count =0;
		if(s.length() == 0 || s == null)
			return count;
		if(s.length() == 1)
		{
			int ch = quShuZi(s.charAt(0));
			return juli(0, ch);
		}
		int ch = quShuZi(s.charAt(0));
		count += juli(1, ch);
		for(int i=1;i<s.length();i++)
		{
			count += juli(quShuZi(s.charAt(i-1)), quShuZi(s.charAt(i))); 
		}
		return count;
	}

	public static int juli(int i, int j)
	{
		int[][] dir = new int[10][10];
		for (int k = 1; k < 10; k++)
		{
			dir[k][k] = 0;
		}
		dir[1][2] = 1;
		dir[1][3] = 2;
		dir[1][4] = 1;
		dir[1][5] = 2;
		dir[1][6] = 3;
		dir[1][7] = 2;
		dir[1][8] = 3;
		dir[1][9] = 4;

		dir[2][1] = 1;
		dir[2][3] = 1;
		dir[2][4] = 2;
		dir[2][5] = 1;
		dir[2][6] = 2;
		dir[2][7] = 3;
		dir[2][8] = 2;
		dir[2][9] = 3;

		dir[3][1] = 2;
		dir[3][2] = 1;
		dir[3][4] = 3;
		dir[3][5] = 2;
		dir[3][6] = 1;
		dir[3][7] = 4;
		dir[3][8] = 3;
		dir[3][9] = 2;

		dir[4][1] = 1;
		dir[4][2] = 2;
		dir[4][3] = 3;
		dir[4][5] = 1;
		dir[4][6] = 2;
		dir[4][7] = 1;
		dir[4][8] = 2;
		dir[4][9] = 3;

		dir[5][1] = 2;
		dir[5][2] = 1;
		dir[5][3] = 2;
		dir[5][4] = 1;
		dir[5][5] = 0;
		dir[5][6] = 1;
		dir[5][7] = 2;
		dir[5][8] = 1;
		dir[5][9] = 2;

		dir[6][1] = 3;
		dir[6][2] = 2;
		dir[6][3] = 1;
		dir[6][4] = 2;
		dir[6][5] = 1;
		dir[6][6] = 0;
		dir[6][7] = 3;
		dir[6][8] = 2;
		dir[6][9] = 1;

		dir[7][1] = 2;
		dir[7][2] = 3;
		dir[7][3] = 4;
		dir[7][4] = 1;
		dir[7][5] = 2;
		dir[7][6] = 3;
		dir[7][7] = 0;
		dir[7][8] = 1;
		dir[7][9] = 2;

		dir[8][1] = 3;
		dir[8][2] = 2;
		dir[8][3] = 3;
		dir[8][4] = 2;
		dir[8][5] = 1;
		dir[8][6] = 2;
		dir[8][7] = 1;
		dir[8][8] = 0;
		dir[8][9] = 1;

		dir[9][1] = 4;
		dir[9][2] = 3;
		dir[9][3] = 2;
		dir[9][4] = 3;
		dir[9][5] = 2;
		dir[9][6] = 1;
		dir[9][7] = 2;
		dir[9][8] = 1;
		dir[9][9] = 0;

		return dir[i][j];
	}

	public static int quShuZi(char ch)
	{
		if (ch == '@' || ch == '!' || ch == ':')
		{
			return 1;
		}
		if (ch == 'A' || ch == 'B' || ch == 'C')
		{
			return 2;
		}
		if (ch == 'D' || ch == 'E' || ch == 'F')
		{
			return 3;
		}
		if (ch == 'G' || ch == 'H' || ch == 'I')
		{
			return 4;
		}
		if (ch == 'J' || ch == 'K' || ch == 'L')
		{
			return 5;
		}
		if (ch == 'M' || ch == 'N' || ch == 'O')
		{
			return 6;
		}
		if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S')
		{
			return 7;
		}
		if (ch == 'T' || ch == 'U' || ch == 'V')
		{
			return 8;
		}
		if (ch == 'W' || ch == 'X' || ch == 'Y' || ch == 'Z')
		{
			return 9;
		}
		return 0;
	}
}
