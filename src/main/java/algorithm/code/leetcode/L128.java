package algorithm.code.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> min_map = new HashMap<>();
        Map<Integer, Integer> max_map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (min_map.containsKey(nums[i])) continue;
            else {
                int min = 1;
                if (min_map.get(nums[i] + 1) != null) {
                    min = min_map.get(nums[i] + 1) + 1;
                }
                int max = 1;
                if (max_map.get(nums[i] - 1) != null) {
                    max = max_map.get(nums[i] - 1) + 1;
                }
                max_map.put(nums[i],max);
                min_map.put(nums[i],min);

                int bottom = nums[i] - max + 1;
                int top = nums[i] + min - 1;
                max_map.put(top, top - bottom + 1);
                min_map.put(bottom, top - bottom + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : max_map.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new L128().longestConsecutive(new int[]{4,2,2,-4,0,-2,4,-3,-4,-4,-5,1,4,-9,5,0,6,-8,-1,-3,6,5,-8,-1,-5,-1,2,-9,1}));
    }
}
