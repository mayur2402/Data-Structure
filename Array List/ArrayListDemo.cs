using System;
using System.Collections;
using System.Collections.Generic;
class ArrayListDemo
{
	public static void Main(string[] args)
	{
		try
		{
			ArrayList AL = new ArrayList();

			Console.WriteLine("How many elements");
			int iNo = int.Parse(Console.ReadLine());

			for(int i = 0;i < iNo;i++)
			{
				Console.WriteLine("Enter {0} number",i+1);
				int iNum = int.Parse(Console.ReadLine());
				AL.Add(iNum);
			}

			foreach(int i in AL)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			Console.WriteLine("Enter Element to remove");
			iNo = int.Parse(Console.ReadLine());

			AL.Remove(iNo);

			foreach(int i in AL)
			{
				Console.Write(i+"\t");
			}
			Console.WriteLine();

			Console.WriteLine("Enter number whose first index you want");
			iNo = int.Parse(Console.ReadLine());

			int Pos = AL.IndexOf(iNo);

			Console.WriteLine(Pos);

			Console.WriteLine("Enter Element whose last index you want");
			iNo = int.Parse(Console.ReadLine());

			Pos = AL.LastIndexOf(iNo);

			Console.WriteLine(Pos);
			
		}
		catch(Exception e)
		{
			Console.WriteLine(e);
		}
	}
}
