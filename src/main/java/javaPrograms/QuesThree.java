package javaPrograms;

import java.util.Scanner;

public class QuesThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int[] a = {1,3,5};
        int T = 3;
        System.out.println(findSpecialPair(a, T));

	}
	public static String findSpecialPair(int [] a, int T) {
        /*Given array a of integers and an integer T
          returns yes or no */
		String yes = "yes";
		String no = "no";
		for(int i =0; i<a.length;i++) {
			for(int j =i+1;j<a.length;j++) {
				if(a[i] - a[j] == T || a[j]-a[i] ==T) {
					return yes;
					
				}
			}
		}
		return no;
    }

}
