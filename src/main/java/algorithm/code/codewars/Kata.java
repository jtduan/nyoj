package algorithm.code.codewars;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class Kata {
	public static long nextBiggerNumber(long n) {
		char[] chars = String.valueOf(n).toCharArray();
		int i = chars.length - 2;
		while (i >= 0 && chars[i] >= chars[i+1]){
			i--;
		}
		if (i < 0) return -1;

		char[] ch = Arrays.copyOfRange(chars,i,chars.length);
		Arrays.sort(ch);


		char temp = ch[0];
		ch[0] = ch[1];
		ch[1] = temp;

		for(int j=i;j<chars.length;j++){
			chars[j]=ch[j-i];
		}
		Arrays.sort(chars,0,5);

		return Long.parseLong(String.valueOf(chars));
	}

	@Test
	public void basicTests() {
		assertEquals(5234, Kata.nextBiggerNumber(4532));
		assertEquals(531, Kata.nextBiggerNumber(513));
		assertEquals(2071, Kata.nextBiggerNumber(2017));
		assertEquals(441, Kata.nextBiggerNumber(414));
		assertEquals(941543238, Kata.nextBiggerNumber(941542833));
	}
}