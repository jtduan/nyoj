package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by djt on 11/5/16.
 */
public class L257 {
	private Stack<Integer> list;
	private List<String> res;

	public List<String> binaryTreePaths(TreeNode root) {
		list = new Stack<>();
		res = new ArrayList<>();
		dfs(root);
		return res;
	}

	public void dfs(TreeNode root) {
		if (root == null) return;
		list.add(root.val);
		if (root.left == null && root.right == null) {
			res.add(getList());
			list.pop();
			return;
		}
		dfs(root.left);
		dfs(root.right);
		list.pop();
	}

	public String getList() {
		StringBuilder sb = new StringBuilder();
		for (Integer i : list) {
			sb.append(i).append("->");
		}
		return sb.substring(0, sb.lastIndexOf("-"));
	}
}
