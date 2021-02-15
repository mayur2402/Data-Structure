/*
    algorithm insertion(arr,n)
    begin
    for i = 1 to n do 
        key = arr[i]
        j = i - 1

        while key < arr[j] and j >= 0
			arr[j + 1] = arr[j]
            j--;

        arr[j+1] = key
    end
*/

#include<stdio.h>
#include<stdlib.h>

void insertion(int *arr,int n){
	int i = 0,j = 0,key = 0;

	for ( i = 0; i < n; i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");	

	for (i = 1;i < n;i++){

		key = arr[i];
		j = i - 1;

		while (key < arr[j] && j >= 0){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;		
	}

	for ( i = 0; i < n; i++){
		printf("%d\t",arr[i]);
	}
	printf("\n");
}

int main(){

    int n = 0,i = 0;
    int *arr = NULL;

	printf("How many elements in array\t");
	scanf("%d",&n);

	arr = (int *)malloc(sizeof(int) * n);

	for(i = 0;i < n;i++){
		printf("\nEnter %d element",i+1);
		scanf("%d",&arr[i]);
	}

	insertion(arr,n);

    return 0;
}
