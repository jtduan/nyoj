package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L99 {
	public void recoverTree(TreeNode root) {
		dfs(root);
	}

	private TreeNode dfs(TreeNode node) {
		if(node==null) return null;
		TreeNode left = dfs(node.left);
		TreeNode right = dfs(node.right);
		if (left != null && right != null) {
			int temp = left.val;
			left.val = right.val;
			right.val = temp;
			return null;
		} else if (left == null) return right;
		else return left;
	}
}
