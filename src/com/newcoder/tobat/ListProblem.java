package com.newcoder.tobat;

import java.util.LinkedList;
import java.util.Stack;

class Node
{
     int value;
     Node next;
     Node(int value)
     {
    	 this.value = value;
     }     
}

public class ListProblem
{
    public static void main(String[] args)
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Node reverseHead = reverseK(head, 3);
		Node cur = reverseHead;
		System.out.println(reverseHead.next);
		while(cur != null)
		{
			System.out.println(cur.value);
			cur = cur.next;
		}
		
	}    
    
    public static Node insertInCycle(Node head,int num)
    {
    	//在循环有序链表中插入值
    	Node node = new Node(num);
    	if(head == null)
    	{
    		node.next = node;
    		return node;
    	}
    	Node pre = head;
    	Node cur = head.next;
    	while(cur != head)
    	{
    		//没有遍历回到头结点
    		if(pre.value<= num && num<= cur.value)
    		{
    			break;//找到了这个插入位置
    		}
    		else
    		{
    			//寻找下一个插入位置
    			pre = pre.next;
    			cur = cur.next;
    		}
    	}
    	pre.next = node;
    	node.next = cur;
    	return head.value <= num ? head : node;
    }
    
    public static Node getIntersect(Node headA,Node headB)
    {
    	if(headA == null || headB == null)
    	{
    		return null;
    	}
    	Node nodeA = headA;
    	Node nodeB = headB;
    	int lena = getLen(headA);
    	int lenb = getLen(headB);
    	if(lena - lenb>0)
    	{
    		while(lena-lenb!=0)
    		{
    			nodeA = nodeA.next;
    			lena--;
    		}
    	}
    	else
    	{
    		while(lenb-lena != 0)
    		{
    			nodeB = nodeB.next;
    			lenb--;
    		}
    	}
    	while(nodeA != null && nodeB != null)
    	{
    		if(nodeA.value == nodeB.value)
    		{
    			return nodeA;
    		}
    		else
    		{
    			nodeA = nodeA.next;
    			nodeB = nodeB.next;
    		}
    	}
    	return null;
    }
    public static int getLen(Node head)
    {
    	int len = 0;
    	Node node = head;
    	while(node != null)
    	{
    		len++;
    		node = node.next;
    	}
    	return len;
    }
    
    public static boolean isLoop(Node head)
    {
    	if(head == null)
    		return false;
    	Node fast = head;
    	Node slow = head;
    	while(fast != null && fast.next !=null)
    	{
    		//当快指针遍历结束的时候 代表着链表走到头了 必定无环
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow)
    		{
    			return true;
    		}
    	}
    	return !(fast==null || fast.next!=null);
    }
    
    public static Node loopPosition(Node head)
    {
    	if(head == null)
    	{
    		return null;
    	}
    	Node fast = head;
    	Node slow = head;
    	while(fast != null || fast.next != null)
    	{
    		fast = fast.next.next;
    		slow = slow.next;
    		if(fast == slow)
    		{
    			break;
    		}
    	}
    	if(fast == null || fast.next == null)
    	{
    		return null;
    	}
    	fast = head;
    	while(fast != slow)
    	{
    		fast = fast.next;
    		slow = slow.next;
    	}
    	return fast;	
    }
    
    public static Node reverse(Node head)
    {
    	if(head == null || head.next == null)
    	{
    		return head;
    	}
    	head.next = null;
    	Node p1 = head;
    	Node p2 = head.next;
    	head.next = null;
    	while(p2 != null)
    	{
    		Node temp = p2.next;
    		p2.next = p1;
    		p1 = p2;
    		p2 = temp;
    	}
    	return p1;
    	
    }
    
    public static Node removeNode(Node head,int val)
    {
        Node curr = null;
        
        //寻找出头节点，头节点是链表中第一个值不等于value的节点
        while(head != null)
        {
        	if(val != head.value)
        	{
        		break;
        	}
        	curr = head;
        	head = head.next;
        }
        
        curr = head.next;
        Node pre = head;
        while(curr != null)
        {
        	if(curr.value == val)
        	{
        		pre.next = curr.next;
        	}
        	else
        	{
        		pre = curr;
        	}
        	curr = pre.next;
        }
        return head;
    }
    
    
    public static Node reverseK(Node head,int k)
    {
    	if(k <= 1)
    		return head;
    	if(head == null)
    		return null;
    	Node root = new Node(-1);
    	root.next = head;
    	Node current = root;//头节点前面的一个几点
    	while(current.next != null)
    	{
    		int count = 0;
    		Node reversedHead = current.next;//接下来需要翻转的头部节点
    		Node reversedTail = current;
    		for(int i=0;i<k;i++)
    		{
    			//寻找需要翻转的节点末位
    			reversedTail = reversedTail.next;
    			if(reversedTail == null)
    			{
    				//链表长度不足k个
    				return root.next;
    			}
    		}
    		current.next = reversedTail;
    		Node reverseNext = reversedTail.next;//下一段需要翻转的头部节点
    		reversedTail.next = null;
    		reverse(reversedHead);
    		//翻转结束后 reverseHead 变成链表尾部 reversedTail 变成链表头部
    		reversedHead.next = reverseNext;
    		current = reversedHead;// 相当于第一段时候的root 就是开始节点的前一个节点
    	}
    	return root.next;
    }

}
