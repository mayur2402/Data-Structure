#include<stdio.h>
#include <stdlib.h>

void display(int *arr,int len){

	int i = 0;
	for(i = 0;i < len;i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

void bubble(int *arr,int len){

	int i = 0,j = 0,temp = 0;
	for(i = 0;i < len;i++)
	{
		for(j = 1;j < (len-i);j++)
		{
			if(arr[j-1] > arr[j])
			{
				temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
			}
		}
	}
}

int main()
{
	int n=0,i=0;
	int *arr = NULL;

	printf("\nHow many numbers\t:");
	scanf("%d",&n);

	if(n <= 0){
		printf("Number should be greater than 0\n");
		exit(-1);
	}

	arr = (int *)malloc(sizeof(int)*n);

	if(arr == NULL){
		printf("Unable to allocate memeory\n");
		exit(-1);
	}

	for(i=0;i<n;i++)
	{
		printf("\nEnter %d element",i+1);
		scanf("%d",&arr[i]);
	}
	
	display(arr,n);
	printf("\nAfter sorting\n");
	bubble(arr,n);
	display(arr,n);
	return 0;
}
