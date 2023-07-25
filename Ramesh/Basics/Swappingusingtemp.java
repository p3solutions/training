package IFClause;

import java.util.Scanner;

public class Swappingusingtemp{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the A value : ");
		int a = sc.nextInt();
		System.out.print("Enter the B value : ");
		int b = sc.nextInt();
		int temp;
		temp = a;
		a = b ;
		b = temp;
		System.out.println("After the swapping the values....");
		System.out.println("A value : "+a);
		System.out.println("B value : "+b);
	}
}
