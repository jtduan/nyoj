package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 * Todo:Cannot pass!
 */

public class L188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int[][] profits = new int[len][len];
        for (int i = 0; i < len; i++) {
            int min = prices[i];
            profits[i][i] = 0;
            for (int j = i + 1; j < len; j++) {
                profits[i][j] = Math.max(profits[i][j - 1], prices[j] - min);
                min = Math.min(min, prices[j]);
            }
        }

        int[][] res = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < len; j++) {
                for (int p = 0; p < j; p++) {
                    res[i][j] = Math.max(res[i - 1][p] + profits[p][j], res[i][j]);
                }
            }
        }
        return res[k][len - 1];
    }
}
