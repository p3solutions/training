package saravanan03;
import java.util.Scanner; 
public class ternary {
	public static void main(String args[]) {
		int a,b,max;
		System.out.println("enter the numbers");
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		max=(a>b)?a:b;
		System.out.println(max);
		
	}

}
