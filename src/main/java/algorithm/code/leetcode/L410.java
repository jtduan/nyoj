package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/11/21
 */
public class L410 {

    /**
     * 超时
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        if (nums.length == 0) return 0;
        long[] nums2 = new long[nums.length];
        long[] dp = new long[nums.length];
        nums2[0] = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums2[i] = nums[i] + nums2[i - 1];
            dp[i] = nums2[i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = nums.length-1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    if (dp[j] < dp[k]) break;
                    dp[j] = Math.min(dp[j], Math.max(dp[k], nums2[j] - nums2[k]));
                }
            }
        }
        return (int) dp[nums.length - 1];
    }
}
