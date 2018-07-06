package muk.ds.linkedlist.que;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicate 
{
	Node head;
	public FindDuplicate(int data)
	{
		head=new Node(data);
	}
	
	public Set<Integer> getDuplicate(Node head)
	{
		if(head==null)
		{
			return null;
		}
		Set<Integer> duplicateSet=new HashSet<>();
		Node nxt=null;
		while(head!=null)
		{
			nxt=head.next;
			while(nxt!=null)
			{
				if(head.data==nxt.data)
				{
					duplicateSet.add(head.data);
					nxt=nxt.next;
					
				}
				else
				{
					nxt=nxt.next;
				}
			}
			head=head.next;
			//nxt=head.next;
		}
		return duplicateSet;
	}
	
	public static int length(Node head)
	{
		if(head==null)
		{
			return 0;
		}
		int len=0;
		while(head!=null)
		{
			len++;
			head=head.next;
		}
		return len;
	}
	public static void printLinkedList(Node head)
	{
		if(head==null)
		{
			return;
		}
		while(head!=null)
		{
			System.out.print(head.data+"->");
			head=head.next;
		}
	}
	
	//print linkedList Recursivly
	public static void print(Node head)
	{
		if(head==null)
		{
			return;
		}
		System.out.print(head.data+"->");
		print(head.next);
	}
	
	public static int max(Node head)
	{
		if(head==null)
		{
			return Integer.MIN_VALUE;
		}
		int max=Integer.MIN_VALUE;
		while(head!=null)
		{
			if(head.data>max)
			{
				max=head.data;
				head=head.next;
			}
			else
			{
				head=head.next;
			}
		}
		return max;
	}
	
	public static int min(Node head)
	{
		if(head==null)
		{
			return Integer.MIN_VALUE;
		}
		int min=Integer.MAX_VALUE;
		while(head!=null)
		{
			if(head.data<min)
			{
				min=head.data;
				head=head.next;
			}
			else
			{
				head=head.next;
			}
		}
		
		return min;
		
	}
	public static int noOfCountOfGivenNum(Node head,int n)
	{
		if(head==null)
		{
		 return Integer.MIN_VALUE;
		}
		int count=0;
		while(head!=null)
		{
			if(head.data==n)
			{
				count++;
				head=head.next;
			}
			else
			{
				head=head.next;
			}
		}
		return count;
	}
	
	public static Map<Integer,Integer> countTheElement(Node head)
	{
		if(head==null)
		{
			return null;
		}
		Map<Integer,Integer> countMap=new HashMap<>();
	
		while(head!=null)
		{
		
			if(countMap.containsKey(head.data))
			{
				countMap.put(head.data, countMap.get(head.data)+1);
				head=head.next;
			}
			else
			{
				countMap.put(head.data, 1);
				head=head.next;
			}
		}
		return countMap;
	}
	
	
	
	
	public static void main(String[] args) 
	{
		FindDuplicate likedList=new FindDuplicate(11);
		likedList.head.next=new Node(1);
		Node th=new Node(4);
		likedList.head.next.next=th;
		Node fth=new Node(1);
		th.next=fth;
		Node sth=new Node(1);
		fth.next=sth;
		Set<Integer> duplicateList=likedList.getDuplicate(likedList.head);
		if(duplicateList.size()>0)
		{
			System.out.println("list of dupliacate in the linked List: "+duplicateList);
		}
		else
		{
			System.out.println("No duplicate Element found in a linkedList");
		}
		
	//	printLinkedList(likedList.head);
		print(likedList.head);
		System.out.println("length of linkedList: "+length(likedList.head));
		System.out.println("Maximum element in a LinkedList: "+max(likedList.head));
		System.out.println("Minimum Element in a LinkedList: "+min(likedList.head));
		System.out.println("count: "+noOfCountOfGivenNum(likedList.head, 1) );
		System.out.println("get all element count: "+countTheElement(likedList.head));
		
		
	}
}

