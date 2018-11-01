package com.newcoder.tobat;

import javax.naming.spi.DirStateFactory.Result;

public class IsSubTree
{
	/**
	 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right =
	 * null;
	 * 
	 * public TreeNode(int val) { this.val = val;
	 * 
	 * }
	 * 
	 * }
	 */
	public static void main(String[] args)
	{
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(4);
		System.out.println(HasSubtree(root1, root2));
		System.out.println(isPartTree(root1, root2));
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(2);
		System.out.println(isPart(root1, root3));
	}

	public static boolean HasSubtree(TreeNode root1, TreeNode root2)
	{
		String tree1 = toString(root1);
		String tree2 = toString(root2);
		System.out.println(tree1);
		System.out.println(tree2);
		int[] next = kmpNext(tree2);
		return kmp(tree1, tree2, next);
	}

	public static String toString(TreeNode root)
	{
		StringBuffer sb = new StringBuffer();
		pre(root, sb);
		return sb.toString();
	}

	public static void pre(TreeNode root, StringBuffer sb)
	{
		if (root == null)
		{
			sb.append("#!");
		} else
		{
			sb.append(root.val + "!");
			pre(root.left, sb);
			pre(root.right, sb);
		}
	}

	public static boolean kmp(String str1, String str2, int[] next)
	{
		for (int i = 0, j = 0; i < str1.length(); i++)
		{
			while (j > 0 && str1.charAt(i) == str2.charAt(j))
			{
				j = next[j - 1];
			}
			if (str1.charAt(i) == str2.charAt(j))
			{
				j++;
			}
			if (j == str2.length())
			{
				return true;
			}
		}
		return false;
	}

	public static int[] kmpNext(String str)
	{
		int[] next = new int[str.length()];
		next[0] = 0;
		for (int i = 1, j = 0; i < str.length(); i++)
		{
			while (j > 0 && str.charAt(i) != str.charAt(j))
			{
				j = next[j - 1];
			}
			if (str.charAt(i) == str.charAt(j))
			{
				j++;
			}
			next[i] = j;
		}
		return next;
	}

	// 判断两颗同节点的树 是否有一颗是另一颗的子树
	public static boolean isPart(TreeNode root1, TreeNode root2)
	{
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		
		if (root1.val != root2.val)
			return false;
		return isPart(root1.left, root2.left) && isPart(root1.right, root2.right);
	}

	public static boolean isPartTree(TreeNode root1, TreeNode root2)
	{
		boolean flag = false;
		if (root1 != null && root2 != null)
		{
			if (root1.val == root2.val)
			{
				flag = isPart(root1, root2);
			}

			if (!flag)
			{
				flag = isPartTree(root1.left, root2);
			}
			if (!flag)
			{
				flag = isPartTree(root1.right, root2);
			}			
		}
		return flag;
	}
}
