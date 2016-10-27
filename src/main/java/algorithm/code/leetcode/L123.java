package algorithm.code.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L123 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int[] max_left = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        int[] max_right = new int[prices.length];
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }

        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, max_left[i] + max_right[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L123().maxProfit(new int[]{2, 1, 2, 0, 1}));
    }
}
