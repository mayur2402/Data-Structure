import java.util.*;

class VectorDemo
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Vector<String> vector = new Vector<String>();

			System.out.println("How many names");
			int iNo = sc.nextInt();

			for(int i = 0;i < iNo;i++)
			{
				System.out.println("Enter "+(i+1)+" Name");
				String sName = sc.next();

				vector.add(sName);
			}

			System.out.println("Names in the Vector "+vector);

			System.out.println("Size of Vector "+vector.size());

			System.out.println("Enter Name to remove");
			String sName = sc.next();
			vector.remove(sName);

			System.out.println("Names in the Vector "+vector);

			System.out.println("Enter postion where you want to insert Name");
			int iPos = sc.nextInt();
			System.out.println("Enter Name to add");
			sName = sc.next();
			vector.add(iPos,sName);

			System.out.println("Names in the Vector "+vector);

			System.out.println("Enter postion where you want to replace Name");
			iPos = sc.nextInt();
			System.out.println("Enter Name to replace");
			sName = sc.next();
			vector.set(iPos,sName);

			System.out.println("Names in the Vector "+vector);
			Iterator itr = vector.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}


			ArrayList AL = new ArrayList(vector);

			System.out.println("Names in the Array List "+AL);

			LinkedList list = new LinkedList(vector);

			System.out.println("Names in the Linked List "+list);

			vector.clear();
			 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
