

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
 
public class TrieTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			String[] strs = new String[num]; 
			for (int i = 0; i < num; i++) {
				strs[i]  = scanner.next();
			}
			Trie root = createTrie(strs);
			
			for (String s : strs) {
				String prefix = prefix(root, s);
				System.out.println(prefix);
			}
			//空格
			//System.out.println();
	}
	
	//1. 创建一个前缀树，默认是每个节点有26子节点
	public static class Trie {
		private char name;
		private int num = 1;
		private Trie[] next = new Trie[26];//26字母
		//构造函数
		public Trie(char name) {
			this.name = name;
		}
	}
	
	//2. 创建一个将String数组结构转变成一个前缀树并返回生成的前缀树的方法
	public static Trie createTrie(String[] str) {
		//2.1 首先生成一个root,内容无所谓
		Trie root = new Trie('-');
		Trie cur;//中间值
		//2.2 遍历数组将字符插入这个前缀树中
		for (String s : str) {
			cur = root;
			for (int i = 0; i < s.length(); i++) {
				//2.3 插入字符
				int position = s.charAt(i)-'a';//从0开始到25
				if(cur.next[position]==null) {
					cur.next[position] = new Trie(s.charAt(i));
				}else {
					cur.next[position].num++;
				}
				//2.4 进入下一个循环
				cur = cur.next[position];/*这里自己少写了*/
			}
		}
		//2.3 返回前缀树
		return root;
	}
	
	//3. 查询一个包含在一个数组的字符串在该数组的前缀树中前缀并返回该前缀字符串
	public static String prefix(Trie root,String str) {
		int len = 0;//前缀的长度
		Trie cur;
		/*
		 * 注意 三个if else 条件 第一个是返回空字符串，第三个是不符合进行下一循环，第二步才是找到最短前缀结束
		 */
		for (int i = 0; i < str.length(); i++) {
			//3.1 获取当前节点下一个位置的节点
			cur = root.next[str.charAt(i)-'a'];/*这里自己循环修改了，原来写错了*/
			if(cur==null) {
				break;
			}else if(cur.num==1) {
				//3.2 当前符合
				len++;/*这里自己少写了*/
				break;
			}else {
				len++;//和别的字符串重复不符合，查下一个
				//3.2 下一步将当前节点换成如下
				root = cur;
			}
		}
		return str.substring(0, len);
	}
}