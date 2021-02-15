#include<stdio.h>
#include <stdlib.h>

void display(int *arr,int len){
	int i = 0,key = 0;

	for ( i = 0; i < len; i++){
		if(i == 0){
			key = arr[i];
		}
		else if(key > arr[i]){
			printf("Array should be sorted\n");
			exit(-1);
		}
		else{
			key = arr[i];
		}
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

int binarySearch(int *arr,int len,int find){
	int i = 0,low = 0,mid = 0,high = 0;
	high = len;

	while(low <= high){
		mid = (low+high)/2;

		if(arr[mid] == find){
			return mid;
		}
		else if(arr[mid] < find){
			low = mid+1;
		}
		else if(arr[mid] > find){
			high = mid - 1;
		}
	}

	if(low > high){
		return -1;
	}
}

int main(){
	int num = 0,i = 0,ele = 0,pos = 0;
	int *arr = NULL;

	printf("How many elements in array\n");
	scanf("%d",&num);

	if(num <= 0){
		return -1;
	}

	arr = (int *)malloc(sizeof(int)*num);

	if(arr == NULL){
		return -1;
	}

	for(i = 0; i < num; i++){
		printf("Enter %d element\n",i+1);
		scanf("%d",&arr[i]);
	}

	display(arr,num);

	printf("Enter element to find in array\t");
	scanf("%d",&ele);

	pos = binarySearch(arr,num,ele);

	if(pos == -1){
		printf("Element is not present in array\n");
	}
	else{
		printf("Element present at position %d\n",pos+1);
	}

	return 0;
}