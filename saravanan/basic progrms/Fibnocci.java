package saravanan03;
import java.util.Scanner;
public class Fibnocci {
	public static void main(String args) {
		int firstTerm=0,secondTerm=1,nextTerm;
		System.out.println("enter the next term");
	Scanner sc=new Scanner(System.in);
	nextTerm=sc.nextInt();
	while ( firstTerm<=nextTerm) {
		System.out.println(firstTerm+",");
		
		nextTerm=firstTerm+secondTerm;
		firstTerm=secondTerm;
		secondTerm=nextTerm;
		
	}
	}

}
