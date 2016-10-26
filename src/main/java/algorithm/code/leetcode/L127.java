package algorithm.code.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by djt on 10/26/16.
 */
public class L127 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int deepth = 1;
		int num = 1;
		while (!queue.isEmpty()) {
			String top = queue.poll();
			if (top.equals(endWord)) return deepth;
			for(int i=0;i<top.length();i++){
				char[] chars = top.toCharArray();
				for(int j='a';j<='z';j++){
					if(chars[i]==j) continue;
					chars[i]=(char)j;
					if(wordList.contains(String.valueOf(chars))){
						queue.add(String.valueOf(chars));
						wordList.remove(String.valueOf(chars));
					}
				}
			}
			num--;
			if (num == 0) {
				deepth++;
				num = queue.size();
			}
		}
		return 0;
	}

	private boolean matches(String word, String top) {
		int sum = 0;
		for (int i = 0; i < top.length(); i++) {
			if (word.charAt(i) != top.charAt(i)) sum++;
			if (sum >= 2) return false;
		}
		return true;
	}
}
