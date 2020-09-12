import java.util.*;

class LinkedListDemo
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			LinkedList<String> List = new LinkedList<String>();

			System.out.println("How many names");
			int iNo = sc.nextInt();

			for(int i = 0;i < iNo;i++)
			{
				System.out.println("Enter "+(i+1)+" Name");
				String sName = sc.next();

				List.add(sName);
			}

			System.out.println("Names in the Linked List "+List);

			System.out.println("Size of Linked List "+List.size());

			System.out.println("Enter Name to remove");
			String sName = sc.next();
			List.remove(sName);

			System.out.println("Names in the Linked List "+List);

			System.out.println("Enter postion where you want to insert Name");
			int iPos = sc.nextInt();
			System.out.println("Enter Name to add");
			sName = sc.next();
			List.add(iPos,sName);

			System.out.println("Names in the Linked List "+List);

			System.out.println("Enter postion where you want to replace Name");
			iPos = sc.nextInt();
			System.out.println("Enter Name to replace");
			sName = sc.next();
			List.set(iPos,sName);

			System.out.println("Names in the Linked List "+List);
			Iterator itr = List.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}		

			ArrayList AL = new ArrayList(List);

			System.out.println("Names in the Array List "+AL);

			List.clear();
			 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
