package algorithm.code.leetcode;

import java.util.Stack;

/**
 * Created by djt on 10/22/16.
 * 第一个问题：如何初始化
 */
public class L84 {

	public int largestRectangleArea(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int count = 0;
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && stack.peek() > heights[i]) {
				int h = stack.pop();
				count++;
				if (max < h * count) max = h * count;
			}
			while (count > 0) {
				stack.push(heights[i]);
				count--;
			}
			stack.push(heights[i]);
		}
		while (!stack.isEmpty()) {
			int h = stack.pop();
			count++;
			if (max < h * count) max = h * count;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(new L84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
	}
}
