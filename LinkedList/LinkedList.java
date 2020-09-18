import java.io.*;
import java.lang.*;

class SinglyLinear
{
	public int Data;
	SinglyLinear Next;
	SinglyLinear Head = null;

	public SinglyLinear(int Data)
	{
		this.Data = Data;
		Next = null;
	}

	public void Create(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyLinear(iValue);
		}
		else
		{
			SinglyLinear temp = Head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = new SinglyLinear(iValue);
		}
	}
	public int Count()
	{
		int count = 0;
		SinglyLinear temp = Head;

		while(temp != null)
		{
			count++;
			temp = temp.Next;
		}

		return count;
	}
	public void InsertFirst(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyLinear(iValue);
		}
		else
		{
			SinglyLinear temp = Head;
			Head = new SinglyLinear(iValue);
			Head.Next = temp;
		}
	}
	public void InsertLast(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyLinear(iValue);
		}
		else
		{
			SinglyLinear temp = Head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = new SinglyLinear(iValue);
		}
	}
	public void InsertAtPos(int iValue,int iPos)
	{
		int size = 0;
		size = Count();
		if(iPos == 1)
		{
			Head = new SinglyLinear(iValue);
		}
		else if (iPos == (size+1))
		{
			InsertLast(iValue);
		}
		else
		{
			SinglyLinear temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			SinglyLinear temp1 = temp.Next;
			temp.Next = new SinglyLinear(iValue);
			temp.Next.Next = temp1;
		}
	}

	public void DeleteHead()
	{
		if(Head.Next == null)
		{
			Head = null;
		}
		else
		{
			SinglyLinear temp = Head.Next;
			Head = temp;
		}
	}

	public void DeleteLast()
	{
		if(Head.Next == null)
		{
			Head = null;
		}
		else
		{
			SinglyLinear temp = Head;
			while(temp.Next.Next != null)
			{
				temp = temp.Next;
			}
			temp.Next = null;
		}
	}

	public void DeleteAtPos(int iPos)
	{
		int size = Count();

		if(iPos == 1)
		{
			DeleteHead();
		}
		else if(iPos == size)
		{
			DeleteLast();
		}
		else
		{
			SinglyLinear temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next = temp.Next.Next;
		}
	}

	public boolean Search(int iValue)
	{
		SinglyLinear temp = Head;
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

	public void Display()
	{
		SinglyLinear temp = Head;
		System.out.print("Data in the SinglyLinear is\t");
		while(temp != null)
		{
			System.out.print(temp.Data+"\t");
			temp = temp.Next;
		}
		System.out.println();
	}		
}

class SinglyCircular
{
	public int Data;
	SinglyCircular Next;
	SinglyCircular Head = null;
	SinglyCircular Tail = null;
	public SinglyCircular(int Data)
	{
		this.Data = Data;
		Next = null;
	}

