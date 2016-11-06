package algorithm.code.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L300 {
    public int lengthOfLIS(int[] nums) {
        int min[] = new int[nums.length];
        Arrays.fill(min, Integer.MAX_VALUE);
        if (nums.length == 0) return 0;
        int max = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(min, num);
            if (index < 0) {
                min[-index - 1] = Math.min(num, min[-index - 1]);
                max = Math.max(max, -index);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new L300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }


    public int lengthOfLIS2(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        if (nums == null || nums.length == 0) return 0;
        for (int num : nums) {
            if (map.isEmpty()) map.put(num, 1);
            else if (map.ceilingKey(num) == null) map.put(num, map.floorEntry(num).getValue() + 1);
            else if (!map.containsKey(num)) {
                map.put(num, map.ceilingEntry(num).getValue());
                map.remove(map.ceilingKey(num + 1));
            }
        }
        return map.lastEntry().getValue();
    }
}
