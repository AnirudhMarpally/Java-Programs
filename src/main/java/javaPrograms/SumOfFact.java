package javaPrograms;

import java.util.Scanner;

public class SumOfFact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to find the sum of factors");
		int n = sc.nextInt();
		System.out.println("The sum of factors of "+ n + " is " + CalcFact(n));
		sc.close();
	}
	public static int CalcFact(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0)
				sum=sum+i;
		}
		return sum;
	}

}
