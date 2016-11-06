package algorithm.code.leetcode;

import java.util.Collections;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/2
 */
public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] num = new int[triangle.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                num[j] = Math.min(num[j], num[j + 1]) + triangle.get(i).get(j);
            }
        }
        return num[0];
    }
}
