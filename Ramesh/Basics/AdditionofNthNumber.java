package IFClause;

import java.util.Scanner;
public class AdditionofNthNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Size to add the values : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum = 0;
		for(int i =0;i<n;i++) {
			int temp=i+1;
			System.out.println("Enter the "+temp+" value : ");
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) { 
				sum += arr[i];
			}
		System.out.println("The sum of the given N values is "+ sum);	
	}	
}
