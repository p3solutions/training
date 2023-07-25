package IFClause;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the which table you want ?? : ");
		int n = sc.nextInt();
		for(int i = 1 ; i<=20;i++) {
			System.out.println(i+" * "+n+" = "+(i*n));
		}
	}
}
