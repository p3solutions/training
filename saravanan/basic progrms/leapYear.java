package saravanan03;
import java.util.*;
public class leapYear {
	public static void main(String args[]) {
		int year;
		boolean leap=false;
		System.out.println("enter the year");
		Scanner sc =new Scanner(System.in);
		year=sc.nextInt();
		if(year%4==0) {
		
		if (year%400==0) {

		if(year%100==0) 
			leap=true;
		
		
			}
	 
			
		
		}
		if(!leap) {System.out.println("it is an leap year"); 
		}
		
		else
			System.out.print(year + "is not an leap year");
		
		
			
		}}


