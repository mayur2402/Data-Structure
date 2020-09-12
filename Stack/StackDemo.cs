using System;
using System.Collections;
using System.Collections.Generic;

class StackDemo
{
	public static void Main(string[] args)
	{
		try
		{
			Stack<int> stack = new Stack<int>();

			Console.WriteLine("How many elements in stack");
			int iNo = int.Parse(Console.ReadLine());

			for(int i = 0;i < iNo;i++)
			{
				Console.WriteLine("Enter {0} element",(i+1));
				int iN = int.Parse(Console.ReadLine());

				stack.Push(iN);
			}

			int size = stack.Count;

			Console.WriteLine("Total number of elements in stack are "+size);

			Console.Write("Stack elements are \t");
			foreach(int i in stack)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			Console.WriteLine("Top most element in stack is "+stack.Peek());

			Console.WriteLine("pop element is "+stack.Pop());

			size = stack.Count;

			Console.WriteLine("Total number of elements in stack are "+size);

			Console.Write("Stack elements are \t");
			foreach(int i in stack)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();
		}
		catch(Exception e)
		{
			Console.WriteLine(e);
		}
	}
}
