package algorithm.code.codewars;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * Created by djt on 10/22/16.
 */
public class ArrayToTree {
	static class TreeNode {

		TreeNode left;
		TreeNode right;
		int value;

		TreeNode(int value, TreeNode left, TreeNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

		TreeNode(int value) {
			this(value, null, null);
		}
	}

	static TreeNode arrayToTree(int[] array) {
		int[] arr = new int[array.length + 1];
		System.arraycopy(array, 0, arr, 1, array.length);
		return build(arr, 1);
	}

	static TreeNode build(int[] array, int start) {
		if (start >= array.length) return null;
		TreeNode root = new TreeNode(array[start]);
		root.left = build(array, 2 * start);
		root.right = build(array, 2 * start + 1);
		return root;
	}
}
