package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L322 {
    public int coinChange(int[] coins, int amount) {
        int res[] = new int[amount + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (res[j - coin] < Integer.MAX_VALUE) res[j] = Math.min(res[j], res[j - coin] + 1);
            }
        }
        if (res[amount] < Integer.MAX_VALUE) return res[amount];
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new L322().coinChange(new int[]{1,2,5},11));
    }
}
