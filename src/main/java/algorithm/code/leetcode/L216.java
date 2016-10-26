package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by djt on 10/26/16.
 */
public class L216 {

	private List<List<Integer>> res;
	Stack<Integer> stack;

	public List<List<Integer>> combinationSum3(int k, int n) {
		res = new ArrayList<>();
		stack = new Stack<>();
		dfs(k, n);
		return res;
	}

	private void dfs(int k, int n) {
		if (k == 0 && n == 0) res.add(new ArrayList<>(stack));
		if (n <= 0 || k <= 0) return;
		for (int i = 1; i <= 9; i++) {
			if(!stack.contains(i)) {
				if(!stack.isEmpty() && i>stack.peek()) continue;
				stack.push(i);
				dfs(k - 1, n - i);
				stack.pop();
			}
		}
	}
}
