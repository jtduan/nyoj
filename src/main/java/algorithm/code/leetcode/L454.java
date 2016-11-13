package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * Created by djt on 11/13/16.
 */
public class L454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Arrays.sort(C);
		Arrays.sort(D);
		int len = A.length;
		int res = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				int l = 0;
				int r = len - 1;
				while (l < len && r >= 0) {
					if (A[i] + B[j] + C[l] + D[r] < 0) l++;
					else if (A[i] + B[j] + C[l] + D[r] > 0) r--;
					else {
						int x = 0;
						int y = 0;
						while (l + x < len && C[l + x] == C[l]) x++;
						while (r - y >= 0 && D[r - y] == D[r]) y++;
						res += x * y;
						l = l + x;
						r = r - y;
					}
				}
			}
		}
		return res;
	}
}
