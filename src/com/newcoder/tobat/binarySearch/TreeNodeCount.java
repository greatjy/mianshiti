package com.newcoder.tobat.binarySearch;

class TreeNode
{
    int val;
    TreeNode(int val)
    {
    	this.val = val;
    }
    TreeNode left;
    TreeNode right;
}
public class TreeNodeCount
{
    public static void main(String[] args)
	{
		
	}
    public static int countTreeNode(TreeNode root)
    {
    	//分别得到左子树 和 右子树的高度 然后比较
    	if(root == null)
    		return 0;
    	int count = 0;
    	TreeNode cur = 	root.left;
    	int ldepth = 0;//左子树的高度
    	while(cur != null)
    	{
    		ldepth++;
    		cur = cur.left;
    	}
    	cur = root.right;
    	int rdepth = 0;
    	while(cur != null)
    	{
    		rdepth++;
    		cur = cur.right;
    	}
    	
    	if(ldepth == rdepth)
    	{
    		//满二叉树
    		count = (int)Math.pow(2,ldepth)+countTreeNode(root.right);
    	}
    	else
    	{
    		count = (int)Math.pow(2, rdepth)+countTreeNode(root.left);
    	}
    	return count;
    }
    
}
