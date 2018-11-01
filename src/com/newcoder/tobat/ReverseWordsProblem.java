package com.newcoder.tobat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ReverseWordsProblem
{
    public static void main(String[] args)
	{
//		String string = "My name is LiLei";
//		String revString = reverse(string);
//		System.out.println(revString);
//		String s1  ="abcde";
//		String string2 = "cdeab";
//		System.out.println(isRotate(s1, string2));
//		TreeNode root = new TreeNode(3);
//		root.left = new TreeNode(9);
//		root.right = new TreeNode(20);
//		root.right.left = new TreeNode(15);
//		root.right.right = new TreeNode(7);
//		System.out.println(levelOrderBottom(root));
//		String[] words = {"ba","b","abb","a","cad","c","dk","kd","aoe","zebra","super"};
//		System.out.println(findSamllest(words));
		String ss = "aaaa";
		System.out.println(longestSubstring(ss));
		}

	private static String reverse(String string)
	{
		StringBuffer sBuffer = new StringBuffer();
		String[] words = string.trim().split(" +");
		for(int i=words.length-1;i>=0;i--)
		{
			sBuffer.append(words[i]).append(" ");
		}
		return sBuffer.toString();
	}
	private static boolean isRotate(String A,String B)
	{
		String longString = A+A;
		if(A == null || B ==null || A.length() != B.length())
			return false;
		if(longString.contains(B))
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public static List<List<Integer>> res = new ArrayList<List<Integer>>();
    public static List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();  
                System.out.println(node.val+" node.val");
                list.add(node.val);
                if(node.left != null)
                {
                    queue.add(node.left);
                }
                if(node.right != null)
                {
                    queue.add(node.right);
                }
                System.out.println(list);
            }
            res.add(0,list);
            System.out.println(res);
        }
        return res;
    }
    
    public static String findSamllest(String[] words)
    {
    	if(words.length == 0 || words == null)
    	{
    		return "";
    	}
    	Arrays.sort(words, new Comparator<String>()
		{

			public int compare(String o1, String o2)
			{
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
		});
    	StringBuffer sBuffer = new StringBuffer();
    	for(int i=0;i<words.length;i++)
    	{
    		sBuffer.append(words[i]);
    	}
    	return sBuffer.toString();
    }
    
    public static String largestNumber(int[] nums)
    {
    	if(nums == null || nums.length == 0)
    		return "";
    	String[] words = new String[nums.length];
    	for(int i=0;i<nums.length;i++)
    	{
    		words[i] = String.valueOf(nums[i]);
    	}
    	Arrays.sort(words, new Comparator<String>()
		{

			public int compare(String o1, String o2)
			{
				// TODO Auto-generated method stub
				return (o1+o2).compareTo(o2+o1);
			}
		});
    	StringBuffer sBuffer = new StringBuffer();
    	for(int i=0;i<words.length;i++)
    	{
    		sBuffer.append(words[i]);
    	}
    	return sBuffer.toString();
    }
    
    /**
     * 以每个位置为结尾时的最长不重复子串
     *  min（i-map.get(s.charAt(i))，
     *   i-(i-1-dp[i-1]) = dp[i-1]+1)
     * @param s
     * @return
     */
    public static int longestSubstring(String s)
    {
    	Map<Character, Integer> map = new HashMap<>();//用来保存上一次出现字符的位置
    	int[] dp = new int[s.length()];
    	char[] ch = s.toCharArray();
    	if(ch==null || ch.length == 0)
    		return 0;
    	dp[0] = 1;
    	map.put(ch[0], 0);
    	for(int i=1;i<s.length();i++)
    	{
    		if(!map.containsKey(ch[i]))
    		{
    			dp[i] = dp[i-1]+1;
    			map.put(ch[i], i);
    		}
    		else {
				dp[i] = Math.min(i-map.get(ch[i]), dp[i-1]+1);
				map.put(ch[i], i);
			}
    	}
    	int max = 1;
    	for(int i=1;i<ch.length;i++)
    	{
    		max = Math.max(max, dp[i]);
    		System.out.println(i+" "+dp[i]);
    	}
    	return max;
    }
}
