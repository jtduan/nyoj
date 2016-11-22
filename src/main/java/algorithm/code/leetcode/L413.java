package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author jtduan
 * @date 2016/11/15
 */
public class L413 {
    public int numberOfArithmeticSlices(int[] A) {
        Arrays.sort(A);
        int cur = 0;
        int res = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
            } else {
                cur = 0;
            }
            res += cur;
        }
        return res;
    }

    /**
     * 任意n个连续
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices2(int[] A) {
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if((long)A[i]-A[j]<Integer.MIN_VALUE) continue;
                if((long)A[i]-A[j]>Integer.MAX_VALUE) continue;
                Integer val = maps[j].get(A[i] - A[j]);
                maps[i].put(A[i] - A[j], maps[i].getOrDefault(A[i] - A[j], 0) + maps[j].getOrDefault(A[i] - A[j], 0) + 1);
                if (val != null) {
                    res += val;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new L413().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }
}
