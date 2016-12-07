package algorithm.code.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 难度：3
 * 动态规划
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，
 * 使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 */
public class NetEase9 {
    public static long solution(int[] nums, int k, int d) {
        long[][] dp = new long[nums.length + 1][k + 1];
        long[][] dp2 = new long[nums.length + 1][k + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                for (int p = 1; p <= Math.min(i, d); p++) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - p][j - 1] * nums[i - 1], dp2[i - p][j - 1] * nums[i - 1]));
                    dp2[i][j] = Math.min(dp2[i][j], Math.min(dp[i - p][j - 1] * nums[i - 1], dp2[i - p][j - 1] * nums[i - 1]));
                }
            }
        }
        long max = 0;
        for (int i = 0; i <= nums.length; i++) {
            max = Math.max(dp[i][k], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = cin.nextInt();
        }
        int k = cin.nextInt();
        int d = cin.nextInt();
        System.out.println(solution(num, k, d));
    }
}
