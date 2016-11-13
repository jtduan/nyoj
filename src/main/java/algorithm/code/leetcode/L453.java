package algorithm.code.leetcode;

/**
 * Created by djt on 11/13/16.
 */
public class L453 {
	public int minMoves(int[] nums) {
		int min = Integer.MAX_VALUE;
		for(int num:nums){
			min=Math.min(min,num);
		}
		int res=0;
		for(int i=0;i<nums.length;i++){
			res+=nums[i]-min;
		}
		return res;
	}
}
