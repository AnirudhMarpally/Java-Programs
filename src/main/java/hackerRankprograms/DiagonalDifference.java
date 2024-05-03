package hackerRankprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> templist = new ArrayList<Integer>();

            for (int k = 0; k < n; k++) {
                templist.add(scanner.nextInt());
            }
            arr.add(templist);
        }
		System.out.println(arr);
		for (int row = 0; row < arr.size(); row++) {
            for (int col = 0; col < arr.get(0).size(); col++) {
                System.out.print(arr.get(row).get(col) + ",");
            }
            System.out.println("");
        }
		diagonalDifference(arr);
	}
	public static void diagonalDifference(List<List<Integer>> arr) {
	    // Write your code here
		
		Object[][] a = new Object[arr.size()][arr.size()];
		int[][] aq;
		for(int i=0;i<arr.size();i++) {
			for(int j=0;j<arr.size();j++) {
				a[i][j] = arr.get(i).toArray();
			}
		}
		//Collections.copy(arr, aq);
		System.out.println(a);

	}
}
