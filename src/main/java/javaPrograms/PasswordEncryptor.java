package javaPrograms;

//


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * PasswordEncryptor program implements an application that
 * Encrypts the name with password and saves it in a file &
 * Decrypts the encrypted name with password from the file
 * 
 * @author Anirudh Marpally
 *
 */
public class PasswordEncryptor {

    /**
     * 
     * This is the main method which will
     * Encrypt, decrypt, save & load the files by calling it,s respective methods
     * 
     * @param args
     * @return null
     */
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a password to file: ");
        String password = input.nextLine();

        System.out.println("Please choose an option: \n1. Enter your name and a filename to save \n2. Enter a filename to load");
        
        try {
        	
            int option = input.nextInt();

        	if(option == 1) {
                System.out.println("Please enter your name: ");
                String name = input.next();

                System.out.println("Please enter a filename to save: ");
                String filename = input.next();

                // Encrypt the name with the password
                String encryptedName = encrypt(name, password);

                // Save the encrypted name to the file
                saveToFile(encryptedName, filename);

                System.out.println("File saved successfully!");
            }
            else if(option == 2) {
                System.out.println("Please enter a filename to load: ");
                String filename = input.next();

                // Load the encrypted name from the file
                String encryptedName = loadFromFile(filename);

                // Decrypt the name with the password
                String decryptedName = decrypt(encryptedName, password);

                System.out.println("Name loaded successfully: " + decryptedName);
            }
            else {
                System.out.println("Invalid option!");
            }
        
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Try to select only from Option 1 & 2");
		}
	}
        

    
	/**
	 * Method to encrypt the name with the password
	 * 
	 * @param name
	 * @param password Password to the file to encrypt the name
	 * @return encryptedName Returns the encrypted text of the name
	 */
    public static String encrypt(String name, String password) {
        String encryptedName = "";
        
        // Repeating the password & storing in passwordRepeated for going through iterations in for loop
        String passwordRepeated = password.repeat(name.length()/password.length()+1);
        
        // Iterate through the name and password
        	for(int i = 0; i < name.length(); i++) {
        		try {
        			
                    char nameLetter = name.charAt(i);
                    char passLetter = passwordRepeated.charAt(i);
                                


                    // Get the ASCII code of the letters
                    int nameAscii = (int) nameLetter;
                    int passAscii = (int) passLetter;

                    // Do XOR operation between the ASCII codes
                    int xor = nameAscii ^ passAscii;

                    // Append the encrypted letter to the encrypted name
                    encryptedName += (char) xor;
				} catch (StringIndexOutOfBoundsException e) {
					// TODO: handle exception   
				}	
            }
        	
        return encryptedName;
    }

    /**
     * Method to save the encrypted name to the file
     * 
     * @param encryptedName   Encrypted name which will be saved in the file
     * @param filename        Name of the file to save it
     */
    public static void saveToFile(String encryptedName, String filename) {
        
    	 try {
    	        FileWriter writer = new FileWriter(filename);
    	        writer.write(encryptedName);
    	        writer.close();
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	    }
         System.out.println("Name saved successfully in the file !");
    }

    
    /**
     * Method to load the encrypted name from the file
     * 
     * @param filename        filename which contains the encrypted name
     * @return encryptedName  Returns the encrypted text in the file
     */
    public static String loadFromFile(String filename) {
        
    	 String encryptedName = "";
    	    try {
    	        FileReader reader = new FileReader(filename);
    	        int c;
    	        while ((c = reader.read()) != -1) {
    	            encryptedName += (char) c;
    	        }
    	        reader.close();
    	    } catch (IOException ex) {
    	        ex.printStackTrace();
    	    }
    	    return encryptedName;
    }

    
    /**
     * Method to decrypt the name with the password
     * 
     * @param encryptedName   The encrypted text which needs to be decrypt
     * @param password        The password to the file to decrypt the name
     * @return decryptedName  Returns the decrypted text of the encrypted text
     */
    public static String decrypt(String encryptedName, String password) {
        String decryptedName = "";
        String passwordRepeated = password.repeat(encryptedName.length()/password.length()+1);

        // Iterate through the encrypted name and password
        for(int i = 0; i < encryptedName.length(); i++) {
        	try {
        		int j=i;
        		char encryptedLetter = encryptedName.charAt(i);
                char passLetter = passwordRepeated.charAt(i);

                // Get the ASCII code of the letters
                int encryptedAscii = (int) encryptedLetter;
                int passAscii = (int) passLetter;

                // Do XOR operation between the ASCII codes
                int xor = encryptedAscii ^ passAscii;

                // Append the decrypted letter to the decrypted name
                decryptedName += (char) xor;
			} catch (Exception e) {
				// TODO: handle exception
			}  
        }
        
        return decryptedName;
    }
    
}