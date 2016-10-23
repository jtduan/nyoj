package algorithm.code.codewars;

import org.junit.Test;

import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class RevRot {

	public static String revRot(String strng, int sz) {
		if (strng == null || strng.isEmpty() || sz <= 0 || strng.length() < sz) return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i + sz < strng.length(); i += sz) {
			String sub = strng.substring(i, i + sz);
			sb.append(convert(sub));
		}
		return sb.toString();
	}

	private static String convert(String sub) {
		if (sub.chars().map((s) -> Character.getNumericValue(s)).sum() % 2 == 1) {
			return sub.substring(1) + sub.charAt(0);
		} else {
			return new StringBuilder(sub).reverse().toString();
		}
	}

	private static void testing(String actual, String expected) {
		assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		System.out.println("Fixed Tests: revRot");
		testing(RevRot.revRot("1234", 0), "");
		testing(RevRot.revRot("", 0), "");
		testing(RevRot.revRot("1234", 5), "");
		String s = "733049910872815764";
		testing(RevRot.revRot(s, 5), "330479108928157");
	}
}
