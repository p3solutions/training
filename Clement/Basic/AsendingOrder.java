package com.array;

import java.util.Scanner;

public class AsendingOrder {
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		System.out.print("Enter the Size of the Array : ");
		int n = d.nextInt();
		int arr[] = new int[n];

		for(int i=0 ;i<n; i++) {
			System.out.println("Enter the "+i+" element of the array : ");
			arr[i] = sc.nextInt();
		}

		for(int i=0;i<n;i++) {
			for(int j =i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("Array in Ascending Order : ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		
	}
}
