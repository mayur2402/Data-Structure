import java.util.*;

class StackDemo
{
	public static void main(String args[])
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			Stack<String> stack = new Stack();

			System.out.println("How many names in stack");
			int iNo = sc.nextInt();

			for(int i = 0;i < iNo; i++)
			{
				System.out.println("Enter "+(i+1)+" name ");
				String sName = sc.next();

				stack.push(sName);
			}
			System.out.println(stack);

			System.out.println("First name in stack is "+stack.peek());
			System.out.println("Pop name in stack is "+stack.pop());

			System.out.println("Enter name to search in stack");
			String name = sc.next();

			int ipos = stack.search(name);

			if(ipos == -1)
			{
				System.out.println("not found");
			}
			else
			{
				System.out.println("found at "+ipos);
			}

			System.out.println("Names in the Stack "+stack);
			Iterator itr = stack.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}

			ArrayList AL = new ArrayList(stack);
			System.out.println("Names in the Array List "+AL);

			LinkedList list = new LinkedList(stack);
			System.out.println("Names in the Linked List "+list);

			Vector vector = new Vector(stack);
			System.out.println("Names in the Vector "+vector);

			stack.clear();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
