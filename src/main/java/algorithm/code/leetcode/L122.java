package algorithm.code.leetcode;

/**
 * Created by djt on 11/5/16.
 */
public class L122 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null && root.val == sum) return true;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
