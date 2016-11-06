package algorithm.code.hihocoder.hc1038;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 * @date 2016/11/3
 * 背包问题
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/hc1038.txt"), "utf8");
        cin = new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();

        int[][] weight = new int[N][2];
        for (int i = 0; i < N; i++) {
            weight[i][0] = cin.nextInt();
            weight[i][1] = cin.nextInt();
        }
        System.out.println(f(weight, M));
    }

    private static int f(int[][] weight, int M) {
        int[] res = new int[M + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = M; j > weight[i][0]; j--) {
                res[j] = Math.max(res[j], res[j - weight[i][0]] + weight[i][1]);
            }
        }
        return res[M];
    }
}