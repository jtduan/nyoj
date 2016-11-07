package algorithm.code.nyoj.nyoj747;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 贪心算法+ DP
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner cin = null;
//		cin = new Scanner(new FileInputStream("src/main/resources/nyoj747.txt"), "utf8");
        cin= new Scanner(System.in);
		while(cin.hasNext()) {
			int T = cin.nextInt();
			int N = cin.nextInt();
			Dish dishes[] = new Dish[N];
			for (int i = 0; i < N; i++) {
				dishes[i] = new Dish(cin.nextInt(), cin.nextInt(), cin.nextInt());
			}
			solution(dishes, T);
		}
	}

	private static void solution(Dish[] dishes, int t) {
		Arrays.sort(dishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return o1.C * o2.B - o1.B * o2.C;
			}
		});

		long dp[] = new long[t + 1];
		for (int i = 0; i < dishes.length; i++) {
			for (int j = Math.min(t, dishes[i].A / dishes[i].B); j >= dishes[i].C; j--) {
				dp[j] = Math.max(dp[j], dp[j - dishes[i].C] + dishes[i].A - j * dishes[i].B);
			}
		}
		long max = 0;
		for (int i = 0; i <= t; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}

class Dish {
	int A;
	int B;
	int C;

	public Dish(int a, int b, int c) {
		A = a;
		B = b;
		C = c;
	}
}
