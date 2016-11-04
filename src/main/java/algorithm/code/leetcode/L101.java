package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;
    }
}
