package saravanan03;
import java.util.Scanner;
public class condition {
public static void main(String args[]) {
	int marks;
	System.out.println("enter your marks");
	Scanner sc=new Scanner(System.in);
	marks=sc.nextInt();
	if(marks<50) {
		System.out.println("you are fail");
	}
	else if(marks>50&&marks<60) {
		System.out.println("you got D grade");
	}
	else if(marks>60&&marks<70) {
		System.out.println("you got c grade");
	}else if(marks>70&&marks<80) {
		System.out.println("you got b grade");
	}else if(marks>80&&marks<90) {
		System.out.println("you got a grade");
	}else 
		System.out.println("you got O grade");
	
}
}
