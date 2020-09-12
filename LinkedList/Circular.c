#include<stdio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node *next;
};

typedef struct node NODE;
typedef struct node* PNODE;
typedef struct node** PPNODE;

void InsertFirst(PPNODE Head,PPNODE Tail,int no)
{
	PNODE newn = NULL;
	newn = (PNODE)malloc(sizeof(NODE));
	newn->next = NULL;
	newn->data = no;

	if(*Head == NULL || *Tail == NULL)
	{
		*Head = newn;
		*Tail = newn;
	}
	else
	{
		newn->next = *Head;
		*Head = newn;
		(*Tail)->next = newn;
	}
}

void DeleteFirst(PPNODE Head,PPNODE Tail)
{
	if(*Head == NULL || *Tail == NULL)
	{
		return ;
	}
	if(*Head == *Tail)
	{
		free(*Head);
		free(*Tail);
		*Head = NULL;
		*Tail = NULL;
	}
	else
	{
		*Head  = (*Head)->next;
		free((*Tail)->next);
		(*Tail)->next = *Head;
	}
}

void DeleteLast(PPNODE Head,PPNODE Tail)
{
	PNODE temp = *Head;
	if(*Head == NULL || Tail == NULL)
	{
		return ;
	}
	if(*Head == *Tail)
	{
		free(*Head);
		free(*Tail);
		*Head = NULL;
		*Tail = NULL;
	}
	else
	{
		while(temp->next != *Tail)
		{
			temp = temp->next;
		}			
		temp->next = (*Tail)->next;
		free(*Tail);
		*Tail = temp;
	}
}

int Sum(PNODE Head,PNODE Tail)
{
	int sum = 0;
	if(Head == NULL || Tail == NULL)
	{
		exit(0);
	}
	if(Head == Tail)
	{
		sum = Head->data;
	}
	else
	{
		while(Head != Tail)
		{
			sum = sum + Head->data;
			Head = Head->next;
		}
		if(Head == Tail)
		{
			sum = sum + Head->data;
		}
	}
	return sum;
}

int Max(PNODE Head,PNODE Tail)
{
	int max = 0;
	if(Head == NULL || Tail == NULL)
	{
		exit(0);
	}
	if(Head == Tail)
	{
		max = Head->data;
	}
	else
	{
		max = Head->data;
		while(Head != Tail)
		{
			if(max < (Head->data))
			{
				max = Head->data;
			}
			Head = Head->next;
		}
		if(Head == Tail)
		{
			if(max < (Head->data))
			{
				max = Head->data;
			}
		}
	}
	return max;
}

int Min(PNODE Head,PNODE Tail)
{
	int min = 0;
	if(Head == NULL || Tail == NULL)
	{
		exit(0);
	}
	if(Head == Tail)
	{
		min = Head->data;
	}
	else
	{
		min = Head->data;
		while(Head != Tail)
		{
			if(min > (Head->data))
			{
				min = Head->data;
			}
			Head = Head->next;
		}
		if(Head == Tail)
		{
			if(min > (Head->data))
			{
				min = Head->data;
			}
		}
	}
	return min;
}

void Display(PNODE Head,PNODE Tail)
{
	PNODE temp = Head;
	while(Head != Tail)
	{
		printf("{%d}=>",Head->data);
		Head = Head->next;
	}
	if(Head == Tail)
	{
		printf("{%d}=>",Head->data);
	}
	printf("NULL\n");
}

int main()
{
	PNODE First = NULL;
	PNODE Last = NULL;
	int Ret = 0;

	InsertFirst(&First,&Last,101);
	InsertFirst(&First,&Last,501);
	InsertFirst(&First,&Last,301);
	InsertFirst(&First,&Last,201);

	printf("\nList is \t");

	Display(First,Last);

	Ret = Sum(First,Last);

	printf("\nSum is \t%d\n",Ret);

	Ret = Max(First,Last);

	printf("\nMax is \t%d\n",Ret);

	Ret = Min(First,Last);

	printf("\nMin is \t%d\n",Ret);

	printf("\nAfter First element delete\t");

	DeleteFirst(&First,&Last);

	Display(First,Last);

	printf("\nAfter Last element delete\t");

	DeleteLast(&First,&Last);

	Display(First,Last);

	Ret = Sum(First,Last);

	printf("\nSum is \t%d\n",Ret);

	Ret = Max(First,Last);

	printf("\nMax is \t%d\n",Ret);

	Ret = Min(First,Last);

	printf("\nMin is \t%d\n",Ret);

	return 0;
}

