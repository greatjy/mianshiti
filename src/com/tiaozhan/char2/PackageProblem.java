package com.tiaozhan.char2;

public class PackageProblem
{
    public static void main(String[] args)
	{
		int[] w = {2,1,3,2};
		int[] v = {3,2,4,2};
		int W = 5;
		int value = mostValue(w,v,W);
		System.out.println(value);
	}

	private static int mostValue(int[] w, int[] v,int W)
	{
		int[][] dp = new int[w.length+1][W+1];
		//dp�����������浱ǰ�����õ�������ֵ dp[i][j] ��ʾ�ڱ�������Ϊj������� ��ǰi����Ʒ��
		//�õ��ļ�ֵ�����ֵ
		//�߽�������dp[0][j] �� dp[i][0] ����0 java�������Ѿ���ʼ������
		for(int i=1;i<=w.length;i++)
		{
			for(int j=1;j<=W;j++)
			{
				if(j<w[i-1])
				{
					dp[i][j] = dp[i-1][j];//��i����Ʒ�ò��� ֻ��ѡ����
				}
				else
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
					//�ֱ��ǵ�i����Ʒ�û���
					//���õõ�������ֵ�ĶԱ�
				}
			}
		}
				
		return dp[w.length][W];
	}
    
}
