package algorithm.code.nyoj.nyoj52;

import java.util.Scanner;

public class Main {
    static int a[] = {0, 10, 100, 1000, 10000, 100000};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        while (N-- > 0) {
            long n = input.nextLong();
            int k = input.nextInt();
            n = n % a[k];
            long t = n;
            int num = 0;
            for (int i = 0; i < a[k]; i++) {
                n = n * t % a[k];
                num++;
                if (n == t) {
                    System.out.println(num);return;
                }
            }
            System.out.println("-1");
        }
    }
}
