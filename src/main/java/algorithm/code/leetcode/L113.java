package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L113 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> res=new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res.clear();
        stack.clear();
        dfs(root,sum);
        return res;
    }

    public void dfs(TreeNode root, int sum){
        if(root == null) return;
        if(root.left==null && root.right==null && sum == root.val){
            List<Integer> tmp = new ArrayList<>();
            tmp.addAll(stack);
            tmp.add(root.val);
            res.add(tmp);
            return;
        }
        stack.push(root.val);
        if(root.left!=null){
            dfs(root.left,sum-root.val);
        }
        if(root.right!=null){
            dfs(root.right,sum-root.val);
        }
        stack.pop();
    }
}
