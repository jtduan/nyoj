package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * Created by djt on 11/7/16.
 */
public class L16 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int res = Integer.MAX_VALUE;
		while (left < right) {
			int index = Arrays.binarySearch(nums, target - nums[left] - nums[right]);
			if (index >= 0) return target;
			else if (-index - 1 <= left) index = left + 1;
			else if (-index - 1 >= right) index = right - 1;
			else {
				index = -index - 1;
			}
			if (Math.abs(res - target) > Math.abs(nums[left] + nums[right] + nums[index] - target)) {
				res = nums[left] + nums[right] + nums[index];
			}
			if (index - 1 > left && Math.abs(res - target) > Math.abs(nums[left] + nums[right] + nums[index - 1] - target)) {
				res = nums[left] + nums[right] + nums[index - 1];
			}
			if(nums[left]+nums[right]<target) left++;
			else right--;
		}
		return res;
	}
}