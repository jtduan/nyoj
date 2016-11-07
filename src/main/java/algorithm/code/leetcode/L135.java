package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L135 {
	public int candy(int[] ratings) {
		int res = 1;
		boolean up = true;
		int len_up = 1;
		int len_down = 1;
		int cur = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				up = true;
				len_up++;
				len_down = 1;
				res += len_up;
				cur = 1;
			} else if (up = true && ratings[i] == ratings[i - 1]) {
				res += len_up;
				cur++;
			} else if (up == false && ratings[i] == ratings[i - 1]) {
				res += len_down;
				cur++;
			} else if (ratings[i] < ratings[i - 1]) {
				up = false;
				len_down += cur;
				len_up = 1;
				res += len_down;
				cur = 1;
			}
		}
		return res;
	}
}
