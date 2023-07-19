package saravanan03;
import java.util.Scanner;

public class data {
	public static void main(String[] args) {
		int a,b;
		System.out.println("enter the numbers");
		Scanner sc=new Scanner(System.in);
		 a=sc.nextInt();
		 b=sc.nextInt();
		 int sum = 0;
		 sum = a+b;
		if (sum%2==0) {
			System.out.println(sum + " it is even number");
		 
			
		}
		else {
			System.out.println("it is not an even number");
		}
			}
		
	}


