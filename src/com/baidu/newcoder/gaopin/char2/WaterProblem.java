package com.baidu.newcoder.gaopin.char2;

public class WaterProblem
{
    public static void main(String[] args)
	{
		int[] arr = {3,1,2,4};
		System.out.println(maxWater(arr));
		System.out.println(waterProblem2(arr));
		System.out.println(maxWater1(arr));
	}
    
    public static int maxWater(int[] arr)
    {
    	if(arr == null || arr.length == 0)
    		return 0;
    	int maxValue = 0;
    	for(int i=1;i<arr.length-1;i++)
    	{
    		int maxLeft = 0;
    		int maxRight = 0;
    		for(int l=0;l<i;l++)
    		{
    			maxLeft = Math.max(arr[l], maxLeft);
    		}
    		for(int r=arr.length-1;r>i;r--)
    		{
    			maxRight = Math.max(maxRight, arr[r]);
    		}
    		maxValue += Math.max(0, Math.min(maxLeft, maxRight)-arr[i]);
    	}
    	return maxValue;
    }
    
    //������ ʹ��������������¼ÿһ��Ԫ����ߺ��ұߵ����ֵ������ʱ�临�Ӷ�
    public static int waterProblem2(int[] arr)
    {
    	if(arr  == null || arr.length <3)
    		return 0;
    	int[] leftMax = new int[arr.length];
    	int[] rightMax = new int[arr.length];
    	for(int i=1;i<arr.length-1;i++)
    	{
    	    leftMax[i] = Math.max(leftMax[i-1], arr[i-1]);
    	}
    	for(int i=arr.length-2;i>=1;i--)
    	{
    		rightMax[i] = Math.max(rightMax[i+1], arr[i+1]);
    	}
    	
    	int maxValue = 0;
    	for(int i=0;i<arr.length;i++)
    	{
    		maxValue += Math.max(0, Math.min(leftMax[i], rightMax[i])-arr[i]);
    	}
    	return maxValue;
    	
    }
    
    //���Ž� ��������˼·�Ǹ�����Ŀ���ó����� ʱ�临�Ӷ�n �ռ临�Ӷ� 1
    public static int maxWater1(int[] arr)
    {
    	if(arr == null || arr.length <3)
    	{
    		return 0;
    	}
    	
    	int maxValue = 0;
    	int maxLeft = arr[0];
    	int maxRight = arr[arr.length-1];
    	int l = 1;
    	int r = arr.length-1;
    	while(l<=r)
    	{
    		//���������ߵ����ֵ�ý�Сֵ ��ʼ���ڻ��� ֱ������
    		if(maxLeft<maxRight)
    		{
    			//���Ƚ��㵱ǰλ�� ��Ϊ��ǰλ�� ���Ա�֤��ߵ����ֵ��С
    			maxValue += Math.max(0, maxLeft - arr[l]);
    			
    			//Ȼ�����maxLeft ѭ���ж��������ֵ�ý�Сֵ
    			maxLeft = Math.max(maxLeft, arr[l]); 
    			
    		// ���l���� ������һ��λ��
    			l++;
    		}
    		else
    		{
    			
    			//���Ƚ��㵱ǰλ�� ��Ϊ��ǰλ�� ���Ա�֤�ұߵ����ֵ��С
    			maxValue += Math.max(0, maxRight - arr[r]);
    			
    			//Ȼ�����maxLeft ѭ���ж��������ֵ�ý�Сֵ
    			maxLeft = Math.max(maxRight, arr[r]);
    			r--;
    		}
    	}
    	return maxValue;
    			
    }
}
