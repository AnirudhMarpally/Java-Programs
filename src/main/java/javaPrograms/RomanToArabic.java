package javaPrograms;


import java.util.Scanner;
 
public class RomanToArabic
{
    static int convertRomanNumeralToArabicNumber(char romanSymbol)
    {
        switch (romanSymbol)
        {
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
                return 0;
        }
    }
 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Roman Numeral: ");
        String romanNumeral = scanner.next();
        scanner.close();
 
        int arabicNumber = 0;
        int previousValue = 0;
 
        for(int i = romanNumeral.length()-1; i >= 0; i--)
        {
            int currentValue = convertRomanNumeralToArabicNumber(romanNumeral.charAt(i));
 
            if(currentValue >= previousValue)
            {
                arabicNumber += currentValue;
            }
            else
            {
                arabicNumber -= currentValue;
            }
 
            previousValue = currentValue;
        }
 
        System.out.println("Arabic Number: " + arabicNumber);
    }
}