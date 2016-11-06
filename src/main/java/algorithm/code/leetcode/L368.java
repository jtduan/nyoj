package algorithm.code.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        int[] parent = new int[nums.length];
        int[] len = new int[nums.length];
        Arrays.fill(parent,-1);
        int all_max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    parent[i] = j;

                    if (all_max < len[i]) {
                        all_max = len[i];
                        index = i;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = parent[index];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L368().largestDivisibleSubset(new int[]{3, 4, 16, 8}));
    }
}
