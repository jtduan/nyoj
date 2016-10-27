package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L375 {
    public int getMoneyAmount(int n) {
        int[][] res = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                int begin = j;
                int end = j + i;
                int max = j + res[begin + 1][end];
                max = Math.min(res[begin][end - 1] + end, max);
                for (int k = begin + 1; k <= end - 1; k++) {
                    max = Math.min(Math.max(res[begin][k - 1],res[k + 1][end]) + k, max);
                }
                res[begin][end] = max;
            }
        }
        return res[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new L375().getMoneyAmount(6));
    }
}
