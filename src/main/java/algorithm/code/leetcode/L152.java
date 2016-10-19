package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/17
 * 连续最大乘积，相比连续最大和，需要记录max和min
 */
public class L152 {

    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;

        int cur_max = nums[0];
        int cur_min = nums[0];
        int max = cur_max;
        for(int i=1;i<nums.length;i++){
            int temp = cur_max;
            cur_max=Math.max(nums[i],Math.max(cur_max*nums[i],cur_min*nums[i]));
            cur_min = Math.min(nums[i],Math.min(cur_min*nums[i],temp*nums[i]));
            if(cur_max>max) max = cur_max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(1<<10);
    }
}
