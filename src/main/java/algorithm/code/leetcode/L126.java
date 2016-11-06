package algorithm.code.leetcode;

import java.util.*;

/**
 * Created by djt on 11/5/16.
 */
public class L126 {
	Queue<String> queue;
	Map<String, Set<String>> pre;
	Set<String> visited;
	Set<String> wordList;

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

//		Iterator<String> it = wordList.iterator();
//		while (it.hasNext()) {
//			String str = it.next();
//			if (str.length() != beginWord.length()) it.remove();
//		}
//		map = new HashMap<>();
		pre = new HashMap<>();
		visited = new HashSet<>();
//
//		wordList.add(beginWord);
//		wordList.add(endWord);
//		for (String s1 : wordList) {
//			for (String s2 : wordList) {
//				if (matches(s1, s2)) {
//					if (map.get(s1) == null) map.put(s1, new ArrayList<>());
//					if (map.get(s2) == null) map.put(s2, new ArrayList<>());
//					map.get(s1).add(s2);
//					map.get(s2).add(s1);
//				}
//			}
//		}
		wordList.add(endWord);
		this.wordList = wordList;
		queue = new ArrayDeque<>();
		queue.add(beginWord);
		bfs(1, endWord);
		return dfs(beginWord, endWord);
	}

	private List<List<String>> dfs(String startWord, String endWord) {
		List<List<String>> res = new ArrayList<>();
		if (endWord.equals(startWord)) {
			List<String> temp = new ArrayList<>();
			temp.add(startWord);
			res.add(temp);
			return res;
		}
		if (pre.get(endWord) == null) return Collections.EMPTY_LIST;
		for (String str : pre.get(endWord)) {
			List<List<String>> temp = dfs(startWord, str);
			for (List<String> l : temp) {
				l.add(endWord);
			}
			res.addAll(temp);
		}
		return res;
	}

	private void bfs(int len, String endWord) {
		for (String str : queue) {
			visited.add(str);
		}
		if (len == 0) return;
		int p = 0;
		for (int i = 0; i < len; i++) {
			String str = queue.poll();
			for (String s : neibor(str, wordList)) {
				if (!visited.contains(s)) {
					queue.add(s);
					p++;
					if (pre.get(s) == null) pre.put(s, new HashSet<>());
					pre.get(s).add(str);
				}
			}
		}
		if (pre.get(endWord) == null) bfs(p, endWord);
	}

	private List<String> neibor(String str, Set<String> wordList) {
		List<String> neibors = new ArrayList<>();
		StringBuilder builder = new StringBuilder(str);
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < 26; j++) {
				if (str.charAt(i) == 'a' + j) continue;
				builder.setCharAt(i, (char) ('a' + j));
				if (wordList.contains(builder.toString())) {
					neibors.add(builder.toString());
				}
			}
			builder.setCharAt(i,str.charAt(i));
		}
		return neibors;
	}

	private boolean matches(String s1, String s2) {
		int dis = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				dis++;
				if (dis >= 2) return false;
			}
		}
		if (dis == 1) return true;
		return false;
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		String start = "hit";
		String end = "cog";
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		List<List<String>> res = new L126().findLadders(start, end, dict);
		System.out.println(res.size());
	}
}
