package javaPrograms;

import java.util.Scanner;

public class StringEncode { 
    public static String encode(String input) { 
        StringBuilder output = new StringBuilder(); 
  
        if (input == null || input.length() == 0) { 
            return input; 
        } 
  
        char prev = input.charAt(0); 
        int count = 1; 
  
        for (int i = 1; i < input.length(); i++) { 
            char curr = input.charAt(i); 
  
            if (curr == prev) { 
                count++; 
            } 
            else { 
                output.append(prev); 
  
                if (count > 1) { 
                    output.append(count); 
                } 
  
                prev = curr; 
                count = 1; 
            } 
        } 
  
        output.append(prev); 
  
        if (count > 1) { 
            output.append(count); 
        } 
  
        if (output.length() == input.length()) { 
            return input; 
        } 
  
        return output.toString(); 
    } 
  
    public static void main(String[] args) { 
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the input string");
        String input = sc.nextLine(); 
        System.out.println(encode(input)); 
    } 
}