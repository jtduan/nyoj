package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L330 {
	public int minPatches(int[] nums, int n) {
		int res = 0;
		int max = 1;
		int cur = 0;
		while (max <= n) {
			if (cur < nums.length) {
				if (nums[cur] > max) {
					res++;
					max = max * 2;
				} else {
					max = nums[cur] + max;
					cur++;
				}
			} else {
				res++;
				max = max * 2;
			}
		}
		return res;
	}
}
