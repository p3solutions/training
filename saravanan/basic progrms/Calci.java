package saravanan03;
import java.util.Scanner;

public class Calci {
public static void main(String args[]) {
	double a,b;
	System.out.println("enter the number");
	Scanner sc=new Scanner(System.in);
	a=sc.nextDouble();
	b=sc.nextDouble();
	System.out.println("enter the operator(+,-,*,/)");
	char operator=sc.next().charAt(0);
	double o=0;
	switch(operator){
	case '+':
		o=a+b;
		System.out.println(o);
		break;
	case '-':
		o=a-b;
		System.out.println(o);
		break;
	case '*':
		o=a*b;
		System.out.println(o);
		break;
	case '/':
		o=a/b;
		System.out.println(o);
		break;
		default:
			System.out.println("you entered an invalid operator");
	}
System.out.println("the result of" + a + operator + b + "="+ o);

}
}