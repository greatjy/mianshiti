package com.newcoder.tobat;

import java.util.function.IntBinaryOperator;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class SortDemo
{
    public static void main(String[] args)
	{
		int[] arr = {3,56,2,8,-4,3,98,0,43,1,334,5};
		//bubbleSort(arr);
		//selectSort(arr);
		//insertSort(arr);
		
		//mergeSort(arr, 0, arr.length-1);
		//quickSort(arr,0,arr.length-1);
		//shellSort(arr);
		
		heapSort(arr);
		
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}

	private static void bubbleSort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-i-1;j++)
			{
				if(arr[j+1]<arr[j])
				{
					swap(arr, j+1, j);
				}
			}
		}
		
	}
	
	private static void selectSort(int[] arr)
	{
		
		for(int i=0;i<arr.length;i++)
		{
			int minIndex = i;
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	private static void insertSort(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			int j;//������¼�������λ��
			int x = arr[i];//�������Ԫ��
			for(j=i;j>0 && x<arr[j-1];j--)
			{				
				//ǰi-1��Ԫ���ѽ�����
				//��֤���������ֱ���ЩԪ��С ������ЩԪ���±�Ҫ�Ϸ� �����ǽ�������
				arr[j] = arr[j-1];
			}
			arr[j] = x;//����Ԫ��
		}
	}
	
	private static void mergeSort(int[] arr,int l,int r)
	{
		int middle = l+(r-l)/2;
	    if(l >= r)
	    {
	    	return;//�߽�����
	    }
	    mergeSort(arr, l, middle);
	    mergeSort(arr, middle+1, r);
	    merge(arr,l,r,middle);
	}
	private static void merge(int[] arr, int l, int r, int middle)
	{
		int[] temp = new int[arr.length];
		int head1 = l;
		int head2 = middle+1;
		int tempptr = l;
		while(head1 <= middle && head2<=r)
		{
			if(arr[head1] <= arr[head2])
			{
				temp[tempptr++] = arr[head1++];
			}
			if(arr[head2] < arr[head1])
			{
				temp[tempptr++] = arr[head2++];
			}
		}
		while(head1 <= middle)
		{
			temp[tempptr++] = arr[head1++];
		}
		while(head2<=r)
		{
			temp[tempptr++] = arr[head2++];
		}		
		
		for(int i=l;i<=r;i++)
		{
			arr[i] = temp[i];
		}
	}

	
	private static void quickSort(int[] arr,int l,int r)
	{
	     //�������ε�һ������
		int i = l;
		int j = r;
		int key = arr[l];//��ŦԪ
		if(l >= r)
		{
			return;
		}
		
		while(i<j)
		{
			while(key <= arr[j] && j>i)
			{
				j--;
			}
			swap(arr, i, j);
			
			while(key > arr[i] && j>i)
			{
				i++;
			}
			swap(arr, i, j);
			// һ�˽���֮�� key��߱���С �ұ߱�����
			
			quickSort(arr, l, i-1);
			quickSort(arr, i+1, r);
		}
	}
	
	private static void shellSort(int[] arr)
	{
		//ϣ������  ��ؼ��ľ��ǲ�����ѡ��
		//ÿһ�ζ��Ǹ�һ����������������   ��������в�����ѡ��������������һ��ȡ��
		int i,j;
		int temp;
		int len = arr.length;//��һ�εĲ���
		for(int h=len/2;h>0;h/=2)
		{
			//����ÿ���۰�
			for(i=h;i<len;i++)
			{
				//�����۰��ĺ�벿��
				temp = arr[i];
				for(j=i-h;j>=0;j-=h)
				{
					//�����еĺ�벿�ֲ��Ϻ��Լ���ǰһ���Ӧ��������Ƚ�
					if(temp < arr[j])
					{
						//��Ҫ����
						//swap(arr, j+h, j);
						arr[j+h] = arr[j];
					}
					else
					{
						break;
					}
				}
				arr[j+h] = temp;
			}
		}
	}
	
	private static void heapSort(int[] arr)
	{
		//���������������齨��һ�������
		//Ȼ������һ���ڵ� �� ���ڵ� ����λ��
		//Ȼ���ٴ���ʣ�µ�i-1�ĸ�
	    for(int i=0;i<arr.length;i++)
	    {
	    	buildTree(arr, arr.length -i -1);
	    	swap(arr, 0, arr.length-i-1);
	    }
		
	}
	
	private static void buildTree(int[] arr, int lastIndex)
	{
		for(int j=(arr.length/2)-1;j>=0;j--)
		{
			int k = j;//��¼�������ڵ��λ��
			while(2*k+1 < lastIndex)
			{
				//������
				int biggerIndex = 2*k+1;
				if(biggerIndex < lastIndex)
				{
					//���Һ���
					if(arr[biggerIndex] < arr[biggerIndex+1])
					{
						biggerIndex++;
					}
				}
				if(arr[k] < arr[biggerIndex])
				{
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				}
				else {
					break;
				}
			}
		}
	}

	private static void swap(int[] arr,int i,int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private static void heapSortDemo(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			buildTree(arr, arr.length-1-i);
			swap(arr, 0, arr.length-i-i);
		}
	}
}
