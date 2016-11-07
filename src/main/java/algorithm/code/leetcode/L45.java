package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L45 {
	public int jump(int[] nums) {
		int step = 0;
		int left = -1;
		int right = 0;
		while (left < right && right < nums.length - 1) {
			int temp = right;
			for (int i = right; i > left; i--) {
				temp = Math.max(temp, nums[i] + i);
			}
			step++;
			left = right;
			right = temp;
		}
		return step;
	}
}
