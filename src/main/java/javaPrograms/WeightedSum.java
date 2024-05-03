package javaPrograms;

import java.util.Scanner;

public class WeightedSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number to check it's wsd");
		number=scanner.nextInt();
		
		System.out.println("The weighted sum of digits of "+number+" is "+sumOfDigits(number));


	}
	
	public static int sumOfDigits(int number) {
		
		int sum=0;
		
		//calculating the number of digits in number and storing in  position
		int position = (int)(Math.log10(number)+1);

		while(number>0){
			
			//storing the last digit of number into temp
			int temp = number%10;
			
			//multiplying and adding the each seperated digit(temp) by its position into sum
			sum = sum + (temp*position);
			
			//removing the last digit(temp)
			number=number/10;
			
			//decrementing the position as we are calculating from right to left
			position--;
		}
		return sum;
	}

}
