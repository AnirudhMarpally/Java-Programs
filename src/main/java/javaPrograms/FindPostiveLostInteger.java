package javaPrograms;


import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;

public class FindPostiveLostInteger {
    public static int findPostiveLostInteger(int [] a) {
        /* a is the input array, write your logic here and return the output. */
    	if (a.length == 0) return -1;
        for (int i = 0; i < a.length - 1; i++) {
			// compare with the input[i] and i+1
			if (0 < a[i] && a[i] < a.length && a[i] != (i+1)) {
				swap(a, (i+1), a[i]);
				i--; // continue to check the current int
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] != (i+1))
				return i+1;
		}
		return a.length+1;
	
	
	
            
    }
    public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {-1,-5,1};
        findPostiveLostInteger(a);
        System.out.println(findPostiveLostInteger(a));
    }
}
        