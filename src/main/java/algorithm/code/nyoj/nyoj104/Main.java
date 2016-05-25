package algorithm.code.nyoj.nyoj104;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 通过将矩阵的行数+1 来减少边界条件的判断
 * 时间复杂度O(n^3)
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj104.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int M = cin.nextInt();
        int N = cin.nextInt();
        int[][] nums = new int[M + 1][N];
        for (int i = 1; i < M + 1; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = nums[i - 1][j] + cin.nextInt();
            }
        }
        solution(nums, M + 1, N);
    }

    private static void solution(int[][] nums, int M, int N) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M-1; i++) {
            for (int j = i+1; j < M; j++) {
                int cur = 0;
                for (int k = 0; k < N; k++) {
                    if (nums[j][k] - nums[i][k] + cur > max) max = nums[j][k] - nums[i][k] + cur;
                    cur = nums[j][k] - nums[i][k] + cur;
                    if (cur < 0) cur = 0;
                }
            }
        }
        System.out.println(max);
    }
}
