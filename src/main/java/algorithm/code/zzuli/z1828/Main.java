package algorithm.code.zzuli.z1828;

/**
 * 提交模板代码
 */

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		String str;
		while (cin.hasNext()) {
			str = cin.nextLine();
			System.out.println(solution(str));
		}
	}

	private static String solution(String str) {
		int cur = 0;
		while (cur + 1 < str.length()) {
			if (str.charAt(cur) <= str.charAt(cur + 1)) {
				cur++;
			} else break;
		}
		return str.substring(0, cur) + str.substring(cur + 1, str.length());
	}
}
