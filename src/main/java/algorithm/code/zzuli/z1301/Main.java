package algorithm.code.zzuli.z1301;

/**
 * 错误！！
 */

import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws FileNotFoundException {
		Scanner cin = new Scanner(new FileInputStream("src/main/resources/z1301"), "utf8");
//		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int M = cin.nextInt();
			int N = cin.nextInt();
			int K = cin.nextInt();
			int map[][] = new int[M + K][N + K];
			for (int i = K; i < M + K; i++) {
				for (int j = K; j < N + K; j++) {
					map[i][j] = cin.nextInt();
				}
			}
			System.out.println(soultion(map, K));
		}
	}

	private static int soultion(int[][] map, int p) {

		int M = map.length;
		int N = map[0].length;
		int[][][] golbal = new int[M][N][3];
		map = init(map, p);

//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

		for (int i = p; i < M; i++) {
			for (int j = p; j < N; j++) {
				golbal[i][j][0] = Math.max(map[i][j], Math.max(golbal[i][j - 1][0], golbal[i - 1][j][0]));
			}
		}


		for (int k = 1; k < 3; k++) {
			for (int i = p; i < M; i++) {
				for (int j = p; j < N; j++) {
//					int max = golbal[i][j - 1][k];
//					if (max < golbal[i - p][j][k - 1] + map[i][j]) max = golbal[i - p][j][k - 1] + map[i][j];
//					if (max < golbal[i][j - p][k - 1] + map[i][j]) max = golbal[i][j - p][k - 1] + map[i][j];
//					if (max < golbal[i - 1][j][k]) max = golbal[i - 1][j][k];
//
//					golbal[i][j][k] = max;

					int num = Math.max(golbal[i - p][j][k - 1], golbal[i][j - p][k - 1]) + map[i][j];
					golbal[i][j][k] = Math.max(num, Math.max(golbal[i][j - 1][k], golbal[i - 1][j][k]));
				}
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(golbal[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println("===");
		}
		return golbal[M - 1][N - 1][2];
	}

	private static int[][] init(int[][] map, int p) {
		int M = map.length;
		int N = map[0].length;

		int[][] res = new int[M][N];
		for (int j = p; j < N; j++) {
			for (int i = p; i < M; i++) {
				res[i][j] = res[i][j - 1] + map[i][j] - map[i][j - p];
			}
		}

		int[][] temp = map;
		map = res;
		res = temp;
		for (int j = p; j < N; j++) {
			for (int i = p; i < M; i++) {
				res[i][j] = res[i - 1][j] + map[i][j] - map[i - p][j];
			}
		}
		return res;
	}
}
