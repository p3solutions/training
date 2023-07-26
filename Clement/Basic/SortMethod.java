package com.array;

import java.util.Scanner;
import java.util.Arrays;

public class SortMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Size of the Array : ");
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i = 0;i<n;i++) {
                        System.out.println("Enter the "+i+1+" elements in the array : ");
			arr[i] = sc.nextInt();
		}
		
                Arrays.sort(arr);
		System.out.println("Sorted Array : ");
		
                for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
