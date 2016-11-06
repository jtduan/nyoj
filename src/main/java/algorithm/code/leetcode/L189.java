package algorithm.code.leetcode;

import java.util.*;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L189 {
    public void rotate(int[] nums, int k) {
//        Set<Integer> set = new HashSet(Arrays.asList(nums));
//        System.out.println(list.get(0));
//        Collections.rotate(list,k);
//        System.out.println(list.get(0));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        new L189().rotate(nums,1);
        System.out.println(nums[0]);
    }
}
