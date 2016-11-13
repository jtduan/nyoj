package algorithm.code.leetcode;

import java.util.TreeMap;

/**
 * Created by djt on 11/13/16.
 */
public class L455 {
	public int findContentChildren(int[] g, int[] s) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int temp : s) {
			if (map.get(temp) == null) map.put(temp, 0);
			map.put(temp, map.get(temp) + 1);
		}
		int res = 0;
		for (int temp : g) {
			Integer min = map.ceilingKey(temp);
			if (min != null) {
				if (map.get(min) == 1) {
					map.remove(min);
				} else {
					map.put(min, map.get(min) - 1);
				}
				res++;
			}
		}
		return res;
	}
}
