package saravanan03;
import java.util.Scanner;
public class factorial {
	public static void main(String args[]) {
		int n,o,p=1;
		System.out.println("enter the number");
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		for(o=1;o<=n;o++) {
			p=p*o;
		}
		System.out.println(p);
		
	}

}
