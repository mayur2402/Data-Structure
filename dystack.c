#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
	int info;
	struct node* next;
}node1;
node1 *top;
void init()
{
	top=NULL;
}
int isempty()
{
	return(top==NULL);
}
void push(int n)
{
	node1 *newnode;
	newnode=(node1 *)malloc(sizeof(node1));
	newnode->info=n;
	newnode->next=top;
	top=newnode;
}
int pop()
{
	int num;
	node1 *temp=top;
	num=top->info;
	top=top->next;
	free(temp);
	return num;
}
int main()
{
	int n,c;
	init();
	do
	{
		printf("\n1.push\n2.pop\n3.exit\n");
		printf("\nEnter your choice\t:");
		scanf("%d",&c);
		switch(c)
		{
			case 1:
			printf("\nEnter the element to be push\t:");
			scanf("%d",&n);
			push(n);
			break;
		
			case 2:
			if(isempty())
			{
				printf("\nStack is empty\n");
			}
			else
			{
				printf("\nPoped element is %d",pop());
			}
			break;
		}
	}while(c!=3);
}
