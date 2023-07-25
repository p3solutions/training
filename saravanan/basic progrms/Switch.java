package saravanan03;
import java.util.Scanner;
public class Switch {
	public static void main(String args[]) {
		String name;
		System.out.println("enter the name to check for vowels");
	Scanner sc=new Scanner(System.in);
	name=sc.nextLine();
	int length=name.length();
	
	for (int i=0;i<=length;i++) 
	{
	
	char store=name.charAt(i);
	switch(store) {
	case 'a':
	case 'e':
	case 'i':
	case 'o':
	case 'u':i=1;
	System.out.println(store);
	}
			
}
	}
	}