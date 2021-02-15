/*

	arr = 9 8 5 6 7 4 

	num = 6

	0 < 5 is true
	low = 0,high = 5
	mid = 2
	mergesort(arr,mid+1,high)
	merge(arr,low,mid,high)

	0 < 2 is true
	low = 0,high = 2
	mid = 1
	mergesort(arr,mid+1,high)
	merge(arr,low,mid,high)

	0 < 1 is true
	low = 0,high = 1
	mid = 0
	mergesort(arr,mid+1,high)
	merge(arr,low,mid,high)

	low = 3,high = 5
	mid = 4
	mergesort(arr,low,mid)
	mergesort(arr,mid+1,high)

*/
#include<stdio.h>
#include <stdlib.h>

void display(int *arr,int num){

	int i = 0;
	for (i = 0;i < num;i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

void merge(int *arr,int low,int mid,int high){

	int i = 0,j = 0,k = 0;
	i = low;	
	j = mid + 1;
	int *brr = (int *)malloc(sizeof(int)*high);

	while(i <= mid && j <= high){
		if (arr[i] > arr[j])
		{
			brr[k] = arr[j];
			k++;
			j++;
		}
		else{
			brr[k] = arr[i];
			k++;
			i++;
		}
	}

	while(i <= mid){

		brr[k] = arr[i];
		k++;
		i++;
	}

	while(j <= high){

		brr[k] = arr[j];
		k++;
		j++;
	}

	for (i = low,k = 0;i < high;i++,k++){
		arr[i] = brr[k];
	}
}

void mergeSort(int *arr,int low,int high){

	int mid = 0;
	if (low < high)
	{
		mid = (low + high)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
}

int main(){

	int num = 0,i = 0;
	int *arr = NULL;

	printf("How many elements in array\n");
	scanf("%d",&num);

	printf("%d\n",num/2 );

	arr = (int *)malloc(sizeof(int)*num);

	for (i = 0; i < num; i++){
		printf("Enter %d element\n",i+1);
		scanf("%d",&arr[i]);
	}

	printf("Before Sorting\n");
	display(arr,num);

	mergeSort(arr,0,num-1);
	printf("%d\n",i);
	printf("After Sorting\n");
	display(arr,num);

	return 0;
}