package javaPrograms;

import java.util.Scanner;


public class PasswordCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password to validate");
        String password = scanner.nextLine();
        int result = UserMainCode.validatePassword(password);
        if (result == 1) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
        scanner.close();
    }
}
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

class UserMainCode {
    public static int validatePassword(String password) {
        try {
            if (password.length() < 8) {
                throw new InvalidPasswordException("Password should have a minimum length of 8 characters");   
            }
            if (!(password.contains("@") || password.contains("_") || password.contains("#"))) {
                throw new InvalidPasswordException("Password should contain at least one of the special characters @, _, or #");
            }
            if (password.startsWith("@") || password.startsWith("_") || password.startsWith("#")) {
            	throw new InvalidPasswordException("password should not start with these special characters ( @, _, #)");
            }
            if (password.endsWith("@") || password.endsWith("_") || password.endsWith("#")) {
            	throw new InvalidPasswordException("Password should not end with these special characters ( @, _, #)");
            }
            
            return 1; // Password is valid
        } catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
            return -1; // Password is invalid
        }
    }
}


