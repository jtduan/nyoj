package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] nums = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        nums[0][0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i][0] = obstacleGrid[i][0] == 0 ? nums[i - 1][0] : 0;
        }
        for (int j = 1; j < nums[0].length; j++) {
            nums[0][j] = obstacleGrid[0][j] == 0 ? nums[0][j - 1] : 0;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[0].length; j++) {
                nums[i][j] = (obstacleGrid[i][j] == 0 ? nums[i][j - 1] + nums[i - 1][j] : 0);
            }
        }
        return nums[m - 1][n - 1];
    }
}
