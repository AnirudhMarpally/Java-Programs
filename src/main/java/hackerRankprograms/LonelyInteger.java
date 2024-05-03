package hackerRankprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> a = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			a.add(scanner.nextInt());
		}
		scanner.close();
		System.out.println(lonelyinteger(a));
	}
	public static int lonelyinteger(List<Integer> a) {
	    int result=1;
	    
	    
	    for(int i : a) {
	    	while(Collections.frequency(a, i)==1) {
		    	result=i;
		    	System.out.println(i);
		    	break;
		    }
	    }
	    
		return result;
	}
}
