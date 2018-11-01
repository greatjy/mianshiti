package com.newcoder.tobat.tree;

import java.util.Currency;
import java.util.Stack;

public class TreeProblemIV
{
    public static void main(String[] args)
	{
		printProcess(1, 3, true);
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		int[] error = findTwoError(root);
		for(int i:error)
		{
			System.out.println(i);
		}
	}
    
    public static void printProcess(int i,int N,boolean down)
    {
    	//ÿһ����ۺ� ������һ����������
    	//��������ĵ��˴����Ҵ�ӡ���ۺ۷���
    	//��ö�����  ��������ͷ��� ��Ϊ�ϣ���������ͷ��㶼Ϊ��
    	if(i > N)
    		return;
    	printProcess(i+1, N, false);
    	System.out.println(down? "down":"up");
    	printProcess(i+1, N, true);     	
    }
    
    public static int[] findTwoError(TreeNode root)
    {
    	if(root == null)
    		return null;
    	int[] error = new int[2];
    	TreeNode curr = root;
    	TreeNode pre = null;
    	Stack<TreeNode> stack = new Stack<>();
    	int flag = 1;
    	while(!stack.isEmpty() || curr!=null)
    	{
    		while(curr != null)
    		{
    			stack.push(curr);
    			curr = curr.left;
    		}
    		TreeNode node = stack.pop();
    		if(pre != null && pre.val>node.val)
    		{
    			if(flag == 1)
    			error[0] = pre.val;
    			error[1] = node.val;
    			flag++;
    		}
    		pre = node;
    		System.out.println(node.val);
    		if(node.right != null)
    		{
    			curr = node.right;
    		}
    		
    	}
    	return error;
    }
    
}
