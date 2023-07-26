package com.array;

import java.util.Scanner;

public class MatrixAdd {

	public class MatrixAddition {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter the size of Matrix : ");
			int n = sc.nextInt();
			int arr1[][]=new int[n][n];
			int arr2[][] = new int[n][n];
			int add[][] = new int[n][n];
			
			System.out.print("Enter the 1st Matrix values : ");
			for(int i = 0 ; i<n;i++) {
				for(int j = 0;j<n;j++) {
					arr1[i][j]=sc.nextInt();
				}
			}
			
			System.out.print("Enter the 2nd Matrix values : ");
			for(int i = 0 ; i<n;i++) {
				for(int j = 0;j<n;j++) {
					arr2[i][j]=sc.nextInt();
				}
			}
			
			System.out.println("The 1st Matrix values : ");
			for(int i = 0 ; i<n;i++) {
				for(int j = 0;j<n;j++) {
					System.out.print(arr1[i][j]+" ");
				}
				System.out.println();
			}
			
			System.out.println("The 2nd Matrix values : ");
			for(int i = 0 ; i<n;i++) {
				for(int j = 0;j<n;j++) {
					System.out.print(arr2[i][j]+" ");
				}
				System.out.println();
			}
			
			for(int i = 0;i<n;i++) {
				for(int j=0;j<n;j++) {
					add[i][j]=arr1[i][j]+arr2[i][j];
				}
			}
			
			System.out.println("The Addition of Two Matrix is : ");
			
			for(int i = 0;i<n;i++) {
				for(int j= 0;j<n;j++) {
					System.out.print(add[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
