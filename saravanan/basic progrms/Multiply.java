package saravanan04;
import java.util.Scanner;
public class Multiply {
public static void main(String arg[]) {
	System.out.println("enter rows and columns");
	Scanner sc=new Scanner(System.in);
	int m=sc.nextInt();
	int n=sc.nextInt();
	int arr[][]=new int[m][n];
	int arr2[][]=new int[m][n];
	int mult[][]=new int[m][n];
	System.out.println("Enter the number for A matrix");
	for (int i=0;i<m;i++) {
		for (int j=0;j<n;j++) {
			arr[i][j]=sc.nextInt();
		}
	}
	System.out.println("Enter the number for B matrix");
	for (int i=0;i<m;i++) {
		for (int j=0;j<n;j++) {
			arr2[i][j]=sc.nextInt();
			
		}
	}
	
	System.out.println("the entered two matrix are:");
	for (int i=0;i<m;i++) {
		for (int j=0;j<n;j++) {

	System.out.print(arr[i][j]+" ");
		}System.out.println();
		}	
	for (int i=0;i<m;i++) {
		for (int j=0;j<n;j++) {

	System.out.print( arr2[i][j]+" ");
	
}
		System.out.println();
		}
	System.out.println("the multiplied matrix of a and b is:");
	
for (int i=0;i<m;i++) {
	for (int j=0;j<n;j++) {
		for (int k=0;k<n;k++) {
			mult[i][j]=arr[i][k]*arr2[k][j];
			
		}
	
		System.out.print(mult[i][j]+" ");
		}
System.out.println();	
}

	

}}
