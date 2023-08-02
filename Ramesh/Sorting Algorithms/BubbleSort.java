package Sort;

import java.util.*;

public class BubbleSort {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Size of the array : ");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.print("Enter the Elements in the array : ");
		for(int i =0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println("Given Array : ");
		for(int i = 0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
  
            if (swapped == false)
                break;
        }
 
        System.out.println();
        
		System.out.println("Sorted array : ");
		for(i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
         
	}
}
