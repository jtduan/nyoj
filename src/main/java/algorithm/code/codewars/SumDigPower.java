package algorithm.code.codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by djt on 10/22/16.
 */
public class SumDigPower {

	public static List<Long> sumDigPow(long a, long b) {
		List<Long> list = new ArrayList<>();

		while (a <= b) {
			if (check(a)) list.add(a);
			a++;
		}
		return list;
	}

	private static boolean check(long a) {
		long b=a;
		int[] nums = new int[64];
		int len = 0;
		while (b != 0) {
			nums[len++] = (int) b % 10;
			b = b / 10;
		}
		int res = 0;
		for (int i = 0; i < len; i++) {
			res += Math.pow(nums[i], len - i);
		}
		if (res == a) return true;
		return false;
	}


	private static void testing(long a, long b, long[] res) {
		assertEquals(Arrays.toString(res),
				Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
	}


	@Test
	public void test() {
		System.out.println("Basic Tests");
		testing(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
		testing(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
		testing(10, 100, new long[]{89});
		testing(90, 100, new long[]{});
		testing(90, 150, new long[]{135});
		testing(50, 150, new long[]{89, 135});
		testing(10, 150, new long[]{89, 135});
	}
}
