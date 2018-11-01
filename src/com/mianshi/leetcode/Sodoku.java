package com.mianshi.leetcode;

public class Sodoku
{
    public static void main(String[] args)
	{
    	char[][] nums = {{'5','3','.','.','7','.','.','.','.'},  
                {'6','.','.','1','9','5','.','.','.'},  
                {'.','9','8','.','.','.','.','6','.'},  
                {'8','.','.','.','6','.','.','.','3'},  
                {'4','.','.','8','.','3','.','.','1'},  
                {'7','.','.','.','2','.','.','.','6'},  
                {'.','6','.','.','.','.','2','8','.'},  
                {'.','.','.','4','1','9','.','.','5'},  
                {'.','.','.','.','8','.','.','7','9'}}; 
    	System.out.println(canSolveSodoku(nums));
    	 for(char[] ch : nums){  
             for(char c : ch){  
                 System.out.print(String.valueOf(c)+" ");  
             }  
             System.out.println();  
         }  
    	
	}
    public static boolean canSolveSodoku(char[][] board)
    {
    	if(board == null || board.length == 0|| board[0].length ==0)
    	{
    		return false;
    	}
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length;j++)
    		{
    			if(board[i][j] == '.')
    			{
    				//这个点尚未有数字被填入
    				for(char ch='1';ch<='9';ch++)
    				{
    					if(isValid(board,i,j,ch))
    					{
    						board[i][j] = ch;
    						if(canSolveSodoku(board))
    						{
    							return true;
    						}
    						else
    						{
    							board[i][j] = '.';
    						}   						
    					}
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
	private static boolean isValid(char[][] board, int row, int col, char ch)
	{
		// 判断这个点（i，j）填入ch之后是否合法
		for(int i=0;i<board.length;i++)
		{
			if(board[i][col] == ch || board[row][i] == ch)
			{
				return false;
			}
		}
		int leftRow = row/3*3;
		int upCol = col/3*3;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[leftRow+i][upCol+j] == ch)
				{
					return false;
				}
			}
		}
		return true;
	}
}
