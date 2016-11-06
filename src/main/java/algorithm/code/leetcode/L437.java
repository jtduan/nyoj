package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L437 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + pathSumFromRoot(root, sum);
    }

    public int pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res += 1;
        return res + pathSumFromRoot(root.left, sum - root.val) + pathSumFromRoot(root.right, sum - root.val);
    }
}
