package com.mianshi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens
{
    public static void main(String[] args)
	{
		int n=8;
		System.out.println(solveNQueens(n));
	}
    
    public static List<List<String>> solveNQueens(int n)
    {
    	List<List<String>> res = new ArrayList<List<String>>();
    	char[][] placeQ = new char[n][n];
    	for(int i=0;i<n;i++)
    	{
    		for(int j=0;j<n;j++)
    		{
    			placeQ[i][j] = '.';
    		}
    	}
		nQueens(0,n,placeQ,res);
		return res;
    }

	private static void nQueens(int i, int n,char[][] placeQ,List<List<String>> res)
	{
		// 实现n皇后的排列问题，并将结果保存在res中，i代表当前i行已经排好序
		if(i>=n)
		{
			// 边界条件 最后一行也被排列好
			List<String> list = new ArrayList<>();
			for(int k=0;k<n;k++)
			{
				String string  = new String(placeQ[k]);
				list.add(string);
			}
			res.add(list);	
			return;
		}
		
		//每一行有n种可能实现
		for(int j=0;j<n;j++)
		{
			if(isValid(placeQ,i,j,n))
			{
				placeQ[i][j] = 'Q';
				nQueens(i+1,n,placeQ,res);//开始递归下一行
				placeQ[i][j] = '.';//回溯前的清空工作，前一种方案完成回溯找其他方案时需要将当前状态清空
			}
		}
		
	}

	private static boolean isValid(char[][] matrix, int i, int j, int n)
	{
		// 检查当前放入的地方是不是合法的
		// 当前只有i行排列好了，并且每一行只有一个皇后被摆放。
		/*boolean flag = true;
		for(int k=0;k<i;k++)
		{
			if(placeQ[k][j] == placeQ[i][j])
				return false;
			int row = i-k;
			int col1 = j+k;
			int col2 = j-k;
			if(col1<n)
			{
				if(placeQ[row][col1] == 'Q')
					return false;
			}
			if(col2>=0)
			{
				if(placeQ[row][col2] == 'Q')
					return false;
			}
		}
		return true;*/
		boolean res = true;
        //只对i上面的行检查，判断是否在一列或者在一条斜线上
        int up = i-1;
        while(up>=0){
            if(matrix[up][j]=='Q') return false;
            up--;
        }
        //左上
        int left = j-1,upleft = i-1;
        while(left>=0 && upleft>=0){
            if(matrix[upleft--][left--]=='Q') return false;
        }
        //右上
        int right = j+1,upRight = i-1;
        while(right<n && upRight>=0){
            if(matrix[upRight--][right++]=='Q') return false;
        }
        return res;
		
	}
    
}
