#include<stdio.h>
#include<stdlib.h>

struct node
{
	int iNo;
	struct node* next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

int Count(PNODE Head)
{
	int count = 0;
	while(Head != NULL)
	{
		count++;
		Head = Head->next;
	}

	return count;
}

void InsertFirst(PPNODE Head,int No)
{
	PNODE newn = NULL;
	newn = (PNODE)malloc(sizeof(NODE));
	newn->iNo = No;
	newn->next = NULL;

	if(*Head == NULL)
	{
		*Head = newn;
	}
	else
	{
		newn->next = *Head;
		*Head = newn;
	}
}

void InsertLast(PPNODE Head,int No)
{
	PNODE newn = NULL;
	PNODE temp = NULL;
	temp = *Head;

	newn = (PNODE)malloc(sizeof(NODE));
	newn->iNo = No;
	newn->next = NULL;

	if(*Head == NULL)
	{
		*Head = newn;
	}
	else
	{
		while(temp->next != NULL)
		{
			temp = temp->next;
		}
		temp->next = newn;
	}
}
void InsertAtPos(PPNODE Head,int pos,int Num)
{
	int size = Count(*Head);
	PNODE temp = NULL;
	temp = *Head;

	int i = 0;
	if(pos < 1 || pos > (size+1))
	{
		return ;
	}
	if(pos == 1)
	{
		InsertFirst(Head,Num);
	}
	else if(pos == size)
	{
		InsertLast(Head,Num);
	}
	else
	{
		for(i = 1;i < (pos-1);i++)
		{
			temp = temp->next;
		}
		PNODE newn = NULL;
		newn = (PNODE)malloc(sizeof(NODE));
		newn->iNo = Num;
		newn->next = temp->next;
		temp->next = newn;		
	}
}
void Create(PPNODE Head,int iNum)
{
	int i = 0,no = 0;
	PNODE newn = NULL,temp = NULL;

	for(i = 1;i <= iNum;i++)
	{
		printf("Enter %dst Element\t",i);
		scanf("%d",&no);

		if(*Head == NULL)
		{
			InsertFirst(Head,no);
			temp = *Head;
		}
		else
		{
			newn = (PNODE)malloc(sizeof(NODE));
			temp->next = newn;
			newn->iNo = no;
			newn->next = NULL;
			temp = newn;
		}
	}
}

void DeleteFirst(PPNODE Head)
{
	PNODE temp = NULL;
	if(*Head == NULL)
	{
		exit(0);
	}
	else
	{
		temp = *Head;
		*Head = (*Head)->next;
		free(temp);
	}
}

void DeleteLast(PPNODE Head)
{
	PNODE temp = *Head;
	if(*Head == NULL)
	{
		exit(0);
	}
	else if((*Head)->next == NULL)
	{
		free(*Head);
		*Head = NULL;
	}
	else
	{
		temp = (*Head);
		while(temp->next->next != NULL)
		{
			temp = temp->next;
		}
		free(temp->next);
		temp->next = NULL;
	}
}

void DeleteAtPos(PPNODE Head,int pos)
{
	PNODE temp = *Head;
	PNODE temp1 = NULL;
	int i = 0;

	int size = Count(*Head);

	if(pos < 1 || pos > size || *Head == NULL)
	{
		return ;
	}

	if(pos == 1)
	{
		DeleteFirst(Head);
	}
	else if(size == pos)
	{
		DeleteLast(Head);
	}
	else
	{
		for(i = 1;i < (pos-1);i++)
		{
			temp = temp->next;
		}
		temp1 = temp->next;
		temp->next = temp1->next;
		free(temp1);
	}
}

int Search(PNODE Head,int iNo)
{
	int count = 0,pos = -1;
	if(Head == NULL)
	{
		return -1;
	}
	while(Head != NULL)
	{
		count++;
		if((Head->iNo) == iNo)
		{
			pos = count;
			break;
		}
		Head = Head->next;
	}
	return pos;
}

void Display(PNODE Head)
{
	while(Head != NULL)
	{
		printf("|%d|->",Head->iNo);
		Head = Head->next;
	}
	printf("NULL\n");
}

int main()
{
	PNODE First = NULL;
	int iNum = 0,pos = 0,ch = 0;

	printf("\nSingly Linked List\n");

	printf("\nHow many elements in linked list\t:");
	scanf("%d",&iNum);

	Create(&First,iNum);
	printf("\nLinked list is\t");
	Display(First);

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
				Display(First);
				break;

			case 2:
				iNum = Count(First);
				printf("\nTotal number of elements present in list are \t:%d",iNum);
				break;

			case 3:
				printf("\nEnter Data to store in first position\t:");
				scanf("%d",&iNum);
				InsertFirst(&First,iNum);
				printf("\nAfter inserting at first location\t:");
				Display(First);
			break;

			case 4:
				printf("\nEnter Data to store in last position\t:");
				scanf("%d",&iNum);
				InsertLast(&First,iNum);
				printf("\nAfter inserting at Last location\t:");
				Display(First);
			break;

			case 5:
				printf("\nEnter position where you want to enter element\t:");
				scanf("%d",&pos);
				printf("\nEnter value to store in that location\t:");
				scanf("%d",&iNum);
				InsertAtPos(&First,pos,iNum);
				printf("\nLinked list after inserting data at %d position\t:",pos);
				Display(First);
			break;

			case 6:
				printf("\nEnter number to search in linked list\t:");
				scanf("%d",&iNum);
				pos = Search(First,iNum);
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
				DeleteFirst(&First);
				Display(First);
			break;

			case 8:
				printf("\nAfter Deleting at Last location\t:");
				DeleteLast(&First);
				Display(First);
			break;

			case 9:
				printf("\nEnter position to delete\t:");
				scanf("%d",&pos);
				DeleteAtPos(&First,pos);
				printf("\nAfter Deleting %d location \t:",pos);
				Display(First);
			break;

			default :
				break;
		}

	}while(ch != 10);

	return 0;
}

