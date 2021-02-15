/*

	selection(arr,num)
	begin
		Set MIN to location 0
		Search the minimum element in the list
		Swap with value at location	MIN
		Increment MIN to point to next element
		Repeat until list is sorted
	end

	10 20 5 50 15 2							i = 0				min = i,j = i+1

	arr[min] > arr[j]	arr[0] > arr[1]		10 > 20 	
	j++		min = 0,j = 2
	arr[min] > arr[j]	arr[0] > arr[2]		10 > 5		min=j	min = 2,j = 3

	arr[min] > arr[j]	arr[2] > arr[3]		5 > 50		
	j++		min = 2,j = 4
	arr[min] > arr[j]	arr[2] > arr[4]		5 > 15		
	j++		min = 2,j = 5
	arr[min] > arr[j]	arr[2] > arr[5]		5 > 2		min=j	min = 5,j = 6

	j < len		6 < 5
	arr[i] = arr[min]
	arr[min] = arr[i]
*/
#include<stdio.h>
#include<stdlib.h>

void display(int *arr,int len){
	int i = 0;
	for(i = 0;i < len;i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

void selectionSort(int *arr,int len){
	int i = 0,j = 0,min = 0,temp = 0;

	for(i = 0;i < len;i++){
		min = i;
		j = i+1;

		while(j < len){
			if(arr[min] > arr[j]){
				min = j;
			}
			j++;
		}
		temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}
}

int main(){

	int i = 0,num = 0;
	int *arr = NULL;

	printf("How many elements in array\t");
	scanf("%d",&num);

	if(num <= 0){
		printf("Size of array should be greater than 0\n");
		exit(-1);
	}

	arr = (int *)malloc(sizeof(int) *num);

	for(i = 0;i < num;i++){
		printf("Enter %d element\t",i+1);
		scanf("%d",&arr[i]);
	}

	display(arr,num);
	selectionSort(arr,num);
	display(arr,num);

	return 0;
}