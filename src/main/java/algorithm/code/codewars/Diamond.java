package algorithm.code.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class Diamond {
	public static String print(int n) {
		if (n % 2 == 0 || n<0) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <=n; i++) {
			int spaces = Math.abs((n + 1) / 2 - i);
			for (int j = 0; j < spaces; j++) {
				sb.append(" ");
			}
			if (i <= n / 2+1) {
				for (int j = 0; j < 2 * i - 1; j++) {
					sb.append("*");
				}
			} else {
				for (int j = 0; j < 2 * (n+1 - i) - 1; j++) {
					sb.append("*");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	@Test
	public void testDiamond3() {
		StringBuffer expected = new StringBuffer();
		expected.append(" *\n");
		expected.append("***\n");
		expected.append(" *\n");

		assertEquals(expected.toString(), Diamond.print(3));
	}

	@Test
	public void testDiamond5() {
		StringBuffer expected = new StringBuffer();
		expected.append("  *\n");
		expected.append(" ***\n");
		expected.append("*****\n");
		expected.append(" ***\n");
		expected.append("  *\n");

		assertEquals(expected.toString(), Diamond.print(5));
	}

	public static void main(String[] args) {
		System.out.println(Diamond.print(10));
	}
}
