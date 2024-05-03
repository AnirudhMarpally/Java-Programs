package javaPrograms;


import java.util.Scanner;

/**
 * 
 * @author Anirudh Marpally
 *
 */
public class RomanNumeralConverter {

    /**
     * This is the main method to conert the
     * Roman number to Arabic number and
     * Print if there is an error in Roman number
     * 
     * @param args
     */
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a Roman Numeral: ");
        String romanNumeral = input.next();

        // Initialize values for each symbol
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;

        // Initialize arabicNumeral value to 0
        int arabicNumeral = 0;
        
        int counti=0,countx=0,countc=0,countm=0;
        for(int k=0; k<romanNumeral.length(); k++) {
        	if (romanNumeral.charAt(k)=='I') {
				counti++;
			}else if (romanNumeral.charAt(k)=='X') {
				countx++;
			}else if (romanNumeral.charAt(k)=='C') {
				countc++;
			}else if (romanNumeral.charAt(k)=='M') {
				countm++;
        }
        }
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
                System.out.println("1 - Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
                return;
            }

            // 2 - Invalid numeral: can't subtract auxiliary symbol
            if (current == 'D' && (next == 'M')) {
                System.out.println("2 - Invalid numeral: can't subtract auxiliary symbol.");
                return;
            }
            if (current == 'V' && next!='I' && next!='\0') {
                System.out.println("2 - Invalid numeral: can't subtract auxiliary symbol.");
                return;
            }
            if (current == 'L' && (next == 'M' || next == 'C' ||next =='D')) {
                System.out.println("2 - Invalid numeral: can't subtract auxiliary symbol.");
                return;
            }

