/*
	pivot = 0
	left = pivot+1
	right = num-1

	joparyant left ha pivot peksha lahan asel aani left ha righ peksha lahan asel 
	toparyant pudhe ja
*/

#include<stdio.h>
#include<stdlib.h>

void display(int *arr,int num){
	int i = 0;
	for (i = 0; i < num; i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}



int main(){

	int i = 0,num = 0;
	int *arr = NULL;

	printf("How many elements in array\n");
	scanf("%d",&num);

	arr = (int *)malloc(sizeof(int)*num);

	for(i = 0;i < num;i++){
		printf("Enter %d element\n",i+1);
		scanf("%d",&arr[i]);
	}

	display(arr,num);
}