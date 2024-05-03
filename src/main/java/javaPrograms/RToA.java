package javaPrograms;

import java.util.Scanner;

public class RToA {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roman;
        while ((roman = sc.nextLine()) != null && !roman.isEmpty()) {
            try {
                int arabic = convertRomanToArabic(roman);
                System.out.println(arabic);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }

    private static int convertRomanToArabic(String roman) throws IllegalArgumentException {
        int arabic = 0;
        int prevValue = Integer.MAX_VALUE;
        int repetitionCount = 0;
        boolean subtractionAllowed = true;
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            int value = getValue(c);
            if (value < prevValue) {
                if (!subtractionAllowed) {
                    throw new IllegalArgumentException("2 Invalid numeral: can't subtract auxiliary symbol.");
                }
                if (i > 1 && getValue(roman.charAt(i - 2)) == prevValue) {
                    throw new IllegalArgumentException("8 Cannot subtract more than one from a particular symbol.");
                }
                arabic -= prevValue;
                subtractionAllowed = false;
            } else if (value > prevValue) {
                if (i > 0 && getValue(roman.charAt(i - 1)) < value) {
                    throw new IllegalArgumentException("3 Invalid numeral: two consecutive subtractions.");
                }
                if (!isSubtractionAllowed(c)) {
                    throw new IllegalArgumentException("7 Wrong subtraction.");
                }
                if (repetitionCount > 0) {
                    throw new IllegalArgumentException("5 Invalid repetition of V, L or D.");
                }
                repetitionCount = 0;
                subtractionAllowed = true;
            } else {
                if (repetitionCount == 3) {
                    throw new IllegalArgumentException("6 Too long repetition.");
                }
                repetitionCount++;
                subtractionAllowed = true;
            }
            if (value > 0) {
                arabic += value;
            }
            prevValue = value;
        }
        return arabic;
    }

    private static int getValue(char c) throws IllegalArgumentException {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("1 Invalid character in input. Valid characters are I,V,X,L,C,D,M.");
        }
    }

    private static boolean isSubtractionAllowed(char c) {
        return c == 'I' || c == 'X' || c == 'C';
    }
}
