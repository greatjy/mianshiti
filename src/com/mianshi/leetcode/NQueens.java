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
		// ʵ��n�ʺ���������⣬�������������res�У�i����ǰi���Ѿ��ź���
		if(i>=n)
		{
			// �߽����� ���һ��Ҳ�����к�
			List<String> list = new ArrayList<>();
			for(int k=0;k<n;k++)
			{
				String string  = new String(placeQ[k]);
				list.add(string);
			}
			res.add(list);	
			return;
		}
		
		//ÿһ����n�ֿ���ʵ��
		for(int j=0;j<n;j++)
		{
			if(isValid(placeQ,i,j,n))
			{
				placeQ[i][j] = 'Q';
				nQueens(i+1,n,placeQ,res);//��ʼ�ݹ���һ��
				placeQ[i][j] = '.';//����ǰ����չ�����ǰһ�ַ�����ɻ�������������ʱ��Ҫ����ǰ״̬���
			}
		}
		
	}

	private static boolean isValid(char[][] matrix, int i, int j, int n)
	{
		// ��鵱ǰ����ĵط��ǲ��ǺϷ���
		// ��ǰֻ��i�����к��ˣ�����ÿһ��ֻ��һ���ʺ󱻰ڷš�
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
        //ֻ��i������м�飬�ж��Ƿ���һ�л�����һ��б����
        int up = i-1;
        while(up>=0){
            if(matrix[up][j]=='Q') return false;
            up--;
        }
        //����
        int left = j-1,upleft = i-1;
        while(left>=0 && upleft>=0){
            if(matrix[upleft--][left--]=='Q') return false;
        }
        //����
        int right = j+1,upRight = i-1;
        while(right<n && upRight>=0){
            if(matrix[upRight--][right++]=='Q') return false;
        }
        return res;
		
	}
    
}
