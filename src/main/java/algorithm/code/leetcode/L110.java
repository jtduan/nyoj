package algorithm.code.leetcode;

/**
 * Created by djt on 11/4/16.
 */
public class L110 {
	public boolean isBalanced(TreeNode root) {
		if (dfs(root) >= 0) return true;
		return false;
	}

	public int dfs(TreeNode root) {
		if (root == null) return 0;
		int left = dfs(root.left);
		if (left < 0) return left;
		int right = dfs(root.right);
		if (right < 0) return right;
		if (Math.abs(left - right) > 1) return - 1;

		return Math.max(left, right)+1;
	}
}