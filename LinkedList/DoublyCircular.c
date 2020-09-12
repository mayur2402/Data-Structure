#include<stdio.h>
#include<stdlib.h>

struct node
{
	int Data;
	struct node *Next;
	struct node *Prev;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

int Count(PNODE Head,PNODE Tail)
{
	int count = 0;
	if(Head == NULL || Tail == NULL)
	{
		return 0;
	}
	do
	{
		count++;
		Head = Head->Next;
	}while(Head != Tail->Next);

	return count;
}

void InsertFirst(PPNODE Head,PPNODE Tail,int No)
{
	PNODE newn = NULL;
	newn = (PNODE)malloc(sizeof(NODE));
	newn->Data = No;
	newn->Next = NULL;
	newn->Prev = NULL;

	if(*Head == NULL && *Tail == NULL)
	{
		*Head = newn;
		*Tail = newn;
		(*Head)->Prev = *Head;
		(*Head)->Next = *Head;
	}
	else
	{
		(*Head)->Prev = newn;
		newn->Next = *Head;
		*Head = newn;
		(*Tail)->Next = newn;
		newn->Prev = *Tail;	
	}
}

void InsertLast(PPNODE Head,PPNODE Tail,int No)
{
	PNODE newn = NULL,temp = NULL;
	newn = (PNODE)malloc(sizeof(NODE));
	newn->Data = No;
	newn->Next = NULL;
	newn->Prev = NULL;
	temp = *Head;
	if(*Head == NULL && *Tail == NULL)
	{
		*Head = newn;
		*Tail = newn;
		(*Head)->Prev = *Head;
		(*Head)->Next = *Head;
	}
	else
	{
		while(temp != *Tail)
		{
			temp = temp->Next;
		}
		newn->Next = temp->Next;
		temp->Next = newn;
		newn->Prev = temp;
		newn->Next->Prev = newn;
		*Tail = newn;
	}
}
void InsertAtPos(PPNODE Head,PPNODE Tail,int pos,int Num)
{
	int size = Count(*Head,*Tail);
	PNODE newn = NULL,temp = NULL;
	int i = 0;
	if(pos < 1 || pos > (size+1))
	{
		return ;
	}
	if(pos == 1)
	{
		InsertFirst(Head,Tail,Num);
	}
	else if(pos == size)
	{
		InsertLast(Head,Tail,Num);
	}
	else
	{
		temp = *Head;
		for(i = 1;i < (pos-1);i++)
		{
			temp = temp->Next;
		}
		newn = (PNODE)malloc(sizeof(NODE));
		newn->Data = Num;

		newn->Next = temp->Next;
		newn->Prev = temp;
		temp->Next = newn;
		newn->Next->Prev = newn;
	}
}
void Create(PPNODE Head,PPNODE Tail,int iNum)
{
	int i = 0,no = 0;
	PNODE newn = NULL;
	PNODE temp = NULL;

	for(i = 1;i <= iNum;i++)
	{
		printf("Enter %dst Element\t",i);
		scanf("%d",&no);

		if(*Head == NULL && *Tail == NULL)
		{
			InsertFirst(Head,Tail,no);
			temp = *Head;
		}
		else
		{
			newn = (PNODE)malloc(sizeof(NODE));
			temp->Next = newn;
			newn->Next = *Head;
			newn->Prev = temp;
			newn->Data = no;
			(*Head)->Prev = newn;
			*Tail = newn;
			temp = newn;
		}
	}
}

void DeleteFirst(PPNODE Head,PPNODE Tail)
{
	if(*Head == NULL && *Tail == NULL)
	{
		exit(0);
	}
	else
	{
		(*Tail)->Next = (*Head)->Next;
		(*Head)->Next->Prev = *Tail;
		free(*Head);
		*Head = (*Head)->Next;
	}
}

void DeleteLast(PPNODE Head,PPNODE Tail)
{
	PNODE temp = *Head;
	if(*Head == NULL && *Tail == NULL)
	{
		exit(0);
	}
	else if(*Head == *Tail)
	{
		free(*Head);
		*Head = NULL;
		*Tail = NULL;
	}
	else
	{
		while(temp->Next != *Tail)
		{
			temp = temp->Next;
		}

		temp->Next = (*Tail)->Next;
		free(*Tail);
		(*Tail) = temp;
		temp->Next->Prev = temp;
		temp = temp->Next;
	}
}

void DeleteAtPos(PPNODE Head,PPNODE Tail,int pos)
{
	PNODE temp = NULL;
	int i = 0;

	int size = Count(*Head,*Tail);

	if(pos < 1 || pos > size || *Head == NULL && *Tail == NULL)
	{
		return ;
	}

	if(pos == 1)
	{
		DeleteFirst(Head,Tail);
	}
	else if(size == pos)
	{
		DeleteLast(Head,Tail);
	}
	else
	{
		for(i = 1;i < (pos-1);i++)
		{
			*Head = (*Head)->Next;
		}
		(*Head)->Next->Next->Prev = *Head;
		temp = (*Head)->Next->Next;
		free((*Head)->Next);
		(*Head)->Next = temp;		 
	}
}

int Search(PNODE Head,PNODE Tail,int iNo)
{
	int count = 0,pos = -1;
	if(Head == NULL && Tail == NULL)
	{
		return -1;
	}
	do
	{
		count++;
		if((Head->Data) == iNo)
		{
			pos = count;
			break;
		}
		Head = Head->Next;
	}while(Head != Tail->Next);
	return pos;
}

void Display(PNODE Head,PNODE Tail)
{
	do
	{
		printf("|%d|->",Head->Data);
		Head = Head->Next;
	}while(Head != Tail->Next);
	printf("NULL\n");
}

int main()
{
	PNODE First = NULL;
	PNODE Last = NULL;
	int iNum = 0,pos = 0,ch = 0;

	printf("\nHow many elements in linked list\t:");
	scanf("%d",&iNum);

	Create(&First,&Last,iNum);
	printf("\nLinked list is\t");
	Display(First,Last);

	do
	{
		printf("\n1.Display");
		printf("\n2.Count");
		printf("\n3.Insert At First Position");
		printf("\n4.insert At Last Position");
		printf("\n5.Insert At Specific Position");
		printf("\n6.Search Number");
		printf("\n7.Delete At First Position");
		printf("\n8.Delete At Last Position");
		printf("\n9.Delete At Specific Position");
		printf("\n10.Exit");
		printf("\nEnter your choice\t:");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				printf("\nLinked list is \t:");
				Display(First,Last);
				break;

			case 2:
				iNum = Count(First,Last);
				printf("\nTotal number of elements present in list are \t:%d",iNum);
				break;

			case 3:
				printf("\nEnter Data to store in first position\t:");
				scanf("%d",&iNum);
				InsertFirst(&First,&Last,iNum);
				printf("\nAfter inserting at first location\t:");
				Display(First,Last);
			break;

			case 4:
				printf("\nEnter Data to store in last position\t:");
				scanf("%d",&iNum);
				InsertLast(&First,&Last,iNum);
				printf("\nAfter inserting at Last location\t:");
				Display(First,Last);
			break;

			case 5:
				printf("\nEnter position where you want to enter element\t:");
				scanf("%d",&pos);
				printf("\nEnter value to store in that location\t:");
				scanf("%d",&iNum);
				InsertAtPos(&First,&Last,pos,iNum);
				printf("\nLinked list after inserting data at %d position\t:",pos);
				Display(First,Last);
			break;

			case 6:
				printf("\nEnter number to search in linked list\t:");
				scanf("%d",&iNum);
				pos = Search(First,Last,iNum);
				if(pos != -1)
				{
					printf("\n%d is found in list at position %d",iNum,pos);
				}
				else
				{
					printf("\nNumber is not found in list or list is empty");
				}
			break;

			case 7:
				printf("\nAfter Deleting at First location\t:");
				DeleteFirst(&First,&Last);
				Display(First,Last);
			break;

			case 8:
				printf("\nAfter Deleting at Last location\t:");
				DeleteLast(&First,&Last);
				Display(First,Last);
			break;

			case 9:
				printf("\nEnter position to delete\t:");
				scanf("%d",&pos);
				DeleteAtPos(&First,&Last,pos);
				printf("\nAfter Deleting %d location \t:",pos);
				Display(First,Last);
			break;

			default :
				break;
		}

	}while(ch != 10);

	return 0;
}

