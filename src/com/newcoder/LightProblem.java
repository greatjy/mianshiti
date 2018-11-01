package com.newcoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Jilu
{
    public int getRow()
	{
		return row;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public int getCol()
	{
		return col;
	}
	public void setCol(int col)
	{
		this.col = col;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	int row;
    int col;
    int status;
    String time;
	public Jilu(int row, int col, int status, String time)
	{
		super();
		this.row = row;
		this.col = col;
		this.status = status;
		this.time = time;
	}
	@Override
	public String toString()
	{
		return "Jilu [row=" + row + ", col=" + col + ", status=" + status + ", time=" + time + "]";
	}
	
}


public class LightProblem
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
	    int rows = in.nextInt();
	    int cols = in.nextInt();
	    int[][] statuss = new int[rows][cols];
	    int[][] count = new int[rows][cols];
	    int jilunums = in.nextInt();
	    ArrayList<Jilu> list = new ArrayList<>();
	    for(int i=0;i<jilunums;i++)
	    {
	    	int row = in.nextInt();
	    	int col = in.nextInt();
	    	int status = in.nextInt();
	    	String time = in.next();
	    	Jilu jilu = new Jilu(row, col, status, time);
	    	list.add(jilu);
	    }
	    Collections.sort(list, new JiluComparator());
	    System.out.println(list);
	    int light = 0;
	    for(Jilu jilu : list)
	    {
	    	System.out.println(light);
	    	if(jilu.getStatus() == 0)
	    	{
	    	   count[jilu.getRow()-1][jilu.getCol()-1]++;
	    	   if(lights(count) >= light)
	    	   {
	    		   light = lights(count);
	    		   for(int i=0;i<rows;i++)
	    		   {
	    			   for(int j=0;j<cols;j++)
	    			   {
	    				   statuss[i][j] = count[i][j];
	    			   }
	    		   }
	    	   }
	    	}
	    	if(jilu.getStatus() == 1)
	    	{
	    		count[jilu.getRow()-1][jilu.getCol()-1]--;
	    		   if(lights(count) >= light)
		    	   {
	    			   //System.out.println(light);
		    		   light = lights(count);
		    		   for(int i=0;i<rows;i++)
		    		   {
		    			   for(int j=0;j<cols;j++)
		    			   { 
		    				   statuss[i][j] = count[i][j];
		    			   }
		    		   }
		    	   }
	    	}
	    }
	    
	    for(int i=0;i<rows;i++)
	    {
	    	for(int j=0;j<cols;j++)
	    	{	    		
	    		if(statuss[i][j] > 0)
	    		   System.out.print(1);
	    		else
	    			System.out.print(0);
	    	}
	    	System.out.println();
	    }
	}
	public static int lights(int[][] counts)
	{
		int lights = 0;
		for(int i=0;i<counts.length;i++)
		{
			for(int j=0;j<counts[0].length;j++)
			{
				if(counts[i][j] > 0)
				{
					lights++;
				}
			}
		}
		return lights;
	}      
}


class JiluComparator implements Comparator<Jilu>
{

	@Override
	public int compare(Jilu o1, Jilu o2)
	{
		if(o1.getTime().compareTo(o2.getTime())>0)
		{
			return 1;
		}
		else if(o1.getTime().compareTo(o2.getTime())<0)
		{
			return -1;
		}
		else
		{			
			return 0;
		}
	} 
}

