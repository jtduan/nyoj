package algorithm.code.codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/23/16.
 */
public class WeightSort {

	public static String orderWeight(String strng) {
		String[] strs = strng.split(" ");
		Arrays.sort(strs,WeightSort::compare);
		return String.join(" ",strs);
	}

	private static int compare(String s1,String s2) {
		int f1 = Arrays.stream(s1.split("")).mapToInt((s)->{return Integer.parseInt(s);}).reduce(0,(a,b)->{return a+b;});
		int f2 = Arrays.stream(s2.split("")).mapToInt((s)->{return Integer.parseInt(s);}).reduce(0,(a,b)->{return a+b;});
		if(f1!=f2) return f1-f2;
		else return s1.compareTo(s2);
	}


	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals("2000 103 123 4444 99", WeightSort.orderWeight("103 123 4444 99 2000"));
		assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", WeightSort.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
	}
}
