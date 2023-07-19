package IFClause;

import java.util.Scanner;

public class FibanocciSerious {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n=0,m=1;
			int sum=0;
			int range=5;
			int range1 =range -2;
			System.out.print("0 1 ");
			for(int i=1;i<=range1;i++) {
				sum =n+m;
				n=m;
				m=sum;
				System.out.print(sum+" ");
			}
		}
	}

