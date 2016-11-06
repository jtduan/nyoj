package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class L329 {
    private int path[][];

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        int n = matrix[0].length;
        path = new int[m][n];
        int longest = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] == 0) {
                    longest = Math.max(longest, dfs(matrix, i, j, Integer.MIN_VALUE));
                }
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int i, int j, int target) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if (matrix[i][j] <= target) return 0;
        if (path[i][j] != 0) {
            return path[i][j];
        }

        int max = 0;
        max = Math.max(dfs(matrix, i + 1, j, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i, j + 1, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i - 1, j, matrix[i][j]), max);
        max = Math.max(dfs(matrix, i, j - 1, matrix[i][j]), max);
        path[i][j] = max + 1;
        return max + 1;
    }

    public static void main(String[] args) {

    }
}
