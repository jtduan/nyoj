package algorithm.code.codewars;

/**
 * Created by djt on 10/23/16.
 */
public class Hamming {

	public static long hamming(int n) {
		long[] nums = new long[n];
		nums[0] = 1;
		int index_2 = 0;
		int index_3 = 0;
		int index_5 = 0;
		for (int i = 1; i < n; i++) {
			long min = Math.min(nums[index_2] * 2, Math.min(nums[index_3] * 3, nums[index_5] * 5));
			if (nums[index_2] * 2 == min) index_2++;
			if (nums[index_3] * 3 == min) index_3++;
			if (nums[index_5] * 5 == min) index_5++;
			nums[i] = min;
		}
		return nums[n - 1];
	}
}
