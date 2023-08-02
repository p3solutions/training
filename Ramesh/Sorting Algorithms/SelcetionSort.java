package Sort;

import java.util.*;
public class SelcetionSort {
	public static void sort(int arr[],int n) {
		for(int i=0;i<n-1;i++) {
			int minval = i ;
			
			for(int j= i+1;j<n;j++) {
				if(arr[j]<arr[minval]) {
					minval = j;
				}
			}
				
				int temp = arr[minval];
				arr[minval]=arr[i];
				arr[i] =temp;
		}
		
	System.out.println("Sorted array using Selcetion Sort : ");
	
	for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
			}
		
		
		
}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Size of the array : ");
		int n = sc.nextInt();
		int arr[]=new int[n];
		System.out.print("Enter the Elements in the array : ");
		for(int i=0 ; i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Given Array: ");
		for(int i = 0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}	
		System.out.println();
		
		sort(arr, n);
	}
}
