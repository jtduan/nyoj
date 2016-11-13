package algorithm.code.nyoj.nyoj415;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj415.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        long k = cin.nextLong();
        solution(n, k);
    }

    private static void solution(int n, long k) {
        long range = 1;
        while (k >= range) {
            range *= 2;
        }
        long max = (long)Math.pow(2,n);
        System.out.println(Math.min(max, range + k));
    }
}
