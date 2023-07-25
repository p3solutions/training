package IFClause;

import java.util.Scanner;
import java.time.LocalDate;  

public class ToCheckVoteEligiblity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
        System.out.println("Current year : "+currentYear);
        System.out.println("Enter your Birth year : ");
		int n =sc.nextInt();
		if((n+18)<=currentYear)
			System.out.println("Elegible to vote!!");
		else {
			System.out.println("Not elegible to vote. Now,Your Age is "+(currentYear-n)+" year. So try After "+(18-(currentYear-n))+" year" );
		}
	}
}
