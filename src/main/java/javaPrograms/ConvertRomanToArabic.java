package javaPrograms;

import java.util.Scanner;

public class ConvertRomanToArabic {
 
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
 
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Roman Number: ");
        String romanNumber = scanner.nextLine();
        int arabicNumber = convertRomanToArabic(romanNumber);
        if (arabicNumber != -1) {
            System.out.println("Arabic Number: " + arabicNumber);
        } else {
            System.out.println("Invalid Roman Number");
        }
    }
}