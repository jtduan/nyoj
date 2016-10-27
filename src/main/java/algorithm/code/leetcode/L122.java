package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            else {
                res += prices[i] - min;
                min = prices[i];
            }
        }
        return res;
    }
}
