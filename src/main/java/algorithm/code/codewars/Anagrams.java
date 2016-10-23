package algorithm.code.codewars;

import java.math.BigInteger;

/**
 * Created by djt on 10/23/16.
 */
public class Anagrams {
	public BigInteger listPosition(String word) {
		char first = word.charAt(0);
		boolean[] exist = new boolean[26];
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) < first && exist[word.charAt(i) - 'A'] == false) {
				exist[word.charAt(i) - 'A'] = true;
				sum = sum.add(getAll(word.length()-1));
			}
			if (word.charAt(i) == first && exist[word.charAt(i) - 'A'] == false) {
				exist[word.charAt(i) - 'A'] = true;
				sum = sum.add(getAll(word.length()-1));
			}
		}
		return BigInteger.ZERO;
	}

	private BigInteger getAll(int length) {
		BigInteger res = BigInteger.ONE;
		while (length >= 2) {
			res = res.multiply(BigInteger.valueOf(length));
		}
		return res;
	}
}