	public void Create(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyCircular(iValue);
			Tail = Head;
		}
		else
		{
			Tail.Next = new SinglyCircular(iValue);
			Tail = Tail.Next;
			Tail.Next = Head;
		}
	}
	public int Count()
	{
		int count = 0;
		SinglyCircular temp = Head;
		do
		{
			count++;
			temp = temp.Next;
		}while(temp != Tail.Next);
		return count;
	}
	public void InsertFirst(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyCircular(iValue);
			Tail = Head;
		}
		else
		{
			SinglyCircular temp = Head;
			Head = new SinglyCircular(iValue);
			Head.Next = temp;
			Tail.Next = Head;
		}
	}
	public void InsertLast(int iValue)
	{
		if(Head == null)
		{
			Head = new SinglyCircular(iValue);
			Tail = Head;
		}
		else
		{
			Tail.Next = new SinglyCircular(iValue);
			Tail = Tail.Next;
			Tail.Next = Head;
		}
	}
	public void InsertAtPos(int iValue,int iPos)
	{
		int size = 0;
		size = Count();
		if(iPos == 1)
		{
			InsertFirst(iValue);
		}
		else if (iPos == (size+1))
		{
			InsertLast(iValue);
		}
		else
		{
			SinglyCircular temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			SinglyCircular temp1 = temp.Next;
			temp.Next = new SinglyCircular(iValue);
			temp.Next.Next = temp1;
		}
	}

	public void DeleteHead()
	{
		if(Head.Next == null)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			SinglyCircular temp = Head.Next;
			Head = temp;
			Tail.Next = Head;
		}
	}

	public void DeleteLast()
	{
		if(Head.Next == null)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			SinglyCircular temp = Head;
			while(temp.Next.Next != Tail.Next)
			{
				temp = temp.Next;
			}
			Tail = temp;
			Tail.Next = Head;
		}
	}

	public void DeleteAtPos(int iPos)
	{
		int size = Count();

		if(iPos == 1)
		{
			DeleteHead();
		}
		else if(iPos == size)
		{
			DeleteLast();
		}
		else
		{
			SinglyCircular temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next = temp.Next.Next;
		}
	}

	public boolean Search(int iValue)
	{
		SinglyCircular temp = Head;
		boolean find = false;
		do
		{
			if(temp.Data == iValue)
			{
				find = true;
			}
			temp = temp.Next;
		}while(temp != Tail.Next);
		return find;
	}

	public void Display()
	{
		SinglyCircular temp = Head;
		System.out.print("Data in the SinglyCircular is\t");
		do
		{
			System.out.print(temp.Data+"\t");
			temp = temp.Next;
		}while(temp != Tail.Next);
		System.out.println();
	}
}

class DoublyLinear
{
	public int Data;
	DoublyLinear Next;
	DoublyLinear Prev;
	DoublyLinear Head = null;
	DoublyLinear Tail = null;
	public DoublyLinear(int Data)
	{
		this.Data = Data;
		Next = null;
		Prev = null;
	}

	public void Create(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyLinear(iValue);
			Tail = Head;
		}
		else
		{
			DoublyLinear temp = Head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}
			Tail.Next = new DoublyLinear(iValue);
			Tail.Next.Prev = Tail;
			Tail = Tail.Next;
		}
	}
	public int Count()
	{
		int count = 0;
		DoublyLinear temp = Head;
		while(temp != null)
		{
			count++;
			temp = temp.Next;
		}
		return count;
	}
	public void InsertFirst(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyLinear(iValue);
			Tail = Head;
		}
		else
		{
			DoublyLinear temp = Head;
			Head = new DoublyLinear(iValue);
			Head.Next = temp;
			temp.Prev = Head;
		}
	}
	public void InsertLast(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyLinear(iValue);
			Tail = Head;
		}
		else
		{
			Tail.Next = new DoublyLinear(iValue);
			Tail.Next.Prev = Tail;
			Tail = Tail.Next;
		}
	}
	public void InsertAtPos(int iValue,int iPos)
	{
		int size = 0;
		size = Count();
		if(iPos == 1)
		{
			InsertFirst(iValue);
		}
		else if (iPos == (size+1))
		{
			InsertLast(iValue);
		}
		else
		{
			DoublyLinear temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next.Prev = new DoublyLinear(iValue);
			temp.Next.Prev.Next = temp.Next;
			temp.Next = temp.Next.Prev;
			temp.Next.Prev = temp;
		}
	}

	public void DeleteHead()
	{
		if(Head == Tail)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			DoublyLinear temp = Head.Next;
			Head = temp;
			Head.Prev = null;
		}
	}

	public void DeleteLast()
	{
		if(Head == Tail)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			Tail = Tail.Prev;
			Tail.Next = null;			
		}
	}

	public void DeleteAtPos(int iPos)
	{
		int size = Count();

		if(iPos == 1)
		{
			DeleteHead();
		}
		else if(iPos == size)
		{
			DeleteLast();
		}
		else
		{
			DoublyLinear temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next.Next.Prev = temp;
			temp.Next = temp.Next.Next;
		}
	}

	public boolean Search(int iValue)
	{
		DoublyLinear temp = Head;
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

	public void Display()
	{
		DoublyLinear temp = Head;
		System.out.print("Data in the DoublyLinear is\t");
		while(temp != null)
		{
			System.out.print(temp.Data+"\t");
			temp = temp.Next;
		}
		System.out.println();
	}
}

