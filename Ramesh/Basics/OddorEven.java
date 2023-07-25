package IFClause;

import java.util.Scanner;

public class OddorEven {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		double n = sc.nextDouble();
		if(n == 0) {
			System.out.print("Give number is Zero");
		}
		else if(n % 2 == 0) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}
	}
	
}
