package javaPrograms	;


//Name - Akhil Kumar baikan
//ID - 999903581
//Section - 030



import java.util.Scanner;

/**
 * RomanToArabicConverter program implements an application that
 * Converts the Roman number to it's equivalent Arabic number by
 * Checking all the error handling requirements
 * 
 * @author Akhil Kumar baikan
 *
 */
public class RomanToArabicConverter {

    /**
     * This is the main method to convert the
     * Roman number to Arabic number and
     * Print if there is an error in Roman number
     * 
     * @author Akhil Kumar baikan
     * 
     * @exception IllegalArgumentException
     * @param args
     * @return null
     */
	public static void main(String[] args) {

		//creating the scanner object
		Scanner input = new Scanner(System.in);
        System.out.print("Please enter a Roman Numeral: ");
        
        //Scanning the Roman numeral from the user input
        String romanNumeral = input.next();
        
        //Using the try-catch block to handle if there is an error or  printing the output
        try {
        	//Checking if there is an error in the user input - romanNumeral
        	errorHandlerCheck(romanNumeral);
	        System.out.println("The equivalent of the Roman Numeral " + romanNumeral + " is " + convertRomanToArabic(romanNumeral) );
		} catch (IllegalArgumentException e) {
			//Printing the error message of the corresponding error
			System.out.println(e.getMessage());
		}
        //Closing the scanner object
        input.close();
	}
	
	
	/**
	 * This method when called gives the Arabic equivalents for the Roman symbols
	 * 
	 * @author Akhil Kumar baikan
	 * 
	 * @param romanChar
	 * @return romanNumber
	 */
	private static int getRomanNumber(char romanChar) {
        int romanNumber = 0;
        //Initialize the values to all Roman Numbers - I,V,X,L,C,D,M
        switch (romanChar) {
        //Initializing the Arabic equivalent of Roman number - 'I' value = 1 
            case 'I':
                romanNumber = 1;
                break;
                
        //Initializing the Arabic equivalent of Roman number - 'V' value = 5             
            case 'V':
                romanNumber = 5;
                break;
                
    	//Initializing the Arabic equivalent of Roman number - 'X' value = 10  
            case 'X':
                romanNumber = 10;
                break;
                
        //Initializing the Arabic equivalent of Roman number - 'L' value = 50 
            case 'L':
                romanNumber = 50;
                break;
                
        //Initializing the Arabic equivalent of Roman number - 'C' value = 100
            case 'C':
                romanNumber = 100;
                break;
                
        //Initializing the Arabic equivalent of Roman number - 'D' value = 500 
            case 'D':
                romanNumber = 500;
                break;
                
        //Initializing the Arabic equivalent of Roman number - 'M' value = 1000 
            case 'M':
                romanNumber = 1000;
                break;
                
        //Initializing the default value
            default:
                romanNumber = -1;
        }
        
        //Returning the equivalent Arabic number of Roman symbol 
        return romanNumber;
    }
	
	
	/**
	 * This method checks if there is any error in the Roman Numeral and
	 * Throws the exception if the Roman numeral doesn't follow the eight rules
	 * Or calls the covertRomanToArabic method to calculate the equivalent Arabic integer
	 *  
	 * @author Akhil Kumar baikan
	 *  
	 * @param romanNumeral
	 * @return null
	 * @throws IllegalArgumentException To indicate the method has been passed an illegal or inappropriate argument or the error has been identified.
	 */
    public static int errorHandlerCheck(String romanNumeral) 
    		throws IllegalArgumentException {
     
        // Loop through each char in the string
        for (int i = 0; i < romanNumeral.length(); i++) {

            // Get the char at the current index
            char current = romanNumeral.charAt(i);

            // Get the char at the next index
            char next = '\0';
            if (i + 1 < romanNumeral.length()) {
                next = romanNumeral.charAt(i + 1);
            }

            // Error handling
            // 1 - Invalid Character
            if (!(current == 'I' || current == 'V' || current == 'X' || current == 'L'
                    || current == 'C' || current == 'D' || current == 'M')) {
                //System.out.println("1 - Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
                throw new IllegalArgumentException("1 - Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
            }

            // 2 - Invalid numeral: can't subtract auxiliary symbol
            //Checking if auxiliary Roman numeral - 'D' is subtracted
            if (current == 'D' && (next == 'M')) {
            	throw new IllegalArgumentException("2 - Invalid numeral: can't subtract auxiliary symbol.");
            }
            //Checking if auxiliary Roman numeral - 'V' is subtracted
            if (current == 'V' && next!='I' && next!='\0') {
            	throw new IllegalArgumentException("2 - Invalid numeral: can't subtract auxiliary symbol.");
            }
            //Checking if auxiliary Roman numeral - 'L' is subtracted
            if (current == 'L' && (next == 'M' || next == 'C' ||next =='D')) {
            	throw new IllegalArgumentException("2 - Invalid numeral: can't subtract auxiliary symbol.");
            }

            // 3 - Invalid numeral: two consecutive subtractions
            if (i + 2 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 2);
                //Checking if two consecutive subtractions are done in a row and throwing exception
                if (current == 'I' && next == 'V' && nextNext == 'X') {
                	throw new IllegalArgumentException("3 - Invalid numeral: two consecutive subtractions.");
                }
                if (current == 'X' && next == 'L' && nextNext == 'C') {
                	throw new IllegalArgumentException("3 - Invalid numeral: two consecutive subtractions.");
                }
                if (current == 'C' && next == 'D' && nextNext == 'M') {
                	throw new IllegalArgumentException("3 - Invalid numeral: two consecutive subtractions.");
                }
            }

            // 4 - Invalid numeral: additions don't decrease
            if (i + 3 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 2);
                char nextNextNext = romanNumeral.charAt(i + 3);
                if (current == 'I' && next == 'I' && nextNext == 'V' && nextNextNext == 'X') {
                	throw new IllegalArgumentException("4 - Invalid numeral: additions don't decrease.");
                }
                if (current == 'X' && next == 'X' && nextNext == 'L' && nextNextNext == 'C') {
                	throw new IllegalArgumentException("4 - Invalid numeral: additions don't decrease.");
                }
                if (current == 'C' && next == 'C' && nextNext == 'D' && nextNextNext == 'M') {
                	throw new IllegalArgumentException("4 - Invalid numeral: additions don't decrease.");
                }
            }

            
            // 5 - Invalid repetition of V, L or D
            int countv=0,countd=0,countl=0;  
            //For loop to count the occurrence of V, L and D Romans
            for(int j=0; j<romanNumeral.length(); j++) {
            	//Counting the occurrence if 'V' Roman Numeral
            	if (romanNumeral.charAt(j)=='V') {
					countv++;}
            	//Counting the occurrence if 'L' Roman Numeral
            	else if (romanNumeral.charAt(j)=='L') {
					countl++;}
            	//Counting the occurrence if 'I' Roman Numeral
            	else if (romanNumeral.charAt(j)=='D') {
					countd++;}
            }   
            //Checking the V, L and D Romans if they are repeated and throwing the exception
            if (countv>1||countl>1||countd>1) {
                throw new IllegalArgumentException("5 - Invalid repetition of V, L or D " );
			}
                
     
            // 6 - Too long repetition
            int counti=0,countx=0,countc=0,countm=0;
            //For loop to count the occurrence of I, X,C and M Romans
            for(int k=0; k<romanNumeral.length(); k++) {
            	//Counting the occurrence if 'I' Roman Numeral
            	if (romanNumeral.charAt(k)=='I') {
    				counti++;}
            	//Counting the occurrence if 'X' Roman Numeral
            	else if (romanNumeral.charAt(k)=='X') {
    				countx++;}
            	//Counting the occurrence if 'C' Roman Numeral
            	else if (romanNumeral.charAt(k)=='C') {
    				countc++;}
            	//Counting the occurrence if 'M' Roman Numeral
            	else if (romanNumeral.charAt(k)=='M') {
    				countm++;
            }}
            //Checking the V, L and D Romans if they are repeated and throwing the exception
            if (counti>3||countx>3||countc>3||countm>3) {
            	throw new IllegalArgumentException("6 - Too long repetition" );
			}    
                


            // 7 - Wrong subtraction
            if (i + 1 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 1);
                //Checking the if there is any wrong subtraction is happening
                //Ensuring that 'I' can be subtracted from 'V' and 'X' only
                if (current == 'I' && nextNext != 'V' && nextNext != 'X' && nextNext != 'I' ) {
                	throw new IllegalArgumentException("7 - Wrong subtraction");
                }
                //Ensuring that 'x' can be subtracted from 'L','M','C' only
                if (current == 'X' && nextNext == 'D') {
                	throw new IllegalArgumentException("7 - Wrong subtraction");
                }
            }

