package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/11/2
 */
public class L106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int root_val = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(root_val);
        int i = 0;
        while (inorder[i] != root_val) i++;
        TreeNode left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        TreeNode right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                Arrays.copyOfRange(postorder, i, inorder.length - 1));
        root.left = left;
        root.right = right;
        return root;
    }
}
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}