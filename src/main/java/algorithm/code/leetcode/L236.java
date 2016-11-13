package algorithm.code.leetcode;

import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/11/8
 */
public class L236 {
    Stack<TreeNode> stack;
    int res;
    TreeNode node;
    int count;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        res = 0;
        stack = new Stack<>();
        count = 0;
        dfs(root, p, q);
        return node;
    }

    private void dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (count == 2) return;
        stack.push(root);
        if (root == p || root == q) {
            if (count == 0) {
                count = 1;
                res = stack.size();
                node = root;
            } else if (count == 1) {
                count = 2;
            }
        }
        if (root.left != null) dfs(root.left, p, q);
        if (root.right != null) dfs(root.right, p, q);
        stack.pop();
        if (count == 1 && !stack.isEmpty() && res > stack.size()) {
            res = stack.size();
            node = stack.peek();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node2.left=node4;
        node2.right=node5;
        node5.right=node6;

        System.out.println(new L236().lowestCommonAncestor2(root,node5,node6).val);
    }
}
