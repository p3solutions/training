package IFClause;

import java.util.*;

public class SwappingwithoutusingTemp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the A value : ");
		int a = sc.nextInt();
		System.out.print("Enter the B value : ");
		int b = sc.nextInt();
		
		System.out.println("After the swapping the Values....");
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("A value : "+a);
		System.out.println("B value : "+b);
	}
}
