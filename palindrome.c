#include<stdio.h>
#define maxsize 100
typedef struct
{
	int data[maxsize];
	int top;
}stack;
void init(stack *s)
{
	s->top=-1;
}
int isempty(stack *s)
{
	return(s->top==-1);
}
int isfull(stack *s)
{
	return(s->top==maxsize-1);
}
void push(stack *s,int n)
{
	s->data[++s->top]=n;
}
int pop(stack *s)
{
	return(s->data[s->top--]);
}
int peek(stack *s)
{
	return(s->data[s->top]);
}
int palindrome(stack s,char str[20])
{
	char ch;
	int i;
	for(i=0;str[i]!='\0';i++)
	{
		push(&s,str[i]);
	}
	i=0;
	while(!isempty(&s))
	{
		ch=pop(&s);
		if(str[i]!=ch)
		{
			printf("Not palindrome\n");
			return 0;
		}
		i++;
	}
	printf("Given string is palindrome");
	return 0;
}	
int main()
{
	char str[20];
	stack a1;
	printf("\nEnbter ythe stirirj");
	scanf("%s",str);
	palindrome(a1,str);
}
