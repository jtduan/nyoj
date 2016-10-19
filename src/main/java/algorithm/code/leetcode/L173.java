package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 忘记判断root为空的情况
 */
public class L173 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<TreeNode> list;
    int cur=0;
    public L173(TreeNode root) {
        list = new ArrayList<TreeNode>();
        touch(root);
        cur =0;
    }

    private void touch(TreeNode node) {
        if(node==null) return;
        touch(node.left);
        list.add(node);
        touch(node.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(cur<list.size()) return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = list.get(cur);
        cur++;
        return node.val;
    }
}