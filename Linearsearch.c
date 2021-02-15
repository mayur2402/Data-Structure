#include<stdio.h>
int main()
{
	int num[20],i=0,n=0,key=0,found=0;
	printf("\nHow many numbers\t:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\nEnter %d element",i+1);
		scanf("%d",&num[i]);
	}
	printf("\nEnter key you want to search\t:");
	scanf("%d",&key);
	for(i=0;i<n;i++)
	{
		if(num[i]==key)
		{
			printf("\n%d found at position %d\n",key,i+1);
			found=1;
		}
	}
	if(found==0)
	{
		printf("\n%d not found\n",key);
	}
	return 0;
}
