package saravanan04;
import java.util.Scanner;
public class matrix {
	public static void main(String args[]) {
		System.out.println("enter the number");
		Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
		int arr[][]=new int[n][n];
		int arr1[][]=new int[n][n];
		int add[][]=new int[n][n];
		System.out.println("enter the input for A");
	
		for(int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
				
			}
		}
		
		System.out.println("enter the input for A");
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				arr1[i][j]=sc.nextInt();
			}
		}
		System.out.println(" the input  value for A matrix");
	for (int i=0;i<n;i++) {
		for (int j=0;j<n;j++) {
			System.out.println(arr[i][j]);
					
		}
	}
	System.out.println("the input  value for B matrix");
	for (int i=0;i<n;i++) {
		for (int j=0;j<n;j++) {
			System.out.println(arr1[i][j]);
			
		}
	}
	
	System.out.println(" the matrix addition is");
	for (int i=0;i<n;i++) {
		for(int j=0;j<n;j++) {
			add[i][j]=0;
			add[i][j]=arr[i][j]*arr1[i][j];
		}
	}
	
	for (int i=0;i<n;i++) {
		for (int j=0;j<n;j++) {
			System.out.println(add[i][j]);	
		}

	}

	}

}
