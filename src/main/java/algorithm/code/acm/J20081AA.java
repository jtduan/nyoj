package algorithm.code.acm;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * GoogleCodeJam 2008年
 * 求向量内积最小值
 * 注意溢出问题：除了返回值定义为long,输入也需要强制转换为long
 */
public class J20081AA {

	public static BufferedWriter writer;
	public static Scanner cin = null;

	public static void main(String[] args) throws IOException {
		writer = new BufferedWriter(new FileWriter("/Users/djt/out.out"));
//		cin = new Scanner(new FileInputStream("/Users/djt/Downloads/A-small-practice.in"), "utf8");
		cin = new Scanner(new FileInputStream("/Users/djt/Downloads/A-large-practice.in"), "utf8");
		int T = cin.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = cin.nextInt();
			int[] v1 = new int[n];
			int[] v2 = new int[n];
			for (int j = 0; j < n; j++) {
				v1[j] = cin.nextInt();
			}
			for (int j = 0; j < n; j++) {
				v2[j] = cin.nextInt();
			}
			solution(v1, v2, i);
		}
	}

	private static void solution(int[] v1, int[] v2, int T) throws IOException {
		Arrays.sort(v1);
		Arrays.sort(v2);
		int len = v1.length;
		long res = 0;
		for (int i = 0; i < len; i++) {
			res += (long)v1[i] * v2[len - 1 - i];
		}
		writer.write("Case #" + T + ": " + res+"\n");
		writer.flush();
	}
}
