package algorithm.code.leetcode;

/**
 * Created by djt on 10/29/16.
 */
public class L283 {
	public void moveZeroes(int[] nums) {
		int left_0;
		int left = 0;
		while (left < nums.length && nums[left] != 0) left++;
		if (left == nums.length) return;
		left_0 = left;
		left++;
		while (left < nums.length){
			if(nums[left]!=0){
				nums[left_0]=nums[left];
				nums[left]=0;
			}
			left++;
		}
	}
}
