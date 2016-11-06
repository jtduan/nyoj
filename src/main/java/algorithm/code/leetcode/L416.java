package algorithm.code.leetcode;

import java.util.Arrays;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if (sum % 2 == 1) return false;

        boolean bag[] = new boolean[sum/2+1];
        bag[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=bag.length-1;j>=nums[i];j--){
                if(bag[j-nums[i]]){
                    bag[j]=true;
                    if(j==bag.length-1) return true;
                }
            }
        }
        return false;
    }
}