            // 3 - Invalid numeral: two consecutive subtractions
            if (i + 2 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 2);
                if (current == 'I' && next == 'V' && nextNext == 'X') {
                    System.out.println("3 - Invalid numeral: two consecutive subtractions.");
                    return;
                }
                if (current == 'X' && next == 'L' && nextNext == 'C') {
                    System.out.println("3 - Invalid numeral: two consecutive subtractions.");
                    return;
                }
                if (current == 'C' && next == 'D' && nextNext == 'M') {
                    System.out.println("3 - Invalid numeral: two consecutive subtractions.");
                    return;
                }
            }

            // 4 - Invalid numeral: additions don't decrease
            if (i + 3 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 2);
                char nextNextNext = romanNumeral.charAt(i + 3);
                if (current == 'I' && next == 'I' && nextNext == 'V' && nextNextNext == 'X') {
                    System.out
                            .println("4 - Invalid numeral: additions don't decrease.");
                    return;
                }
                if (current == 'X' && next == 'X' && nextNext == 'L' && nextNextNext == 'C') {
                    System.out
                            .println("4 - Invalid numeral: additions don't decrease.");
                    return;
                }
                if (current == 'C' && next == 'C' && nextNext == 'D' && nextNextNext == 'M') {
                    System.out
                            .println("4 - Invalid numeral: additions don't decrease.");
                    return;
                }
            }

            // 5 - Invalid repetition of V, L or D
            int countv=0,countd=0,countl=0;
            for(int j=0; j<romanNumeral.length(); j++) {
            	if (romanNumeral.charAt(j)=='V') {
					countv++;
				}else if (romanNumeral.charAt(j)=='L') {
					countl++;
				}else if (romanNumeral.charAt(j)=='D') {
					countd++;
				}
            }
            if (countv>1||countl>1||countd>1) {
                System.out.println("5 - Invalid repetition of V, L or D " );
                return;
			}
                /*char nextNext = romanNumeral.charAt(i );
                char nextNextNext = romanNumeral.charAt(i + 1);
                if (current == 'V' && next == 'V' && nextNext == 'V') {
                    System.out.println("5 - Invalid repetition of V, L or D");
                    return;
                }
                if (current == 'L' && next == 'L' && nextNext == 'L') {
                    System.out.println("5 - Invalid repetition of V, L or D");
                    return;
                }
                if (current == 'D' && next == 'D' && nextNext == 'D') {
                    System.out.println("5 - Invalid repetition of V, L or D");
                    return;
                }*/
                
                if (countv>1||countl>1||countd>1) {
                    System.out.println("6 - Too long repetition");
                    return;
				}
            

            // 6 - Too long repetition
                
                if (counti>3||countx>3||countc>3||countm>3) {
                    System.out.println("6 - Too long repetition" );
                    return;
    			}    
                
                /*
            if (i + 4 < romanNumeral.length()) {
            	
                char nextNext = romanNumeral.charAt(i + 2);
                char nextNextNext = romanNumeral.charAt(i + 3);
                char nextNextNextNext = romanNumeral.charAt(i + 4);
                if (current == 'I' && next == 'I' && nextNext == 'I' && nextNextNext == 'I') {
                    System.out.println("6 - Too long repetition");
                    return;
                }
                if (current == 'X' && next == 'X' && nextNext == 'X' && nextNextNext == 'X') {
                    System.out.println("6 - Too long repetition");
                    return;
                }
                if (current == 'C' && next == 'C' && nextNext == 'C' && nextNextNext == 'C') {
                    System.out.println("6 - Too long repetition");
                    return;
                }
                if (current == 'M' && next == 'M' && nextNext == 'M' && nextNextNext == 'M'
                        && nextNextNextNext == 'M') {
                    System.out.println("6 - Too long repetition");
                    return;
                }
            }*/

            // 7 - Wrong subtraction
            if (i + 1 < romanNumeral.length()) {
                char nextNext = romanNumeral.charAt(i + 1);
                if (current == 'I' && nextNext != 'V' && nextNext != 'X' && nextNext != 'I' ) {
                    System.out.println("7 - Wrong subtraction");
                    return;
                }
                if (current == 'X' && nextNext == 'D') {
                    System.out.println("7 - Wrong subtraction");
                    return;
                }/*
                if (current == 'C' && (nextNext != 'D' || nextNext != 'M')) {
                    System.out.println("7 - Wrong subtraction");
                    return;
                }*/
            }

            // 8 - Cannot subtract more than one from a particular symbol
            if (i + 2 < romanNumeral.length()) {
            	next = romanNumeral.charAt(i+1);
                char nextNext = romanNumeral.charAt(i + 2);
                char nextNextNext = romanNumeral.charAt(i + 2);
                if (current == 'I' && next == 'I' && nextNext != 'I' ) {
                    System.out
                            .println("8 - Cannot subtract more than one from a particular symbol");
                    return;
                }
                if (current == 'X' && next == 'X' && nextNext != 'I' && nextNext != 'V') {
                    System.out
                            .println("8 - Cannot subtract more than one from a particular symbol");
                    return;
                }
                if (current == 'C' && next == 'C' && (nextNext == 'D' || nextNext == 'M')) {
                    System.out
                            .println("8 - Cannot subtract more than one from a particular symbol");
                    return;
                }
                
            }

            // Convert Roman Numeral
            /*
            switch (current) {
            case 'M':
                arabicNumeral += M;
                break;
            case 'D':
                arabicNumeral += D;
                break;
            case 'C':
                if (next == 'M')
                    arabicNumeral += (M - C);
                else if (next == 'D')
                    arabicNumeral += (D - C);
                else if (next == 'V')
                    arabicNumeral += (V);
                else if (next == 'I')
                    arabicNumeral += (I);
                else if (next == 'X')
                    arabicNumeral += (X);
                else if (next == 'L')
                    arabicNumeral += (L);
                else if (next == '\0')
                	arabicNumeral += 0;
                else
                    arabicNumeral += C;
                break;
            case 'L':
                arabicNumeral += L;
                break;
            case 'X':
                if (next == 'C')
                    arabicNumeral += (C - X);
                else if (next == 'L')
                    arabicNumeral += (L - X);
                else if (next == 'I')
                    arabicNumeral += (I);
                else if (next == '\0')
                	arabicNumeral += X;
                else 
                    arabicNumeral += X;
                break;
            case 'V':
            	if (next == '\0')
            		arabicNumeral += 0;
            	else if (next == 'I')
                	arabicNumeral += I;
            	else 
            		arabicNumeral += V;
                break;
            case 'I':
                if (next == 'X')
                    arabicNumeral += (X - I);
                else if (next == 'V')
                    arabicNumeral += (V - I);
                else if (next == '\0')
                	arabicNumeral += 0;
                else
                    arabicNumeral += I;
                break;
            }*/
        }
        
        System.out.println("The equivalent of the Roman Numeral " + romanNumeral + " is " + convertRomanToArabic(romanNumeral) );
    }
	private static int convertRomanToArabic(String romanNumber) {
        int arabicNumber = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            char romanChar = romanNumber.charAt(i);
            int lastNumber = getRomanNumber(romanChar);
            if (lastNumber > 0) {
                if (i + 1 < romanNumber.length()) {
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
        return arabicNumber;
    }
	private static int getRomanNumber(char romanChar) {
        int romanNumber = 0;
        switch (romanChar) {
            case 'I':
                romanNumber = 1;
                break;
            case 'V':
                romanNumber = 5;
                break;
            case 'X':
                romanNumber = 10;
                break;
            case 'L':
                romanNumber = 50;
                break;
            case 'C':
                romanNumber = 100;
                break;
            case 'D':
                romanNumber = 500;
                break;
            case 'M':
                romanNumber = 1000;
                break;
            default:
                romanNumber = -1;
        }
        return romanNumber;
    }

}