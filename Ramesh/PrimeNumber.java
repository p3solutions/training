package IFClause;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean flag = false;
		if(n == 0 || n ==1) {
			System.out.print(n+" is not a Prime Number");
		}
		else {
			for(int i =2;i<=(n/2);i++) {
				if(n%i == 0) {
					flag =true;
				}
			}
		}
		
		if(flag == false) {
			System.out.println(n+" is a Prime Number");
		}
		else {
			System.out.println(n+" is not a Prime Number");
		}
		
	}
}
