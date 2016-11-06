package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by djt on 11/5/16.
 */
public class L51 {
	int[] queens;
	List<List<String>> res;

	public List<List<String>> solveNQueens(int n) {
		queens = new int[n];
		res = new ArrayList<>();
		dfs(0);
		return res;
	}

	private void dfs(int x) {
		if(x==queens.length){
			List<String> list = new ArrayList<>();
			for(int i=0,n=queens.length;i<n;i++){
				StringBuilder sb = new StringBuilder(n);
				for(int j=0,m=queens.length;j<m;j++) {
					if (queens[i] == j) sb.append("Q");
					else sb.append(".");
				}
				list.add(sb.toString());
			}
			res.add(list);
			return;
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
