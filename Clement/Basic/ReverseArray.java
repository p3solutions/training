package com.array;

import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		int a = d.nextInt();
                System.out.print("Enter the size of array: ");
		int arr[] = new int[a];

		for(int i = 0;i<a;i++) {
                        System.out.print("Enter the "+i+1+" element of array: ");
			arr[i] = d.nextInt();
		}
		for(int i=a-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}
}
