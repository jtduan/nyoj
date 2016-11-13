package algorithm.code.leetcode;

/**
 * Created by djt on 11/13/16.
 */
public class L124 {
	int res = 0;

	public int maxPathSum(TreeNode root) {
		res = Integer.MIN_VALUE;
		dfs(root);
		return res;
	}

	private int dfs(TreeNode root) {
		if (root == null) return 0;
		int height_l = dfs(root.left);
		int height_r = dfs(root.right);
		res = Math.max(Math.max(0, height_l) + Math.max(0, height_r) + root.val, res);
		return Math.max(0, Math.max(height_l, height_r)) + root.val;
	}
}
