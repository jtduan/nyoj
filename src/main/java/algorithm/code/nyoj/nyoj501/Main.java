package algorithm.code.nyoj.nyoj501;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 多参数动态规划
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj501.txt"), "utf8");
        cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int M = cin.nextInt();
        int P = cin.nextInt();
        solution(N, M, P);
    }

    private static void solution(int N, int M, int P) {
        int res[] = new int[N + 1];
        res[0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = N; j >= 0; j--) {
                for (int k = j - 1; k >= Math.max(j - P, 0); k--) {
                    res[j] = (res[j] + res[k]) % 1000000007;
                }
            }
        }
        System.out.println(res[N]);
    }
}
