package algorithm.code.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L105 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        int i=0;
        while(inorder[i]!=preorder[0])i++;
        TreeNode node = new TreeNode(preorder[0]);
        node.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
        node.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
        return node;
    }
}
