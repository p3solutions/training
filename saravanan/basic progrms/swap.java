package saravanan03;
import java.util.Scanner;
public class swap {
public static void main(String args[]) {
	System.out.println("enter the numbers");
	Scanner sc=new Scanner(System.in);
	int num1=sc.nextInt();
	int num2=sc.nextInt();
	System.out.println("numbers before swapping");
	System.out.println(num1);
	System.out.println(num2);
	System.out.println("numbers after swapping");
	int temp=num1;
	num1=num2;
	num2=temp;
	int x,y;
	System.out.println(num1);
	System.out.println(num2);
}
}
