package javaPrograms;

import java.util.Iterator;
import java.util.Scanner;

public class QuesTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String[] a = {"dhan","ai"};
		System.out.println(a[0]);
		specializeString(a);

	}
	public static String specializeString(String [] a) {
        /* a is the input array, write your logic here and return the output. */
		String result = "";
		for(int i=0; i<a.length; i++) {
			result = result+ a[i].length()+a[i]+"=";
		}
		System.out.println(result);
		return null;
    }

}
