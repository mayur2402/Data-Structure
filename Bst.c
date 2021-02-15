#include<stdio.h>
#include<stdlib.h>

typedef struct node
{
	int Data;
	struct node *lChild;
	struct node *rChild;
}NODE,*PNODE,**PPNODE;

void Insert(PPNODE root,int value)
{
	PNODE newn = (PNODE)malloc(sizeof(NODE));
	PNODE temp = *root;
	newn->Data = value;
	newn->lChild = NULL;
	newn->rChild = NULL;

	if(root == NULL)
	{
		root = newn;
	}
	else
	{
		while(1)
		{
			if(temp->Data == value)
			{
				printf("\nData is already present\n");
				free(newn);
				break;
			}
			else if(temp->Data > value)
			{
				if(temp->lChild == NULL)
				{
					temp->lChild = newn;
					break;
				}
				temp = temp->lChild;
			}
			else
			{
				if(temp->rChild == NULL)
				{
					temp->rChild = newn;
					break;
				}
				temp = temp->rChild;
			}
		}
	}
}

void Search(PNODE root,int value)
{
	while(root != NULL)
	{
		if(root->Data == value)
		{
			break;
		}
		else if(root->Data > value)
		{
			root = root->lChild;
		}
		else
		{
			root = root->rChild;
		}
	}

	if(root != NULL)
	{
		printf("Data found\n");
	}
	else
	{
		printf("Data not found\n");
	}
}

void Inorder(PNODE root)
{
	if(root != NULL)
	{
		Inorder(root->lChild);
		printf("%d\t",root->Data);
		Inorder(root->rChild);
	}
}

void preorder(PNODE root)
{
	if(root != NULL)
	{
		printf("%d\t",root->Data);
		preorder(root->lChild);
		preorder(root->rChild);
	}
}

void postorder(PNODE root)
{
	if(root != NULL)
	{
		postorder(root->lChild);
		postorder(root->rChild);
		printf("%d\t",root->Data);
	}
}

int main()
{
	PNODE First = NULL;
	int ch = 0,no = 0;

	while(ch != 6)
	{
		printf("\n1.Enter data in tree");
		printf("\n2.Search data in tree");
		printf("\n3.Inorder");
		printf("\n4.Preorder");
		printf("\n5.postorder");
		printf("\n6.Exit");
		printf("\nEnter your choice");
		scanf("%d",&ch);
		switch(ch)
		{
			case 1:
				printf("\nEnter Data to insert\t");
				scanf("%d",&no);
				Insert(&First,no);
			break;

			case 2:
				printf("\nEnter Data to search\t");
				scanf("%d",&no);
				Search(First,no);
				break;

			case 3:
				Inorder(First);
				break;

			case 4:
				preorder(First);
				break;

			case 5:
				postorder(First);
				break;
			case 6:
				exit(0);
		}
	}
}
