package javaPrograms;

//

import java.util.Scanner;

/**
 * This Translator program implements an application that
 * Translates the Fake Latin to English and vice-versa
 * 
 * @author Anirudh Marpally
 *
 */
public class Translator {
	
	
	/**
	 * This is main method used to translate the text as asked
	 * Then calls the required method
	 * 
	 * @author Anirudh Marpally
	 * @param args Unused
	 * @return null
	 */
	public static void main(String[] args) {
		
		//creating the scanner object
		Scanner sc = new Scanner(System.in);
        System.out.print("Hi!! Welcome to the LATIN <-> ENGLISH translator \n");
        System.out.println("Enter the translation code" + "\n"+ "English -> Latin : press 1" + "\n" +"Latin -> English : press 2" );
        
        
        int translationcode = sc.nextInt();
        
        if (translationcode == 1) {
        	//method call
			englishToLatin();
		} else if (translationcode == 2) {
			//method call
			latinToEnglish();
		} else {
			System.out.println("Sorry!! Translater doen't recognize your text");
		}
        
        //closing the scanner object
        sc.close();
	}
	
	/**
	 * This method converts the English text to Latin and
	 * Prints the output using standard output stream
	 * 
	 * @author Anirudh Marpally
	 * @param text           Inputs English text from user
	 * @param latin          Stores the translated Latin text
	 * @param words          Splits the English text and stores in an array
	 * @param firstLetter    Spits the first letter of every element of words[]
	 * @param remainingWord  Holds the remaining word of each element of words[]
	 * @return null
	 */
	public static void englishToLatin() {
		
		    //creating a scanner object to read input from user
	    	Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the english text to translate: ");
            
            //reading the English sentence from user
            String text = sc.nextLine();
            text = text.toLowerCase();
            
            //splitting the English sentence into words
            String[] words = text.split(" ");
            
            String latin = "";
            
            //loop through each word for its translation
            for (String word : words) {
            	
            	//Separating the very first letter of the word
                String firstLetter = word.substring(0, 1);
                
                //Separating the remaining whole word
                String remainingWord = word.substring(1);
                
                //add the remaining word,first letter and 'ay' to the translated sentence
                latin += remainingWord + firstLetter + "ay ";
            }
            System.out.println("\n English Sentence : " + text);
            System.out.println("\n Latin Sentence : " + latin);
            sc.close();
        }
	
	
	/**
	 * This method converts the Latin text to English and
	 * Prints the output using standard output stream
	 * 
	 * @author Anirudh Marpally
	 * @param text           Inputs Latin text from user
	 * @param english        Stores the translated English text
	 * @param words          Splits the Latin text and stores in an array
	 * @param                lastLetter Spits the last letter of every element of words[]
	 * @param remainingWord  Holds the remaining word of each element of words[]
	 * @return null
	 */
	public static void latinToEnglish() {
		
		//creating a scanner object to read input from user
		Scanner sc = new Scanner(System.in);
		System.out.print("\n"+"Please enter the latin text to translate:");
		
		//reading the Latin sentence from user
        String text = sc.nextLine();
        text = text.toLowerCase();
        
        //splitting the Latin sentence into words
        String[] words = text.split(" ");
        String english = "";
        
        //using try-catch block for exception handling
        try {
        	
        	//loop through each word for its translation
	        for (String word : words) {
	        	
	        	//Separating the very last letter of the word
	            String lastLetter = word.substring(word.length() - 3, word.length() - 2);
	            
	            //Separating the remaining whole word
	            String remainingWord = word.substring(0, word.length() - 3);
	            
	            //add the remaining word,first letter and 'ay' to the translated sentence
	            english += lastLetter + remainingWord + " ";
	        }
	        
            System.out.println("\n Latin Sentence : " + text);
            System.out.println("\n English Sentence : " + english);
            
        }catch (Exception e) {
			// TODO: handle exception
			//printing the exception if the translator doesn't recognize the text as latin
			System.out.println("The entered text is not latin");
		}
        sc.close();
	}
}