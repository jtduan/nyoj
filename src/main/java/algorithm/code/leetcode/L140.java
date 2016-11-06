package algorithm.code.leetcode;

import java.util.*;

/**
 * Created by djt on 11/5/16.
 * 使用范型数组
 */
public class L140 {

	private List<String> res;
	List<Integer>[] map;
	char[] chars;

	List<String> stack;

	public List<String> wordBreak(String s, Set<String> wordDict) {
		chars = s.toCharArray();
		map = new List[chars.length + 1];
		map[0]=new ArrayList<>();
		int maxLen = getMaxLen(wordDict);

		for (int i = 0; i <= chars.length; i++) {
			for (int j = Math.max(0, i - maxLen); j < i; j++) {
				if (map[j] == null) continue;
				if (wordDict.contains(String.valueOf(chars, j, i - j))) {
					if (map[i] == null) {
						map[i] = new ArrayList<>();
					}
					map[i].add(j);
				}
			}
		}
		stack = new ArrayList<>();
		res = new ArrayList<>();
		dfs(chars.length);
		return res;
	}

	private void dfs(int cur) {
		if (cur == 0) {
			res.add(String.join(" ", stack));
			return;
		}
		if (map[cur] == null) return;
		for (int pre : map[cur]) {
			stack.add(0, String.valueOf(chars, pre, cur - pre));
			dfs(pre);
			stack.remove(0);
		}
	}

	private int getMaxLen(Set<String> wordDict) {
		int max = 0;
		for (String s : wordDict) {
			max = Math.max(max, s.length());
		}
		return max;
	}

	public List<String> wordBreak2(String s, Set<String> wordDict) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i < s.length(); i++) {
			if (wordDict.contains(s.substring(0, i))) {
				List<String> l = wordBreak2(s.substring(i, s.length()), wordDict);
				for (String str : l) {
					res.add(s.substring(0, i) + " " + str);
				}
			}
		}
		if (wordDict.contains(s)) {
			res.add(s);
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
