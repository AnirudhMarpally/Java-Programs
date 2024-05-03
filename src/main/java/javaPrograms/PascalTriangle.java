package javaPrograms;

//


import java.util.Scanner;

/**
 * @author Anirudh Marpally
 *
 */
public class PascalTriangle {

	/**
	 * This is main method which will make use of pascalValue method
	 * To print pascal's triangle using standard output stream
	 * 
	 * @author Anirudh Marpally
	 * @param args Unused
	 * @return null
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating the scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows for a pascal's triangle");
		
		//reading the number of rows for pascal's triangle from user
		int rows = sc.nextInt();
		
		
		
		//loop for printing pascal's triangle
		for (int i = 0; i < rows; i++)
	      {
			 //loop for left spacing of triangle
	       	 for(int space=1; space <= rows-i; space++){
	               System.out.print("  ");
	         }
	       	 //loop for printing pascal's values of a row
	         for (int j = 0; j <= i; j++) {
	        	 System.out.print(" ");
	             System.out.print(pascalsValue(i, j)+"  ");
	         }
	         
	         //moving to next line
	         System.out.println("\n");
	      }
		
		//closing the scanner object
		sc.close();
	   }
	 

	
	
	/**
	 * This method is used to find pascal's values
	 * 
	 * @author Anirudh Marpally
	 * @param i 
	 * @param j
	 * @return pascalsValues This returns the pascal's values
	 */
	public static int pascalsValue(int i, int j) {
		
		
		if (j == 0)
	      {
	         return 1;
	      }
	      else if (j == i)
	      {
	         return 1;
	      }
	      else 
	      {
	         return pascalsValue(i-1, j-1) + pascalsValue(i-1, j);
	      }
	}

}
