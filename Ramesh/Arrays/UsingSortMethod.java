package Array;

import java.util.Scanner;
import java.util.Arrays;

public class UsingSortMethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Size of the Array : ");
		int n = sc.nextInt();
		int arr[]= new int[n];
		System.out.println("Enter the elements in the array : ");
		for(int i = 0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Sorted Array using Sort Method : ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
