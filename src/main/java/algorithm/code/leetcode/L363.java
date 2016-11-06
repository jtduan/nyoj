package algorithm.code.leetcode;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class L363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] a = new int[m + 1][n];
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            a[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i + 1][j] = a[i][j] + matrix[i][j];
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sums[] = new int[n + 1];
                TreeSet<Integer> map = new TreeSet<>();
                map.add(0);
                for (int p = 0; p < n; p++) {
                    sums[p + 1] = sums[p] + a[j][p] - a[i][p];
                    if (map.ceiling(sums[p + 1] - k) != null) {
                        max = Math.max(max, sums[p + 1] - map.ceiling(sums[p + 1] - k));
                    }
                    map.add(sums[p + 1]);
                }
            }
        }
        return max;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i ++) {
            int[] colSum = new int[col];
            for (int j = i; j < row; j ++) {
                for (int c = 0; c < col; c ++) {
                    colSum[c] += matrix[j][c];
                }
                max = Math.max(max, maxSumSubArray(colSum, k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new L363().maxSumSubmatrix(new int[][]{{2,2,-1}},3));
        System.out.println(new L363().maxSumSubArray(new int[]{2, 2, -1}, 0));
    }

    private int maxSumSubArray(int[] a, int k) {

        int max = Integer.MIN_VALUE;
        int sumj = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);

        for (int i = 0; i < a.length; i++) {
            int t = sumj + a[i];
            sumj = t;
            Integer gap = s.ceiling(sumj - k);
            if (gap != null) max = Math.max(max, sumj - gap);
            s.add(t);
        }

        return max;
    }
}
