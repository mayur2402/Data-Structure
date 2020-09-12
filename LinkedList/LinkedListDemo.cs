using System;
using System.Collections;
using System.Collections.Generic;
class ArrayListDemo
{
	public static void Main(string[] args)
	{
		try
		{
			LinkedList<int> list = new LinkedList<int>();

			Console.WriteLine("How many elements");
			int iNo = int.Parse(Console.ReadLine());

			for(int i = 0;i < iNo;i++)
			{
				Console.WriteLine("Enter {0} number",i+1);
				int iN = int.Parse(Console.ReadLine());
				list.AddLast(iN);
			}

			Console.WriteLine("Enter number to add at first position");
			int iNum = int.Parse(Console.ReadLine());
			list.AddFirst(iNum);

			foreach(int i in list)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			Console.WriteLine("Enter Element to remove");
			iNo = int.Parse(Console.ReadLine());

			list.Remove(iNo);

			Console.WriteLine("list after Element remove");
			foreach(int i in list)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			list.RemoveFirst();

			Console.WriteLine("list after first Element remove");
			foreach(int i in list)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			list.RemoveLast();

			Console.WriteLine("list after Last Element remove");
			foreach(int i in list)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();


			list.Clear();
			
		}
		catch(Exception e)
		{
			Console.WriteLine(e);
		}
	}
}
