package algorithm.code.nyoj.nyoj322;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 求逆序数
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj322.txt"), "utf8");
		cin = new Scanner(System.in);
		int T = cin.nextInt();
		for (int i = 0; i < T; i++) {
			everyTest(cin);
		}
	}

	private static void everyTest(Scanner cin) {
		int N = cin.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = cin.nextInt();
		}
		System.out.println(f(nums));
	}

	private static int f(int[] nums) {
		if (nums.length == 0) return 0;
		int res = 0;
		Node root = new Node(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			res += add(root, nums[i]);
		}
		return res;
	}

	private static int add(Node root, int num) {
		if (root == null) return 0;
		int res = 0;
		if (num > root.num) {
			if (root.right != null) {
				root.val_r++;
				res += add(root.right, num);
			} else {
				Node n = new Node(num);
				root.right = n;
				root.val_r++;
			}
		} else if (num == root.num) {
			root.val++;
			res += root.val_r;
		} else {
			if (root.left != null) {
				res += root.val_r + root.val + add(root.left, num);
			} else {
				Node n = new Node(num);
				root.left = n;
				res += root.val_r + root.val;
			}
		}
		return res;
	}
}

class Node {
	int num;
	int val_r;
	int val;
	Node left;
	Node right;

	public Node(int num) {
		this.num = num;
		this.val_r = 0;
		this.val = 1;
		left = null;
		right = null;
	}
}