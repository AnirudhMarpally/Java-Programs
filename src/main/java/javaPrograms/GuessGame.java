package javaPrograms;

import java.awt.Checkbox;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        System.out.println("Game has started! Guess the correct number to Win!!");
        
        int result[] = guesscheck();
        System.out.println(result[0] +" YOU GUESSED IT in " + result[1] + " steps!");



	}
	
	public static int[] guesscheck(){
		
		Random random = new Random();
		int secretNumber = random.nextInt(1000000);

		Scanner scanner = new Scanner(System.in);
		int guessNumber;
        int numberOfTries = 0;
        int lastGuess = 0;
        
    	while (true) {
    		
        	guessNumber = scanner.nextInt();
            
            if (guessNumber > secretNumber) {
                System.out.println(guessNumber+" is too large");
            } else if (guessNumber < secretNumber) {
                System.out.println(guessNumber+" is too small");
            }
            
            
            if (guessNumber != lastGuess) {
            	numberOfTries++;
            }
            
            lastGuess = guessNumber;
            if (guessNumber == secretNumber) {
                break;
            }
 
        }
    	return new int[] {guessNumber,numberOfTries};
    	
    }

}
