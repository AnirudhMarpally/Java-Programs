package javaPrograms;

import java.util.Scanner;

public class NextPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to find the next palindrome");
		int givennum = sc.nextInt();
		int n =givennum+1;
		while(FindNextPalindrome(n)==0) {
			n=n+1;
		}
		System.out.println("The next palindrome to the given number - "+ givennum + " is " +n);
		sc.close();
	}
	public static int FindNextPalindrome(int n) {
		int temp=n,sum=0,r;
		while(n!=0) {
			r=n%10;
			sum=(sum*10)+r;
			n=n/10;
		}
		if(temp==sum) 
			return 1;
		else
			return 0;
					
		}
		
	}


