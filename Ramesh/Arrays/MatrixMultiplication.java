package Array;

import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the size of the Matrix : ");
		int n = sc.nextInt();
		int mat1[][] =new int[n][n]; 
		int mat2[][]= new int[n][n];
		int mul[][]=new int[n][n];
		System.out.print("Enter the Matrix A values : ");
		for(int i= 0 ;i<n;i++) {
			for(int j = 0;j<n;j++) {
				mat1[i][j]=sc.nextInt();
			}
		}
		System.out.print("Enter the Matrix B Values : ");
		for(int i = 0;i<n;i++) {
			for(int j=0;j<n;j++) {
				mat2[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("The Matrix A values : ");
		for(int i = 0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				System.out.print(mat1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("The Matrix B values : ");
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				System.out.print(mat2[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("The Multiplication of the Matrix  : ");
		for(int i = 0;i<n;i++) {
			for(int j= 0;j<n;j++) {
				mul[i][j]=0;
				for(int k = 0;k<n;k++) {
					mul[i][j]+=mat1[i][k]*mat2[k][j];
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(mul[i][j]+" ");
			}
			System.out.println();
		}
	}
}
