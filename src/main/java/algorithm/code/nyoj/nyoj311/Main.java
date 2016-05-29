package algorithm.code.nyoj.nyoj311;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完全背包
 * tag: 背包问题
 * 注意: 完全背包不等于多重背包
 * 此题需要将数组初始化为最小值(或者负值并不参与递增)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj311.txt"),"utf8");
        cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int M = cin.nextInt();
        int V = cin.nextInt();
        long dp[] = new long[V + 1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for (int i = 0; i < M; i++) {
            int weight = cin.nextInt();
            int value = cin.nextInt();
            for (int j = weight; j <= V; j++) {
                if(dp[j-weight]>=0)dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        if (dp[V] == -1) {
            System.out.println("NO");
        } else {
            System.out.println(dp[V]);
        }
    }
}