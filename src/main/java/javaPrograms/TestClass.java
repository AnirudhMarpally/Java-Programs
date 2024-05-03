package javaPrograms;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (isAlmostLucky(N)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isAlmostLucky(int N) {
        // Check if N is divisible by 4 or 7
        if (N % 4 == 0 || N % 7 == 0) {
            return true;
        }
        return false;
    }
}
