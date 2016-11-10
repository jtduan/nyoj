package algorithm.code.leetcode;

import java.util.*;

/**
 * Created by djt on 11/6/16.
 */
public class L354 {
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes.length==0) return 0;
		int[] res = new int[envelopes.length];
		Arrays.fill(res, 1);
		Envelopes[] ens = new Envelopes[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			ens[i] = new Envelopes(envelopes[i][0], envelopes[i][1]);
		}
		Arrays.sort(ens);
		for (int i = 0; i < ens.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (ens[i].x > ens[j].x && ens[i].y > ens[j].y) {
					res[i] = Math.max(res[i], res[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < res.length; i++) {
			max = Math.max(max, res[i]);
		}
		return max;
	}
}

class Envelopes implements Comparable<Envelopes> {
	int x;
	int y;

	public Envelopes(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Envelopes o) {
		if (x - o.x == 0) return y - o.y;
		return x - o.x;
	}
}