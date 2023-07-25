package saravanan04;
import java.util.Scanner;
public class Strong {
	public static void main(String args[])
	{
	int num;
		System.out.println("enter the number to verify");
	Scanner sc=new Scanner(System.in);
	num=sc.nextInt();
	int copy=num;
	int sum=0;
	int fact=1;
	while(num>0) {
		int last=num%10;
	
	for (int i=last;i>=2;i--) {
		fact=fact*i;
		System.out.println(fact);
	}

	sum+=fact;
	fact=1;
	num=num/10;
	
	}
	System.out.println(sum);
	if(sum==copy) {
		System.out.println("it is an strong number");
	}
	else
		System.out.println("it is not an strong number");
	}
	}
 