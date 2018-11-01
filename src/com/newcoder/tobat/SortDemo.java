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
			int j;//用来记录待插入的位置
			int x = arr[i];//待插入的元素
			for(j=i;j>0 && x<arr[j-1];j--)
			{				
				//前i-1个元素已将有序
				//保证待插入数字比这些元素小 并且这些元素下标要合法 将他们进行右移
				arr[j] = arr[j-1];
			}
			arr[j] = x;//插入元素
		}
	}
	
	private static void mergeSort(int[] arr,int l,int r)
	{
		int middle = l+(r-l)/2;
	    if(l >= r)
	    {
	    	return;//边界条件
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
	     //单纯分治的一个例子
		int i = l;
		int j = r;
		int key = arr[l];//枢纽元
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
			// 一趟结束之后 key左边比他小 右边比他大
			
			quickSort(arr, l, i-1);
			quickSort(arr, i+1, r);
		}
	}
	
	private static void shellSort(int[] arr)
	{
		//希尔排序  最关键的就是步长的选择
		//每一次都是隔一个步长来进行排序   这个程序中步长的选择就是整个数组的一半取整
		int i,j;
		int temp;
		int len = arr.length;//第一次的步长
		for(int h=len/2;h>0;h/=2)
		{
			//步长每次折半
			for(i=h;i<len;i++)
			{
				//数组折半后的后半部分
				temp = arr[i];
				for(j=i-h;j>=0;j-=h)
				{
					//数组中的后半部分不断和自己的前一半对应的数字相比较
					if(temp < arr[j])
					{
						//需要交换
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
		//根据所给定的数组建立一个大根堆
		//然后把最后一个节点 和 根节点 交换位置
		//然后再处理剩下的i-1的根
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
			int k = j;//记录下来父节点的位置
			while(2*k+1 < lastIndex)
			{
				//有左孩子
				int biggerIndex = 2*k+1;
				if(biggerIndex < lastIndex)
				{
					//有右孩子
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
