package algorithm.code.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by djt on 11/13/16.
 */
public class L456 {
    public boolean find132pattern(int[] nums) {
        if(nums.length==0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) && map.floorKey(nums[i]) != null && map.get(map.floorKey(nums[i])) == 1) {
                return true;
            }
            if (nums[i] < nums[i - 1]) {
                if (map.get(min) == null || map.get(min) == 1) {
                    map.put(min, 1);
                } else {
                    map.remove(min);
                }
                if (map.get(nums[i - 1]) == null || map.get(nums[i - 1]) == 2) {
                    map.put(nums[i - 1], 2);
                } else {
                    map.remove(nums[i - 1]);
                }
                min = nums[i];
            }
        }
        return false;
    }
}
