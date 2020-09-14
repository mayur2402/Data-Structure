import java.io.*;
import java.lang.*;

class node
{
	public int Data;
	node Next;
	public node(int Data)
	{
		this.Data = Data;
		Next = null;
	}
}
class SinglyLinked
{
	public node Create(int iValue,node Head)
	{
		if(Head == null)
		{
			Head = new node(iValue);
		}
		else
		{
			node temp = Head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = new node(iValue);
		}
		return Head;
	}
	public int Count(node Head)
	{
		int count = 0;
		node temp = Head;
		while(temp != null)
		{
			count++;
			temp = temp.Next;
		}
		return count;
	}
	public node InsertFirst(int iValue,node Head)
	{
		if(Head == null)
		{
			Head = new node(iValue);
		}
		else
		{
			node temp = Head;
			Head = new node(iValue);
			Head.Next = temp;
		}
		return Head;
	}
	public node InsertLast(int iValue,node Head)
	{
		if(Head == null)
		{
			Head = new node(iValue);
		}
		else
		{
			node temp = Head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = new node(iValue);
		}
		return Head;
	}
	public node InsertAtPos(int iValue,int iPos,node Head)
	{
		int size = 0;
		size = Count(Head);
		if(iPos == 1)
		{
			Head = new node(iValue);
		}
		else if (iPos == size)
		{
			InsertLast(iValue,Head);
		}
		else
		{
			node temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			node temp1 = temp.Next;
			temp.Next = new node(iValue);
			temp.Next.Next = temp1;
		}
		return Head;
	}

	public node DeleteFirst(node Head)
	{
		if(Head.Next == null)
		{
			Head = null;
		}
		else
		{
			node temp = Head.Next;
			Head = temp;
		}
		return Head;
	}

	public node DeleteLast(node Head)
	{
		if(Head.Next == null)
		{
			Head = null;
		}
		else
		{
			node temp = Head;
			while(temp.Next.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = null;
		}
		return Head;
	}

	public node DeleteAtPos(int iPos,node Head)
	{
		int size = Count(Head);

		if(iPos == 1)
		{
			DeleteFirst(Head);
		}
		else if(iPos == size)
		{
			DeleteLast(Head);
		}
		else
		{
			node temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next = temp.Next.Next;
		}
		return Head;
	}

	public boolean Search(int iValue,node Head)
	{
		node temp = Head;
		boolean find = false;
		while(temp != null)
		{
			if(temp.Data == iValue)
			{
				find = true;
			}
			temp = temp.Next;
		}
		return find;
	}

	public void Display(node Head)
	{
		node temp = Head;
		System.out.print("Data in the list is\t");
		while(temp != null)
		{
			System.out.print(temp.Data+"\t");
			temp = temp.Next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			SinglyLinked list = new SinglyLinked();

			node First = null;
			int ch = 0;

			do
			{
				System.out.println("1.Create");
				System.out.println("2.Display");
				System.out.println("3.Count");
				System.out.println("4.InsertFirst");
				System.out.println("5.InsertLast");
				System.out.println("6.InsertAtPos");
				System.out.println("7.DeleteFirst");
				System.out.println("8.DeleteLast");
				System.out.println("9.DeleteAtPos");
				System.out.println("10.Search");
				System.out.println("11.Exit");
				System.out.println("Enter your choice");
				ch = Integer.parseInt(br.readLine());

				switch(ch)
				{
					case 1:

					System.out.println("How many Numbers");
					int iNo = Integer.parseInt(br.readLine());			
					for(int i = 0;i < iNo;i++)
					{
						System.out.println("Enter "+(i+1)+" Number");
						int iN = Integer.parseInt(br.readLine());
						First = list.Create(iN,First);
					}
					break;

					case 2:

					list.Display(First);

					break;

					case 3:

					int size = list.Count(First);
					System.out.println("Size of list is "+size);

					break;

					case 4:

					System.out.println("Enter Number to insert at first position");
					int iN = Integer.parseInt(br.readLine());

					First = list.InsertFirst(iN,First);

					break;

					case 5:

					System.out.println("Enter Number to insert at Last position");
					iN = Integer.parseInt(br.readLine());

					First = list.InsertLast(iN,First);

					break;

					case 6:

					System.out.println("Enter position where you want to insert");
					int iPos = Integer.parseInt(br.readLine());
					System.out.println("Enter Number to insert at "+iPos+" position");
					iN = Integer.parseInt(br.readLine());

					First = list.InsertAtPos(iN,iPos,First);

					break;

					case 7:

					First = list.DeleteFirst(First);

					break;

					case 8:

					First = list.DeleteLast(First);

					break;

					case 9:

					System.out.println("Enter position where you want to delete");
					iPos = Integer.parseInt(br.readLine());
					First = list.DeleteAtPos(iPos,First);

					break;

					case 10:

					System.out.println("Enter Number to search");
					iN = Integer.parseInt(br.readLine());

					boolean isFind = list.Search(iN,First);

					if(isFind)
					{
						System.out.println("number found ");
					}
					else
					{
						System.out.println("number not found ");
					}

					break;
				}
			}while(ch < 11);
		}
		catch(Exception e)
		{

		}
	}
}
