package com.tiaozhan.char2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class QuJianProblem
{
    public static void main(String[] args)
	{
		//�ڿ�ѡ�Ĺ����У�ÿ�ζ�ѡ���������Ĺ���
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] start = new int[n];
    	int[] end = new int[n];
    	for(int i=0;i<n;i++)
    	{
    		start[i] = in.nextInt();
    		end[i] = in.nextInt();
    	}
    	
    	/*for(int i=0;i<n;i++)
    	{
    		end[i] = in.nextInt();
    	}*/
    	
    	int res = solve(start,end);
    	System.out.println(res);
	}

	private static int solve(int[] start, int[] end)
	{
		// �ڿ�ѡ�Ĺ�����ÿ�ζ�ѡ�����ʱ������Ĺ���
		// ���Խ����еĽ���ʱ���������
		List<Pair> list = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
        	Pair pair = new Pair(start[i], end[i]);
        	list.add(pair);
        }
        
        Collections.sort(list, new Comparator<Pair>()
		{

        	@Override
			public int compare(Pair o1, Pair o2)
			{
				if(o1.getSecond() > o2.getSecond())
				{
					return 1;
				}
				else
				{
					return -1;
				}
				
			}
        
		});
        System.out.println(list);
        
        int ans = 0;
        int t = 0;
        for(int i=0;i<start.length;i++)        	
        {
             if(t <= list.get(i).getFirst()) //�����ںű�ʾ�˵�����ظ� ��������
             {
            	 //Ѱ�ҽ�������� ��ѡ����
            	 ans ++;
            	 t = list.get(i).getSecond();
             }
        }
		return ans;
	}
	
}
class Pair
{
    @Override
	public String toString()
	{
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	public int getFirst()
	{
		return first;
	}
	public void setFirst(int first)
	{
		this.first = first;
	}
	public int getSecond()
	{
		return second;
	}
	public void setSecond(int second)
	{
		this.second = second;
	}
	private int first;
    private int second;
	public Pair(int first, int second)
	{
		super();
		this.first = first;
		this.second = second;
	}
    
}
