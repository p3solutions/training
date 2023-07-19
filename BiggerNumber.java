package IFClause;

import java.util.*;
public class BiggerNumber {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Number 1 value : ");
		int a = sc.nextInt();
		System.out.print("Enter the Number 2 value : ");
		int b = sc.nextInt();
		System.out.print("Enter the Number 3 value : ");
		int c = sc.nextInt();
		if((a>b) && (a>c)) {
				System.out.println("Number 1 is Bigger");
			}
		else if(b>c) {
				System.out.println("Number 2 is Bigger");
			}
		else {
				System.out.println("Number 3 is Bigger");
			}
	}

}
