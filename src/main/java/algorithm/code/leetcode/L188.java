package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 * Todo:Cannot pass!
 */

public class L188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        if (k > prices.length / 2) return getMax(prices);
        int[][] golbal = new int[k + 1][prices.length];
        int[][] cur = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                cur[i][j] = Math.max(cur[i][j - 1] + (prices[j] - prices[j - 1]), golbal[i - 1][j - 1]);
                golbal[i][j] = Math.max(golbal[i][j - 1], cur[i][j]);
            }
            boolean flag = true;
            for (int j = 1; j < prices.length; j++) {
                if (golbal[i][j] != golbal[i - 1][j]) flag = false;
            }
            if (flag) return golbal[i][prices.length - 1];
        }
        return golbal[k][prices.length - 1];
    }

    private int getMax(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

}
