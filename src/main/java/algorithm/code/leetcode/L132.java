package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by djt on 11/13/16.
 */
public class L132 {

	public int minCut(String s) {
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
		return dp(map);
	}

	private int dp(int[][] map) {
		int[] res = new int[map.length];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = -1;
		for (int i = 1; i < map.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (map[j][i] == 1) res[i] = Math.min(res[i], res[j] + 1);
			}
		}
		return res[map.length - 1];
	}
}
