package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L87 {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		if (s1.length() == 0) return true;
		if (s1.length() == 1) {
			if (s1.charAt(0) == s2.charAt(0)) return true;
			return false;
		}
		return (isScramble(s1.substring(0, s1.length() / 2), s2.substring(0, s2.length() / 2))
				&& isScramble(s1.substring(s1.length() / 2, s1.length()), s2.substring(s2.length() / 2, s2.length())))
				||
				(isScramble(s1.substring(0, s1.length() / 2), s2.substring((s2.length() + 1) / 2, s2.length()))
						&& isScramble(s1.substring(s1.length() / 2, s1.length()), s2.substring(0, (s2.length() + 1) / 2)));
	}

	public static void main(String[] args) {
		System.out.println(new L87().isScramble("great", "rgtae"));
	}
}
