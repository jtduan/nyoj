package algorithm.code.leetcode;

/**
 * Created by djt on 10/29/16.
 */
public class L357 {
	int visited[] = new int[10];

	public int countNumbersWithUniqueDigits(int n) {
		int sum = 0;
		if (n == 0) return 1;
		if (n == 1) return 10;
		sum += countNumbersWithUniqueDigits(n - 1);
		for (int i = 1; i <= 9; i++) {
			visited[i] = 1;
			sum += countNumbersUsingVisited(n - 1);
			visited[i] = 0;
		}
		return sum;
	}

	private int countNumbersUsingVisited(int n) {
		int sum = 0;
		if (n == 0) return 1;
		for (int i = 0; i <= 9; i++) {
			if (visited[i] == 1) continue;
			visited[i] = 1;
			sum += countNumbersUsingVisited(n - 1);
			visited[i] = 0;
		}
		return sum;
	}
}
