/*
    12 45 76 87 98 17 

	jevha left side cha element ha aplya right side chya first element (key) peksha motha asto
	tevha right vala element left valyachya right la thevaych

	45 ha 12 peksha motha aahe mag 12 chya pudh 45 thevaycha ani pudhacha element ghyaycha

	12      45 76 87 98 17 

    12 45      76 87 98 17 

    12 45 76      87 98 17 

    12 45 76 87      98 17

    12 45 76 87 98      17

	jevha left side cha element ha aplya right side chya first element (key) peksha lahan asto
	tevha left side chya element chya pudh sadhyacha element takaycha

	17 ha element 98 peksha lahan aahe mag 98 sadhyachya position chya right la takaycha

	17 < 98 and j >= 0  j = 4
	12 45 76 87 _ 98

	17 ha element 87 peksha lahan aahe mag 87 sadhyachya position chya right la takaycha

    17 < 87 and j >= 0  j = 3
	12 45 76 _ 87 98

	17 ha element 76 peksha lahan aahe mag 76 sadhyachya position chya right la takaycha
    17 < 76 and j >= 0  j = 2
	12 45 _ 76 87 98

	17 ha element 45 peksha lahan aahe mag 45 sadhyachya position chya right la takaycha
    17 < 45 and j >= 0  j = 1
	12 _ 45 76 87 98


	12 < 17 **


	
    //////////////////////////////////////////////

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