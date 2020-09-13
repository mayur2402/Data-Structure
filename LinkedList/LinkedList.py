class node:
	def __init__(self,Data):
		self.Data = Data
		self.Next = None

class LinkedList:
	def __init__(self):
		self.Head = None
		self.temp = None

	def Display(self):
		self.temp = self.Head
		while(self.temp != None):
			print(self.temp.Data,endl = " ")
			self.temp = self.temp.Next
		print()

	def Create(self,no):
		if self.Head == None:
			self.Head = node(no)
		else:
			if self.Head.Next == None:
				self.temp = self.Head
			self.temp.Next = node(no)
			self.temp = self.temp.Next

	def InsertFirst(self,no):
		if self.Head == None:
			self.Head = node(no)
		else:
			temp = node(no)
			temp.Next = self.Head
			self.Head = temp

	def InsertLast(self,no):
		self.temp = self.Head
		if self.Head == None:
			self.Head = node(no)
		else:
			while self.temp.Next != None:
				self.temp = self.temp.Next
			self.temp.Next = node(no)

	def Count(self):
		count = 0
		self.temp = self.Head
		while self.temp != None:
			self.temp = self.temp.Next
			count += 1
		return count

	def InsertAtPos(self,pos,no):
		size = List.Count()
		if size == 1:
			InsertFirst(no)
		elif size == pos:
			InsertLast(no)
		else:
			self.temp = self.Head
			for i in range(pos-2):
				print(self.temp)
				self.temp = self.temp.Next
			Address = node(no)
			Address.Next = self.temp.Next
			self.temp.Next = Address

	def DeleteFirst(self):
		if self.Head == None:
			return
		elif self.Head.Next == None:
			del(self.Head)
			self.Head = None
		else:
			self.temp = self.Head
			del(self.Head)
			self.Head = self.temp.Next

	def DeleteLast(self):
		if self.Head == None:
			return
		elif self.Head.Next == None:
			del(self.Head)
			self.Head = None
		else:
			self.temp = self.Head
			while self.temp.Next.Next != None:
				self.temp = self.temp.Next
			del(self.temp.Next)
			self.temp.Next = None

	def DeleteAtPos(self,pos):
		if self.Head == None:
			return
		size = List.Count()
		if size == pos-1:
			DeleteFirst()
		elif size == pos-1:
			DeleteLast()
		else:
			self.temp = self.Head
			for i in range(pos-2):
				self.temp = self.temp.Next
			Address = self.temp.Next
			del(self.temp.Next)
			self.temp.Next = Address.Next

	def Search(self,Num):
		pos = -1
		count = 0
		if self.Head == None:
			return
		else:
			self.temp = self.Head
			while(self.temp != None):
				count += 1
				if self.temp.Data == Num:
					pos = count
					break
				self.temp = self.temp.Next
			return pos

if __name__ == "__main__":
	List = LinkedList()
	ch = 0
	while(ch != 11):
		print()
		print("1.Create")
		print("2.Display")
		print("3.Count")
		print("4.InsertFirst")
		print("5.InsertLast")
		print("6.InsertAtpos")
		print("7.DeleteFirst")
		print("8.DeleteLast")
		print("9.DeleteAtPos")
		print("10.Search")
		print("11.Exit")
		print("Enter your choice")
		print()
		ch = int(input())

		if(ch == 1):
			print("How Many numbers in list")
			num = int(input())

			for i in range(num):
				n = int(input("Enter %d number" %(i+1)))
				List.Create(n)
		elif(ch == 2):
			List.Display()

		elif(ch == 3):
			print("Elements in list %d" %List.Count())

		elif(ch == 4):
			n = int(input("Enter number to insert at first position"))
			List.InsertFirst(n)

		elif(ch == 5):
			n = int(input("Enter number to insert at last position"))
			List.InsertLast(n)

		elif(ch == 6):
			pos = int(input("Enter position"))
			n = int(input("Enter number to insert at %d position" %pos))
			List.InsertAtPos(pos,n)

		elif(ch == 7):
			List.DeleteFirst()

		elif(ch == 8):
			List.DeleteLast()

		elif(ch == 9):
			pos = int(input("Enter position"))
			List.DeleteAtPos(pos)

		elif(ch == 10):
			n = int(input("Enter number to search"))
			pos = List.Search(n)
			if pos == -1:
				print("Not found")
			else:
				print("Found")
		else:
			break;

