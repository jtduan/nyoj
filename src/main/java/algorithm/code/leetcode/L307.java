package algorithm.code.leetcode;

/**
 * Created by djt on 10/29/16.
 */
public class L307 {

	private int[] bitree;
	private int[] nums;

	public L307(int[] nums) {
		bitree = new int[nums.length + 1];
		this.nums = nums;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length + 1; j+=lowbit(j)) {
				bitree[j] += nums[i];
			}
		}
	}

	void update(int i, int val) {
		i++;
		int change = val - nums[i - 1];
		nums[i-1]=val;
		for (int j = i; j < nums.length; j+=lowbit(j)) {
			bitree[j] += change;
		}
	}

	public int sumRange(int i, int j) {
		j++;
		int sum = 0;
		for (int p = j; p > 0; p -= lowbit(p)) {
			sum += bitree[p];
		}
		for (int p = i; p > 0; p -= lowbit(p)) {
			sum -= bitree[p];
		}
		return sum;
	}

	public int lowbit(int i) {
		return i & (-i);
	}

	public static void main(String[] args) {
		int nums[]=new int[]{-1};
		L307 l = new L307(nums);
		l.update(0,3);
		System.out.println(l.sumRange(0,0));
	}
}
