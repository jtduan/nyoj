package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by djt on 11/13/16.
 */
public class L179 {
	public String largestNumber(int[] nums) {
//		String[] strs = new String[nums.length];
//		for (int i = 0; i < nums.length; i++) {
//			strs[i] = String.valueOf(nums[i]);
//		}
//		Arrays.sort(strs, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return (o2 + o1).compareTo(o1 + o2);
//			}
//		});
//		return Arrays.stream(strs).reduce((a, b) -> a + b).get();

		String res = Arrays.stream(nums).mapToObj((num)->String.valueOf(num))
				.sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		}).reduce((a, b) -> a + b).get().replaceAll("^0+","");
		return res.isEmpty()?"0":res;
	}

	public static void main(String[] args) {
		System.out.println(new L179().largestNumber(new int[]{0,0}));
	}
}