            // 8 - Cannot subtract more than one from a particular symbol
            if (i + 2 < romanNumeral.length()) {
            	next = romanNumeral.charAt(i+1);
                char nextNext = romanNumeral.charAt(i + 2);
                char nextNextNext = romanNumeral.charAt(i + 2);
                //Checking if the Roman - 'I' is subtracted more than once
                if (current == 'I' && next == 'I' && nextNext != 'I' ) {
                	throw new IllegalArgumentException("8 - Cannot subtract more than one from a particular symbol");
                }
                //Checking if the Roman - 'X' is subtracted more than once
                if (current == 'X' && next == 'X' && nextNext != 'I' && nextNext != 'V' && nextNext != 'X') {
                	throw new IllegalArgumentException("8 - Cannot subtract more than one from a particular symbol");
                }
                //Checking if the Roman - 'C' is subtracted more than once
                if (current == 'C' && next == 'C' && (nextNext == 'D' || nextNext == 'M')) {
                	throw new IllegalArgumentException("8 - Cannot subtract more than one from a particular symbol");
                }            
            }
        }
        //Checked all the error handlers and if they are fine then calling the convertRomanToArabic to calculate the arabic number
        return convertRomanToArabic(romanNumeral);
    }
    
    /**
     * This method calculates the equivalent Arabic number of the Roman number
     * 
     * @author Akhil Kumar baikan
     * 
     * @param romanNumber
     * @return arabicNumber
     */
	private static int convertRomanToArabic(String romanNumber) {
		
		// Initialize arabicNumeral value to 0
        int arabicNumber = 0;
        //Going through each iteration and calculating the Arabic number
        for (int i = 0; i < romanNumber.length(); i++) {
        	//Getting the Roman Character at each position of Roman Numeral
            char romanChar = romanNumber.charAt(i);
            //Getting the equivalent Arabic interger for the Roman Character by call the getRomanNumber method
            int lastNumber = getRomanNumber(romanChar);
            if (lastNumber > 0) {
                if (i + 1 < romanNumber.length()) {
                	//getting the equivalent Roman numeral integer from getRomanNumber into nextNumber
                    int nextNumber = getRomanNumber(romanNumber.charAt(i + 1));
                    if (nextNumber > lastNumber) {
                        arabicNumber += (nextNumber - lastNumber);
                        i++;
                    } else {
                        arabicNumber += lastNumber;
                    }
                } else {
                    arabicNumber += lastNumber;
                }
            } else {
                return -1;
            }
        }
        //Returning the equivalent Arabic integer to main method
        return arabicNumber;
    }
	
	
	

}