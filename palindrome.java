package saravanan03;
import java.util.Scanner;
public class palindrome {
public static void  main(String args[]) {
	String original,reverse="";
	System.out.println("enter the string");
	Scanner temp=new Scanner(System.in);
	original=temp.nextLine();
	
	int length=original.length();
	for(int i=length-1;i>=0;i--) {
		reverse=reverse+original.charAt(i);
	}
		if(original.equals(reverse))
			System.out.println("the string is an palindrome");
		else 
			System.out.println("the string is not an palindrome");
}
}
