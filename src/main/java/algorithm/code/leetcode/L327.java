package algorithm.code.leetcode;

import java.util.*;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class L327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum[] = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0l, 1);
        int res = 0;
        for (int i = 1; i < sum.length; i++) {
            Map<Long, Integer> temp = map.subMap(sum[i] - upper, true, sum[i] - lower, true);
            res += temp.values().stream().reduce(0, Integer::sum);
            if (map.containsKey(sum[i])) map.put(sum[i], map.get(sum[i]) + 1);
            else map.put(sum[i], 1);
        }
        Arrays.sort(new int[]{1,2,3});
        return res;
    }
}
