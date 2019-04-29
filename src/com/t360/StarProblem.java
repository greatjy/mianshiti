package com.t360;

import java.util.Scanner;

public class StarProblem
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int col = in.nextInt();
		int k = in.nextInt();
		if(row<3 || col <3)
		{
			System.out.println(0);
		}
		else {
			
		
		int[][] matrix = new int[row][col];
        //System.out.println(row+" "+col+" "+k);
        String string = in.nextLine();
        for(int i=0;i<row;i++)
        {
        	String temp = in.nextLine();
        	//System.out.println(temp+" temp");
        	for(int j=0;j<col;j++)
        	{
        		matrix[i][j] = temp.charAt(j)-'0';
        		//System.out.println(matrix[i][j]);
        	}
        }
        
		int[] rowarray = new int[k];
		int[] colarray = new int[k];
		int index=0;
		int target = k;
		for(int i=1; i<row-1; i++) {
			for(int j=1; j<col-1; j++) {
				if(matrix[i][j]==1&&matrix[i-1][j]==1&&matrix[i+1][j]==1&&matrix[i][j-1]==1&&matrix[i][j+1]==1) {
					k--;
					rowarray[index] = i;
					colarray[index] = j;
					index++;
				}
				if(k<=0) {
					break;
				}
			}
		}
		int rowhead = Integer.MAX_VALUE;
		int rowtail=0;
		int colhead=Integer.MAX_VALUE;
		int coltail=0;
		for(int i=0; i<target; i++) {
			if(rowarray[i]<rowhead) {
				rowhead = rowarray[i];
			}
			if(rowarray[i]>rowtail) {
				rowtail = rowarray[i];
			}
		}
		for(int j=0; j<target; j++) {
			if(colarray[j]<colhead) {
				colhead = colarray[j];
			}
			if(colarray[j]>coltail) {
				coltail = colarray[j];
			}
		}
		rowhead--;
		rowtail++;
		colhead--;
		coltail++;
		int ans = 0;
		ans = ans +(rowhead+1)*(row-rowtail)*(colhead+1)*(col-coltail);
		System.out.println(ans);
		}
	}
    
}
