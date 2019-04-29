package mianshiti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
public class BinaryTreeByLevelReturnArray
{
    public static void main(String[] args)
	{
	     TreeNode root = new TreeNode(0);
	     root.left = new TreeNode(1);
	     root.right = new TreeNode(2);
	     root.left.left = new TreeNode(3);
	     root.right.right = new TreeNode(4);
	     root.right.right.left = new TreeNode(5);
	     int[][] ans = printTree(root);
	     for(int[] is : ans)
	     {
	    	 for(int i : is)
	    	 {
	    		 System.out.print(i+"\t");
	    	 }
	    	 System.out.println();
	     }
	}
    public static int[][] printTree(TreeNode root) {
        if(root == null)
            return null;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            ArrayList<Integer> num = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                num.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            list.add(num);
        }
        int len = list.size();
        int[][] res = new int[len][];
        /*

        int count = 0;
        for(ArrayList<Integer> array : list)
        {
        	//int lenof = array.size();
            int index = 0;
            for(int i : array)
            {
                res[count][index] = i;
                index++;
            }
            count++;
        }*/
        int count = 0;
        for(ArrayList<Integer> array : list)
        {
        	int index=0;
        	int lenn = array.size();
        	res[count] = new int[lenn];
        	for(int i :array)
        	{
        		res[count][index] = i;
        		index++;
        	}
        	count++;
        }
        return res;
    }
}
