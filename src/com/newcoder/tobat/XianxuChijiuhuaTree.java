package com.newcoder.tobat;

public class XianxuChijiuhuaTree
{
    public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		String string = toString(root);
		System.out.println(string);
	}

	private static String toString(TreeNode root)
	{
		StringBuffer sBuffer = new StringBuffer();
		pre(root,sBuffer);
		return sBuffer.toString();		
	}

	private static void pre(TreeNode root, StringBuffer sBuffer)
	{
		if(root == null)
		{
			sBuffer.append("#!");
		}
		else
		{
			sBuffer.append(root.val+"!");
			pre(root.left, sBuffer);
			pre(root.right,sBuffer);
		}
		
	}
}
