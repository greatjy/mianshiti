package com.newcoder.tobat.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val)
    {
    	this.val = val;
    }
}
public class BianliTree
{
    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		/*
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(11);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right.left = new TreeNode(14);
		root.right.right.right = new TreeNode(15);
		*/
		preOrderRecur(root);
		System.out.println();
		midOrderRecur(root);
		System.out.println();
		backOrderRecur(root);
		System.out.println();
		preOrderRecur1(root);
		System.out.println("中序非递归");
		InOrderRecur(root);
		System.out.println();
		postOrderRecur(root);
		System.out.println();
		System.out.println(xulieTree(root));
		TreeNode node = deSerilaze(xulieTree(root));
		System.out.println(node.val);
		System.out.println(node.left.val);
		System.out.println(node.right.val);
		System.out.println(isAvl(root));
		
	}
    
    public static void preOrderRecur(TreeNode head)
    {
    	if(head == null)
    		return;
    	System.out.print(head.val+" ");
    	preOrderRecur(head.left);
    	preOrderRecur(head.right);
    }
    public static void midOrderRecur(TreeNode head)
    {
    	if(head == null)
    		return;
    	midOrderRecur(head.left);
    	System.out.print(head.val+" ");
    	midOrderRecur(head.right);    	
    }
    public static void backOrderRecur(TreeNode head)
    {
    	if(head == null)
    		return;
    	backOrderRecur(head.left);
    	backOrderRecur(head.right);
    	System.out.print(head.val+" ");
    }
    
    public static void preOrderRecur1(TreeNode head)
    {
    	if(head == null)
    	{
    		return;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(head);
    	while(!stack.isEmpty())
    	{
    		TreeNode root = stack.pop();
    		System.out.print(root.val+" ");
    		if(root.right != null)
    		{
    			stack.push(root.right);
    		}
    		if(root.left != null)
    		{
    			stack.push(root.left);
    		}
    	}    	
    }
    
    public static void InOrderRecur(TreeNode root)
    {
    	if(root == null)
    		return;
    	TreeNode curr = root;
    	Stack<TreeNode> stack = new Stack<>();
    	while(!stack.isEmpty() || curr != null)
    	{
    		while(curr != null)
    		{
    			stack.push(curr);
    			curr = curr.left;
    		}
    		TreeNode node = stack.pop();
    		
    		System.out.print(node.val+" ");
    		
    		if(node.right != null)
    		{
    			curr = node.right;
    		}
    	}
    }
    
    public static void postOrderRecur(TreeNode root)
    {
    	if(root == null)
    	{
    		return;
    	}
    	Stack<TreeNode> stack1 = new Stack<TreeNode>();
    	Stack<TreeNode> stack2 = new Stack<TreeNode>();
    	stack1.push(root);
    	while(!stack1.isEmpty())
    	{
    		TreeNode head = stack1.pop();
    		stack2.push(head);
    		if(head.left != null)
    		{
    			stack1.push(head.left);
    		}
    		if(head.right != null)
    		{
    			stack1.push(head.right);
    		}
    	}
    	while(!stack2.isEmpty())
    	{
    		System.out.print(stack2.pop().val+" ");
    	}
    }
    
    public static String xulieTree(TreeNode root)
    {
    	StringBuffer sBuffer = new StringBuffer();
    	pre(root,sBuffer);
    	return sBuffer.toString();
    }
    public static void pre(TreeNode root,StringBuffer sb)
    {
    	if(root == null)
    	{
    		sb.append("#!");
    		//表示这个节点已经结束了
    	}
    	else {
			//这个打印顺序决定了 先序序列化 中序序列化 还是后续序列化
    		sb.append(root.val+"!");
    		pre(root.left, sb);
    		pre(root.right, sb);
		}
    }
    
    
    public static  int index = -1;
    public static TreeNode deSerilaze(String s)
    {
    	index++;
    	String[] Drlseq = s.split("!");
    	TreeNode leave = null;
    	if(!Drlseq[index].equals("#"))
    	{
    		leave = new TreeNode(Integer.valueOf(Drlseq[index]));
    		leave.left = deSerilaze(s);
    		leave.right = deSerilaze(s);
    	}
    	return leave;
    }
    
    public static boolean isAvl(TreeNode head)
    {
    	if(head == null)
    		return true;
    	int left = getHeight(head.left);
    	int right = getHeight(head.right);
    	if(Math.abs(left - right)>1)
    	{
    		return false;
    	}
    	return isAvl(head.left) && isAvl(head.right);
    }
    public static int getHeight(TreeNode head)
    {
    	if(head == null)
    		return 0;
    	int l = getHeight(head.left);
    	int r = getHeight(head.right);
    	return Math.max(l, r)+1;
    }
    
    public static boolean isSearchTree(TreeNode root)
    {
    	if(root == null)
    		return true;
    	//中序遍历 看顺序
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode curr = root;
    	TreeNode pre = null;
    	while(!stack.isEmpty() || curr != null)
    	{
    		while(curr != null)
    		{
    		      stack.push(curr);
    		      curr = curr.left;
    		}
    		TreeNode node = stack.pop();
    		if(pre != null && pre.val>=node.val)
    			return false;
    		System.out.print(node.val+" ");
    		if(node.right != null)
    		{
    			curr = node.right;
    		}
    	}
    	return true;
    }
    
    public static boolean isWanQuan(TreeNode root)
    {
    	if(root == null)
    		return true;
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	int flag = 0;
    	while(!queue.isEmpty())
    	{
    		TreeNode node = queue.poll();
    		if(flag == 1)
    		{
    		if(node.left != null || node.right != null)
    		{
    			return false;
    		}
    		}
    		if(node.left == null && node.right !=null)
    		{
    			return false;
    		}
    		else if(node.left == null || node.right == null)
    		{
    			flag = 1;
    		}
    		if(node.left != null)
    		{
    			queue.offer(node.left);
    		}
    		if(node.right !=null)
    		{
    			queue.offer(node.right);
    		}
    	}
    	return true;
    }
}
