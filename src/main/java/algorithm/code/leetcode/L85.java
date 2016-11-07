package algorithm.code.leetcode;

import java.util.Stack;

/**
 * Created by djt on 10/22/16.
 */
public class L85 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) return 0;
		int res = 0;
		int nums[] = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				nums[j] = matrix[i][j] == '0' ? 0 : nums[j] + 1;
			}
			res = Math.max(res, getMax(nums));
		}
		return res;
	}

	private int getMax(int[] nums) {
		int res = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nums.length; i++) {
			int len = 0;
			while (!stack.isEmpty() && stack.peek() > nums[i]) {
				int height = stack.pop();
				len++;
				res = Math.max(res, height * len);
			}
			for (int j = 0; j <= len; j++) stack.push(nums[i]);
		}
		int len = 0;
		while (!stack.isEmpty()) {
			int height = stack.pop();
			len++;
			res = Math.max(res, height * len);
		}
		return res;
	}
}
