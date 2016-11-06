package algorithm.code.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by djt on 11/5/16.
 */
public class L205 {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		for (int i = 0, len = s1.length; i < len; i++) {
			if (!map.keySet().contains(s1[i]) && !set.contains(t1[i])) {
				map.put(s1[i], t1[i]);
				set.add(t1[i]);
			} else {
				if (map.get(s1[i]) == t1[i]) continue;
				return false;
			}
		}
		return true;
	}
}
