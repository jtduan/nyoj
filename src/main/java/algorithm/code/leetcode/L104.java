package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}