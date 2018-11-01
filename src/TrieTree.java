

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
			//�ո�
			//System.out.println();
	}
	
	//1. ����һ��ǰ׺����Ĭ����ÿ���ڵ���26�ӽڵ�
	public static class Trie {
		private char name;
		private int num = 1;
		private Trie[] next = new Trie[26];//26��ĸ
		//���캯��
		public Trie(char name) {
			this.name = name;
		}
	}
	
	//2. ����һ����String����ṹת���һ��ǰ׺�����������ɵ�ǰ׺���ķ���
	public static Trie createTrie(String[] str) {
		//2.1 ��������һ��root,��������ν
		Trie root = new Trie('-');
		Trie cur;//�м�ֵ
		//2.2 �������齫�ַ��������ǰ׺����
		for (String s : str) {
			cur = root;
			for (int i = 0; i < s.length(); i++) {
				//2.3 �����ַ�
				int position = s.charAt(i)-'a';//��0��ʼ��25
				if(cur.next[position]==null) {
					cur.next[position] = new Trie(s.charAt(i));
				}else {
					cur.next[position].num++;
				}
				//2.4 ������һ��ѭ��
				cur = cur.next[position];/*�����Լ���д��*/
			}
		}
		//2.3 ����ǰ׺��
		return root;
	}
	
	//3. ��ѯһ��������һ��������ַ����ڸ������ǰ׺����ǰ׺�����ظ�ǰ׺�ַ���
	public static String prefix(Trie root,String str) {
		int len = 0;//ǰ׺�ĳ���
		Trie cur;
		/*
		 * ע�� ����if else ���� ��һ���Ƿ��ؿ��ַ������������ǲ����Ͻ�����һѭ�����ڶ��������ҵ����ǰ׺����
		 */
		for (int i = 0; i < str.length(); i++) {
			//3.1 ��ȡ��ǰ�ڵ���һ��λ�õĽڵ�
			cur = root.next[str.charAt(i)-'a'];/*�����Լ�ѭ���޸��ˣ�ԭ��д����*/
			if(cur==null) {
				break;
			}else if(cur.num==1) {
				//3.2 ��ǰ����
				len++;/*�����Լ���д��*/
				break;
			}else {
				len++;//�ͱ���ַ����ظ������ϣ�����һ��
				//3.2 ��һ������ǰ�ڵ㻻������
				root = cur;
			}
		}
		return str.substring(0, len);
	}
}