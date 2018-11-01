package com.newcoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ParkBfs
{
	public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int m = in.nextInt();
        char[][] maze = new char[n][n];
        int sx=0, sy=0;// ��¼�Թ������λ��
        int gx=0, gy=0;// ��¼�Թ����յ�λ��
        int minRes = 1000000;
        for (int i = 0; i < n; i++)
        {
            String string = in.next();
            for (int j = 0; j < n; j++)
            {
                maze[i][j] = string.charAt(j);
                /*
                if (string.charAt(j) == '@')
                {
                    sx = i;
                    sy = j;
                }*/
                if (string.charAt(j) == '*')
                {
                    gx = i;
                    gy = j;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if (maze[i][j] == '@')
                {
                    sx = i;
                    sy = j;
                }
        		minRes = Math.min(minRes, bfs(maze, n,n, sx, sy, gx, gy));
        	}
        }
        //int distance = bfs(maze, n, n, sx, sy, gx, gy);
        System.out.println(minRes);
    }
 
    private static int bfs(char[][] maze, int m, int n, int sx, int sy, int gx, int gy)
    {
        final int INF = 100000;
        int[][] distance = new int[m][n];
        String[][] strings = new String[m][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                distance[i][j] = INF;
            }
        }
        int[] xd = {1,0,-1,0};
        int[] yd = {0,1,0,-1};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sx,sy));//���Ƚ�ͷ�����������
        distance[sx][sy] = 0;
        //strings[sx][sy] = "";
        //String string = "";
        //1har[] dir = {'��','��','��','��'};
        while(queue.size()>0)
        {
            //ÿһ���������һ������ֵ�������
            Point point = queue.poll();
            if(point.getX() == gx && point.getY() == gy)
            {
                //�������һ��������Ѿ��ҵ����յ���ô�ͽ���ѭ��
                //�߽�����
                break;
            }
            for(int i=0;i<4;i++)
            {
                int xp = point.getX()+xd[i];
                int yp = point.getY()+yd[i];
                if(0<=xp && xp<n && 0<= yp && yp <m && maze[xp][yp] != '#' && distance[xp][yp] == INF )
                {
                    //������һ��Ϊ���ĵ���һ�� �ǺϷ��Ĳ�����δ���ʹ�
                    //��ô������һ����·��������һ
                    queue.add(new Point(xp, yp));
                    distance[xp][yp] = distance[point.getX()][point.getY()]+1;
               
                }
            }
        }
        return distance[gx][gy];
    }
}
class Point
{
    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
    public int getX()
    {
        return x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y)
    {
        this.y = y;
    }
}
