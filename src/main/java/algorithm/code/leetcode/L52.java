package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djt on 11/5/16.
 */
public class L52 {
	int[] queens;
	int res;

	public int totalNQueens(int n) {
		queens = new int[n];
		res=0;
		dfs(0);
		return res;
	}

	private void dfs(int x) {
		if(x==queens.length){
			res++;
		}
		for (int i = 0; i < queens.length; i++) {
			if (can(x, i)) {
				queens[x] = i;
				dfs(x + 1);
			}
		}
	}

	private boolean can(int x, int y) {
		for (int i = 0; i < x; i++) {
			if (queens[i] == y) return false;
			if (queens[i] + i == y + x) return false;
			if (queens[i] - i == y - x) return false;
		}
		return true;
	}
}
