package muk.ds.linkedlist.que;

// find the Mid Element of the LinkedList
public class FindMidElement 
{
	static Node head;
	public FindMidElement(int data)
	{
		head=new Node(data);
	}
	
	public static int getMidElement()
	{
		if(head==null)
		{
			return Integer.MIN_VALUE;
		}
		Node curPtr=head;
				Node nxtPtr=head;
				while(nxtPtr!=null && nxtPtr.next!=null)
				{
					nxtPtr=nxtPtr.next.next;
					curPtr=curPtr.next;
				}
				return curPtr.data;
	}
	
	//find the nth node data from the end of the linkedList
	public static int nthNodeFromEnd(int n)
	{
		int len=FindDuplicate.length(head);
		if(n>len || n<0)
		{
			return Integer.MIN_VALUE;
		}
		int data=0;
		for(int i=1;i<=len;i++)
		{
			if(i==(len-n+1))
			{
				data=head.data;
				break;
			}
			head=head.next;
		}
		return data;
	}
	
	private static int getLengthRec(Node head)
	{
		if(head==null)
		{
			return 0;
		}
		return 1+getLengthRec(head.next);
	}
//get length of the LinkedList Recursivly
public static int getLength()
{
	return getLengthRec(head);
}

//get nth node of a LinkedList from the start or head
public static int getNthElement(int n)
{
	int len=getLength();
	if(head==null || n>len || n<0)
	{
		return Integer.MIN_VALUE;
		
	}
	int element=0;
	for(int i=1;i<=n;i++)
	{
		if(i==n)
		{
			element=head.data;
		}
		head=head.next;
	}
	return element;
	
	
	
}

	public static void main(String[] args) 
	{
		head=new Node(1);
		Node n=new Node(2);
		head.next=n;
		Node th=new Node(6);
		n.next=th;
		Node ft=new Node(7);
		th.next=ft;
		Node st=new Node(9);
		ft.next=st;
		Node se=new Node(3);
		st.next=se;
		Node eg=new Node(10);
		se.next=eg;
		Node ni=new Node(15);
		eg.next=ni;
		
		FindDuplicate.printLinkedList(head);
		System.out.println("Mid Element in a linkedList: "+getMidElement());
		System.out.println("get nth element from the end :"+nthNodeFromEnd(9));
		System.out.println("get length of LinkedList Recursivly: "+getLength());
		System.out.println("get nth element from the first: "+getNthElement(8));
	}
	
}
