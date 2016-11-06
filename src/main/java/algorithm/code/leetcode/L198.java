package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L198 {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int res[] = new int[nums.length];
        res[0] = nums[0];
        res[1] = Math.max(nums[0], nums[1]);
        for (int i = 2, len = nums.length; i < len; i++) {
            res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
        }
        return res[nums.length - 1];
    }
}