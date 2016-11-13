package algorithm.code.zzuli.z1829;

/**
 * 未通过
 */

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int N = cin.nextInt();
			int M = cin.nextInt();
			int pos[] = new int[M];
			for (int i = 0; i < M; i++) {
				pos[i] = cin.nextInt();
			}
			System.out.println(solution(N, pos));
		}
	}

	private static int solution(int n, int[] pos) {
		int num[] = new int[Math.max(4,n + 1)];
		boolean[] valid = new boolean[Math.max(4,n + 1)];
		Arrays.fill(valid, true);
		for (int p : pos) {
			valid[p] = false;
		}
		num[0] = 1;
		num[1] = valid[0] ? num[0] : 0;
		num[2] = (valid[1] ? num[1] : 0) +
				(valid[0] ? num[0] : 0);
		num[3] = (valid[1] ? num[1] : 0) +
				(valid[2] ? num[2] : 0) +
				(valid[0] ? num[0] : 0);
		for (int i = 4; i <= n; i++) {
			num[i] = (valid[i - 1] ? num[i - 1] : 0) +
					(valid[i - 2] ? num[i - 2] : 0) +
					(valid[i - 3] ? num[i - 3] : 0) +
					(valid[i - 4] ? num[i - 4] : 0);
		}
		return num[n];
	}
}
