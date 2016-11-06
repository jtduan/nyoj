package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L309 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1) return 0;
        int len = prices.length;
        int[] sell = new int[len];
        int[] golbal = new int[len];
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        golbal[0] = 0;
        golbal[1] = Math.max(0, sell[1]);
        for (int i = 2; i < len; i++) {
            sell[i] = Math.max(sell[i - 1] + prices[i] - prices[i - 1], golbal[i - 2]);
            golbal[i] = Math.max(golbal[i - 1], sell[i]);
        }
        return golbal[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new L309().maxProfit(new int[]{1,2,3,0,2}));
    }
}
