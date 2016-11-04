package algorithm.code.leetcode;

import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) root = root.right;
            if (root.val > p.val && root.val > q.val) root = root.left;
            else return root;
        }
        return null;
    }
}
