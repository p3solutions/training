package IFClause;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int sum=0;
		int digit;
		
		while(n>0) {
			digit = n%10;
			sum +=digit;
			n = n /10;
			
		}
		System.out.println(sum);
	}

}
