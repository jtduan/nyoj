package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/10
 */
public class L18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            for (int k = i + 1; k < nums.length; k++) {
                if (k >= i + 2 && nums[k] == nums[k - 1]) continue;
                int left = k + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[k] + nums[left] + nums[right] > target) right--;
                    else if (nums[i] + nums[k] + nums[left] + nums[right] < target) left++;
                    else {
                        res.add(Arrays.asList(nums[i], nums[k], nums[left], nums[right]));
                        left = getNext(nums, left);
                    }
                }
            }
        }
        return res;
    }

    private int getNext(int[] nums, int left) {
        while (left + 1 < nums.length && nums[left + 1] == nums[left]) left++;
        return left + 1;
    }
}
