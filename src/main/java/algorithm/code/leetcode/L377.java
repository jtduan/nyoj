package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/17
 */
public class L377 {

    public int combinationSum4(int[] nums, int target) {
        int[] sums = new int[target + 1];
        sums[0]=1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if(j>=nums[i]) sums[j] = sums[j]+sums[j-nums[i]];
            }
        }
        return sums[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new L377().combinationSum4(nums, 4));
    }
}
