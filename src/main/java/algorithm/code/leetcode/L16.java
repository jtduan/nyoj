package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (Math.abs(res - target) > Math.abs(nums[i] + nums[left] + nums[right] - target)) {
                    res = nums[i] + nums[left] + nums[right];
                }
                if (nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                } else {
                    return target;
                }
            }
        }
        return res;
    }
}
