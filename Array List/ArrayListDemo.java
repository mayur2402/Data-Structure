import java.util.*;

class ArrayListDemo
{
	public static void main(String args[]) 
	{
		try
		{
			Scanner sc = new Scanner(System.in);

			ArrayList<Integer> AL = new ArrayList<Integer> ();

			System.out.println("How many elements ");
			int iNo = sc.nextInt();

			for(int i = 0;i < iNo;i++)
			{
				System.out.println("Enter "+(i+1)+" element");
				int iValue = sc.nextInt();
				AL.add(iValue);
			}

			LinkedList ll = new LinkedList(AL);

			System.out.println("Array List is\t:"+AL);

			System.out.println("Linked List is \t:"+ll);

			System.out.println("Size of array list is \t:"+AL.size());

			System.out.println("Enter position to delete that position element");
			int pos = sc.nextInt();

			AL.remove(pos);

			System.out.println("Array List is\t:"+AL);

			AL.set(2,100);

			System.out.println("Array List is\t:"+AL);

			System.out.println("Enter number whose first index you want");
			iNo = sc.nextInt();

			pos = AL.indexOf(iNo);

			System.out.println(pos);

			System.out.println("Enter number whose last index you want");
			iNo = sc.nextInt();

			pos = AL.lastIndexOf(iNo);

			System.out.println(pos);

			Iterator itr = AL.iterator();

			System.out.println("Array List is\t:"+AL);
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}
}
