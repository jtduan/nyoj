package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by djt on 11/6/16.
 */
public class L451 {
	public String frequencySort(String s) {
		if (s == null) return null;
		Node[] nodes = new Node[128];
		for (int i = 0; i < 128; i++) {
			nodes[i] = new Node((char) i, 0);
		}
		for (char ch : s.toCharArray()) {
			nodes[ch].num++;
		}
		Arrays.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.num - o2.num;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < nodes[i].num; j++) {
				sb.append(nodes[i].val);
			}
		}
		return sb.toString();
	}
}

class Node {
	char val;
	int num;

	public Node(char val, int num) {
		this.num = num;
		this.val = val;
	}
}
