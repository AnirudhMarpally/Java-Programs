package javaPrograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Occurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,44,2,1,6,7,9,33,33,44,2};
		checkOccurance(array);
		
		
	}
	public static void checkOccurance(int[] array) {
		ArrayList<Integer> check = new ArrayList<Integer>();
		for(int i : array) {
			check.add(i);
		}
		Set<Integer> s = new LinkedHashSet<Integer> (check);
		System.out.println(check + "This is array list");
		System.out.println(s +"This is linked hash set");
		Object[] arr = s.toArray();
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" occurs "+ Collections.frequency(check,arr[i]) + "times");
		}
	}
	

}
