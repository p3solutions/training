package saravanan04;
import java.util.Scanner;
public class aray {
	public static void main(String args[]) {
		
		int arr[]=new int [10];
		System.out.println("enter the numbers");
		Scanner sc=new Scanner(System.in);
		for (int i=0;i<10;i++) {
			arr[i]=sc.nextInt();
		}
		for(int a: arr ) {
			
		
		System.out.print(a);
		}

}  
}