class DoublyCircular
{
	public int Data;
	DoublyCircular Next;
	DoublyCircular Prev;
	DoublyCircular Head = null;
	DoublyCircular Tail = null;
	public DoublyCircular(int Data)
	{
		this.Data = Data;
		Next = null;
		Prev = null;
	}

	public void Create(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyCircular(iValue);
			Tail = Head;
			Tail.Next = Head;
			Head.Prev = Tail;
		}
		else
		{
			Tail.Next = new DoublyCircular(iValue);
			Tail.Next.Prev = Tail;
			Tail = Tail.Next;
			Tail.Next = Head;
			Head.Prev = Tail;
		}
	}
	public int Count()
	{
		int count = 0;
		DoublyCircular temp = Head;
		do
		{
			count++;
			temp = temp.Next;
		}while(temp != Tail.Next);
		return count;
	}
	public void InsertFirst(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyCircular(iValue);
			Tail = Head;
			Tail.Next = Head;
			Head.Prev = Tail;
		}
		else
		{
			DoublyCircular temp = Head;
			Head = new DoublyCircular(iValue);
			temp.Prev = Head;
			Head.Next = temp;
			Head.Prev = Tail;
			Tail.Next = Head;
		}
	}
	public void InsertLast(int iValue)
	{
		if(Head == null)
		{
			Head = new DoublyCircular(iValue);
			Tail = Head;
			Tail.Next = Head;
			Head.Prev = Tail;
		}
		else
		{
			Tail.Next = new DoublyCircular(iValue);
			Tail.Next.Prev = Tail;
			Tail = Tail.Next;
			Head.Prev = Tail;
		}
	}
	public void InsertAtPos(int iValue,int iPos)
	{
		int size = 0;
		size = Count();
		if(iPos == 1)
		{
			InsertFirst(iValue);
		}
		else if (iPos == (size+1))
		{
			InsertLast(iValue);
		}
		else
		{
			DoublyCircular temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next.Prev = new DoublyCircular(iValue);
			temp.Next.Prev.Next = temp.Next;
			temp.Next = temp.Next.Prev;
			temp.Next.Prev = temp;
		}
	}

	public void DeleteHead()
	{
		if(Head.Next == null)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			Head = Head.Next;
			Head.Prev = Tail;
			Tail.Next = Head;
		}
	}

	public void DeleteLast()
	{
		if(Head.Next == null)
		{
			Head = null;
			Tail = null;
		}
		else
		{
			Tail.Prev.Next = Head;
			Tail = Tail.Prev;
			Head.Prev = Tail;
		}
	}

	public void DeleteAtPos(int iPos)
	{
		int size = Count();

		if(iPos == 1)
		{
			DeleteHead();
		}
		else if(iPos == size)
		{
			DeleteLast();
		}
		else
		{
			DoublyCircular temp = Head;
			for(int i = 0;i < (iPos-2);i++)
			{
				temp = temp.Next;
			}
			temp.Next.Next.Prev = temp;
			temp.Next = temp.Next.Next;
		}
	}

	public boolean Search(int iValue)
	{
		DoublyCircular temp = Head;
		boolean find = false;
		do
		{
			if(temp.Data == iValue)
			{
				find = true;
			}
			temp = temp.Next;
		}while(temp != Tail.Next);
		return find;
	}

	public void Display()
	{
		DoublyCircular temp = Head;
		System.out.print("Data in the DoublyCircular is\t");
		do
		{
			System.out.print(temp.Data+"\t");
			temp = temp.Next;
		}while(temp != Tail.Next);
		System.out.println();
	}
}	
class LinkedList
{
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int ch = 0;

