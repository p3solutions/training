package IFClause;

import java.util.Scanner;

public class FactorialofNnumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number for factorial: ");
		int n = sc.nextInt();
		int i=1, fact =1;
		while(i<=n) {
			fact *= i;
			i++;
		}
		System.out.println("The fact of "+n+ " is "+fact);
		
	}
}
