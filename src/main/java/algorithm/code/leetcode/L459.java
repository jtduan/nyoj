package algorithm.code.leetcode;

/**
 * Created by djt on 11/13/16.
 */
public class L459 {
	public boolean repeatedSubstringPattern(String str) {
		if (str == null || str.isEmpty()) return false;
		int right = 1;
		int left = 0;
		char[] chars = str.toCharArray();
		while (right < chars.length) {
			if (chars[left] == chars[right]) {
				left++;
				right++;
			} else if (left == 0) {
				right++;
			} else {
				left = 0;
			}
		}
		if (chars.length - left <= left) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new L459().repeatedSubstringPattern("aaaaaa"));
	}
}
