package Sort;
import java.lang.*;
import java.util.*;

class Bubble{
	public void display(int[] arr){
		for(int i = 0;i < arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}
	public void bubbleSort(int[] arr){
		for(int i = 0;i < arr.length;i++){
			for(int j = 1;j < (arr.length-i);j++){
				if(arr[j-1] > arr[j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}

class BubbleSort{
	public static void main(String[] args) {
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("How many elements in array");
			int num = sc.nextInt();

			if(num <= 0){
				System.out.println("Size of array should be greater than 0");
				System.exit(-1);
			}

			int[] arr = new int[num];

			for(int i = 0;i < num;i++){
				System.out.println("Enter "+(i+1)+" element");
				arr[i] = sc.nextInt();
			}

			Bubble bobj = new Bubble();
			bobj.display(arr);
			System.out.println("Sorted array");
			bobj.bubbleSort(arr);
			bobj.display(arr);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}