package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L62 {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int[][] nums = new int[m][n];
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < nums[0].length; j++) {
            nums[0][j] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
            }
        }
        return nums[m - 1][n - 1];
    }
}
