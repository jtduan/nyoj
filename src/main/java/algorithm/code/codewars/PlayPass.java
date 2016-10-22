package algorithm.code.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class PlayPass {
	public static String playPass(String s, int n) {
		StringBuilder step1 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (isCharacter(ch)) {
				step1.append((char)('A' + (ch - 'A' + n) % 26));
			} else if (isNum(ch)) {
				step1.append(9 - (ch - '0'));
			} else {
				step1.append(ch);
			}
		}

		StringBuilder step2 = new StringBuilder();
		for (int i = 0; i < step1.length(); i++) {
			if(i%2==1 && isCharacter(step1.charAt(i))) step2.append((char) (step1.charAt(i)-'A'+'a'));
			else step2.append(step1.charAt(i));
		}
		return step2.reverse().toString();
	}

	private static boolean isNum(char c) {
		if (c >= '0' && c <= '9') return true;
		return false;
	}

	private static boolean isCharacter(char c) {
		return String.valueOf(c).matches("[A-Za-z]");
	}


	@Test
	public void test1() {
		assertEquals("!!!vPz fWpM J", PlayPass.playPass("I LOVE YOU!!!", 1));
	}

	@Test
	public void test4() {
		assertEquals("4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO",
				PlayPass.playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2));
	}
}
