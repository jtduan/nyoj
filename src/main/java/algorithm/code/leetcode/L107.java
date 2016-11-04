package algorithm.code.leetcode;

import java.util.*;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int len = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            len--;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (len == 0) {
                res.add(0, temp);
                temp = new ArrayList<>();
                len = queue.size();
            }
        }
        return res;
    }
}