			do
			{
				System.out.println("----------------------------------------");
				System.out.println("1.Singly Linear Linked List");
				System.out.println("2.Singly Circular Linked List");
				System.out.println("3.Doubly Linear Linked List");
				System.out.println("4.Doubly Circular Linked List");
				System.out.println("5.Exit");
				System.out.println("----------------------------------------");
				System.out.println("Enter your choice");
				ch = Integer.parseInt(br.readLine());

				switch(ch)
				{
					case 1:
					SinglyLinear SL = new SinglyLinear(0);
					int choice1 = 0;
					do
					{
						System.out.println("----------------------------------------");
						System.out.println("Singly Linear Linked List");
						System.out.println("----------------------------------------");
						System.out.println("1.Create");
						System.out.println("2.Display");
						System.out.println("3.Count");
						System.out.println("4.Insert First");
						System.out.println("5.Insert Last");
						System.out.println("6.Insert At Position");
						System.out.println("7.Delete First");
						System.out.println("8.Delete Last");
						System.out.println("9.Delete At Position");
						System.out.println("10.Search");
						System.out.println("11.Exit");
						System.out.println("----------------------------------------");
						System.out.println("Enter your choice");
						choice1 = Integer.parseInt(br.readLine());
						System.out.println("----------------------------------------");

						switch(choice1)
						{
						case 1:
	
							System.out.println("How many Numbers");
							int iNo = Integer.parseInt(br.readLine());			
							for(int i = 0;i < iNo;i++)
							{
								System.out.println("Enter "+(i+1)+" Number");
								int iN = Integer.parseInt(br.readLine());
								SL.Create(iN);
							}
						break;
	
						case 2:

							SL.Display();
	
						break;
	
						case 3:

							int size = SL.Count();
							System.out.println("Size of SinglyLinear is "+size);

						break;

						case 4:

							System.out.println("Enter Number to insert at First position");
							int iN = Integer.parseInt(br.readLine());
	
							SL.InsertFirst(iN);
	
						break;
	
						case 5:
	
							System.out.println("Enter Number to insert at Last position");
							iN = Integer.parseInt(br.readLine());

							SL.InsertLast(iN);
	
						break;

						case 6:
	
							System.out.println("Enter position where you want to insert");
							int iPos = Integer.parseInt(br.readLine());
							System.out.println("Enter Number to insert at "+iPos+" position");
							iN = Integer.parseInt(br.readLine());
	
							SL.InsertAtPos(iN,iPos);

						break;

						case 7:
	
							SL.DeleteHead();
	
						break;
	
						case 8:
		
							SL.DeleteLast();
	
						break;

						case 9:

							System.out.println("Enter position where you want to delete");
							iPos = Integer.parseInt(br.readLine());
							SL.DeleteAtPos(iPos);

						break;

						case 10:

							System.out.println("Enter Number to search");
							iN = Integer.parseInt(br.readLine());
	
							boolean isFind = SL.Search(iN);

							if(isFind)
							{
								System.out.println("number found ");
							}
							else
							{
								System.out.println("number not found ");
							}
	
						break;

						default :
							System.out.println("Error : Invalid choice");
							break;
						}
					}while(choice1 != 11);

					break;

					case 2:
					SinglyCircular SC = new SinglyCircular(0);
					int choice2 = 0;
					do
					{
						System.out.println("----------------------------------------");
						System.out.println("Singly Circular Linked List");
						System.out.println("----------------------------------------");
						System.out.println("1.Create");
						System.out.println("2.Display");
						System.out.println("3.Count");
						System.out.println("4.Insert First");
						System.out.println("5.Insert Last");
						System.out.println("6.Insert At Position");
						System.out.println("7.Delete First");
						System.out.println("8.Delete Last");
						System.out.println("9.Delete At Position");
						System.out.println("10.Search");
						System.out.println("11.Exit");
						System.out.println("----------------------------------------");
						System.out.println("Enter your choice");
						choice2 = Integer.parseInt(br.readLine());
						System.out.println("----------------------------------------");

						switch(choice2)
						{
						case 1:
	
							System.out.println("How many Numbers");
							int iNo =
Integer.parseInt(br.readLine());			
							for(int i = 0;i < iNo;i++)
							{
								System.out.println("Enter "+(i+1)+" Number");
								int iN = Integer.parseInt(br.readLine());
								SC.Create(iN);
							}
						break;
	
						case 2:

							SC.Display();
	
						break;
	
						case 3:

							int size = SC.Count();
							System.out.println("Size of SinglyLinear is "+size);

						break;

						case 4:

							System.out.println("Enter Number to insert at First position");
							int iN = Integer.parseInt(br.readLine());
	
							SC.InsertFirst(iN);
	
						break;
	
						case 5:
	
							System.out.println("Enter Number to insert at Last position");
							iN = Integer.parseInt(br.readLine());

							SC.InsertLast(iN);
	
						break;

						case 6:
	
							System.out.println("Enter position where you want to insert");
							int iPos = Integer.parseInt(br.readLine());
							System.out.println("Enter Number to insert at "+iPos+" position");
							iN = Integer.parseInt(br.readLine());
	
							SC.InsertAtPos(iN,iPos);

						break;

						case 7:
	
							SC.DeleteHead();
	
						break;
	
						case 8:
		
							SC.DeleteLast();
	
						break;

						case 9:

							System.out.println("Enter position where you want to delete");
							iPos = Integer.parseInt(br.readLine());
							SC.DeleteAtPos(iPos);

						break;

						case 10:

							System.out.println("Enter Number to search");
							iN = Integer.parseInt(br.readLine());
	
							boolean isFind = SC.Search(iN);

							if(isFind)
							{
								System.out.println("number found ");
							}
							else
							{
								System.out.println("number not found ");
							}
	
						break;

						default :
							System.out.println("Error : Invalid choice");
							break;
						}
					}while(choice2 != 11);

					break;

					case 3:
					DoublyLinear DL = new DoublyLinear(0);
					int choice3 = 0;
					do
					{
						System.out.println("----------------------------------------");
						System.out.println("Doubly Linear Linked List");
						System.out.println("----------------------------------------");
						System.out.println("1.Create");
						System.out.println("2.Display");
						System.out.println("3.Count");
						System.out.println("4.Insert First");
						System.out.println("5.Insert Last");
						System.out.println("6.Insert At Position");
						System.out.println("7.Delete First");
						System.out.println("8.Delete Last");
						System.out.println("9.Delete At Position");
						System.out.println("10.Search");
						System.out.println("11.Exit");
						System.out.println("----------------------------------------");
						System.out.println("Enter your choice");
						choice3 = Integer.parseInt(br.readLine());
						System.out.println("----------------------------------------");

						switch(choice3)
						{
						case 1:
	
							System.out.println("How many Numbers");
							int iNo =
Integer.parseInt(br.readLine());			
							for(int i = 0;i < iNo;i++)
							{
								System.out.println("Enter "+(i+1)+" Number");
								int iN = Integer.parseInt(br.readLine());
								DL.Create(iN);
							}
						break;
	
						case 2:

							DL.Display();
	
						break;
	
						case 3:

							int size = DL.Count();
							System.out.println("Size of SinglyLinear is "+size);

						break;

						case 4:

							System.out.println("Enter Number to insert at First position");
							int iN = Integer.parseInt(br.readLine());
	
							DL.InsertFirst(iN);
	
						break;
	
						case 5:
	
							System.out.println("Enter Number to insert at Last position");
							iN = Integer.parseInt(br.readLine());

							DL.InsertLast(iN);
	
						break;

						case 6:
	
							System.out.println("Enter position where you want to insert");
							int iPos = Integer.parseInt(br.readLine());
							System.out.println("Enter Number to insert at "+iPos+" position");
							iN = Integer.parseInt(br.readLine());
	
							DL.InsertAtPos(iN,iPos);

						break;

						case 7:
	
							DL.DeleteHead();
	
						break;
	
						case 8:
		
							DL.DeleteLast();
	
						break;

						case 9:

							System.out.println("Enter position where you want to delete");
							iPos = Integer.parseInt(br.readLine());
							DL.DeleteAtPos(iPos);

						break;

						case 10:

							System.out.println("Enter Number to search");
							iN = Integer.parseInt(br.readLine());
	
							boolean isFind = DL.Search(iN);

							if(isFind)
							{
								System.out.println("number found ");
							}
							else
							{
								System.out.println("number not found ");
							}
	
						break;

						default :
							System.out.println("Error : Invalid choice");
							break;
						}
					}while(choice3 != 11);

					break;

					case 4:
					DoublyCircular DC = new DoublyCircular(0);
					int choice4 = 0;
					do
					{
						System.out.println("----------------------------------------");
						System.out.println("Doubly Circular Linked List");
						System.out.println("----------------------------------------");
						System.out.println("1.Create");
						System.out.println("2.Display");
						System.out.println("3.Count");
						System.out.println("4.Insert First");
						System.out.println("5.Insert Last");
						System.out.println("6.Insert At Position");
						System.out.println("7.Delete First");
						System.out.println("8.Delete Last");
						System.out.println("9.Delete At Position");
						System.out.println("10.Search");
						System.out.println("11.Exit");
						System.out.println("----------------------------------------");
						System.out.println("Enter your choice");
						choice4 = Integer.parseInt(br.readLine());
						System.out.println("----------------------------------------");

						switch(choice4)
						{
						case 1:
	
							System.out.println("How many Numbers");
							int iNo =
Integer.parseInt(br.readLine());			
							for(int i = 0;i < iNo;i++)
							{
								System.out.println("Enter "+(i+1)+" Number");
								int iN = Integer.parseInt(br.readLine());
								DC.Create(iN);
							}
						break;
	
						case 2:

							DC.Display();
	
						break;
	
						case 3:

							int size = DC.Count();
							System.out.println("Size of SinglyLinear is "+size);

						break;

						case 4:

							System.out.println("Enter Number to insert at First position");
							int iN = Integer.parseInt(br.readLine());
	
							DC.InsertFirst(iN);
	
						break;
	
						case 5:
	
							System.out.println("Enter Number to insert at Last position");
							iN = Integer.parseInt(br.readLine());

							DC.InsertLast(iN);
	
						break;

						case 6:
	
							System.out.println("Enter position where you want to insert");
							int iPos = Integer.parseInt(br.readLine());
							System.out.println("Enter Number to insert at "+iPos+" position");
							iN = Integer.parseInt(br.readLine());
	
							DC.InsertAtPos(iN,iPos);

						break;

						case 7:
	
							DC.DeleteHead();
	
						break;
	
						case 8:
		
							DC.DeleteLast();
	
						break;

						case 9:

							System.out.println("Enter position where you want to delete");
							iPos = Integer.parseInt(br.readLine());
							DC.DeleteAtPos(iPos);

						break;

						case 10:

							System.out.println("Enter Number to search");
							iN = Integer.parseInt(br.readLine());
	
							boolean isFind = DC.Search(iN);

							if(isFind)
							{
								System.out.println("number found ");
							}
							else
							{
								System.out.println("number not found ");
							}
	
						break;

						default :
							System.out.println("Error : Invalid choice");
							break;
						}
					}while(choice4 != 11);

					break;

					case 5:
						System.exit(0);
					break;

					default :
						System.out.println("Error : Invalid Choice");
					break;
				}
			}while(ch != 5);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
