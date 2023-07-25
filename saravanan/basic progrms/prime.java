package saravanan03;
import java.util.Scanner;
public class prime {
	public static void main(String args[]) {
		int n;
		boolean result=false;
		System.out.println("enter the integer");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(int i=3;i<=n;++i) {
			System.out.println(i);
			if(n%i==0) {
				result=true;
				break;
			}
		}
		if(!result) {
			System.out.println("it is an prime number");
			
		}
		else
			System.out.println("it is not an prime number");
	}

}
