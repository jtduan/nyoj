package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by djt on 11/13/16.
 */
public class L131 {
	List<List<String>> res;
	Stack<String> stack;
	String str;

	public List<List<String>> partition(String s) {
		int[][] map = new int[s.length() + 1][s.length() + 1];
		for (int i = 0; i < map.length - 1; i++) {
			map[i][i] = 1;
			map[i][i + 1] = 1;
		}
		map[map.length - 1][map.length - 1] = 1;
		for (int j = 2; j < map.length; j++) {
			for (int i = 0; i < map.length - j; i++) {
				if (s.charAt(i) == s.charAt(i + j - 1) && map[i + 1][i + j - 1] == 1) map[i][i + j] = 1;
			}
		}

		res = new ArrayList<>();
		stack = new Stack<>();
		str = s;
		dfs(map, 0);
		return res;
	}

	private void dfs(int[][] map, int cur) {
		if (cur == map.length - 1) {
			res.add(new ArrayList<>(stack));
		}
		for (int i = cur + 1; i < map.length; i++) {
			if (map[cur][i] == 1) {
				stack.add(str.substring(cur, i));
				dfs(map, i);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) {
		List<List<String>> list = new L131().partition("abbab");
		for (List<String> l : list) {
			for (String s : l) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
