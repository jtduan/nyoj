package algorithm.code.leetcode;

/**
 * Created by djt on 11/5/16.
 */
public class L174 {
	public int calculateMinimumHP(int[][] dungeon) {
		int height = dungeon.length;
		int width = dungeon[0].length;
		int[][] min = new int[height][width];
		min[height - 1][width - 1] = 1;
		for (int i = height - 2; i >= 0; i--) {
			min[i][width - 1] = Math.max(1, min[i + 1][width - 1] - dungeon[i + 1][width - 1]);
		}
		for (int i = width - 2; i >= 0; i--) {
			min[height - 1][i] = Math.max(1, min[height - 1][i + 1] - dungeon[height - 1][i + 1]);
		}

		for (int i = height - 2; i >= 0; i--) {
			for (int j = width - 2; j >= 0; j--) {
				min[i][j] = Math.max(1, Math.min(min[i + 1][j] - dungeon[i + 1][j], min[i][j + 1] - dungeon[i][j + 1]));
			}
		}
		return Math.max(1, min[0][0] - dungeon[0][0]);
	}

	public int calculateMinimumHP2(int[][] dungeon) {
		int height = dungeon.length;
		int width = dungeon[0].length;
		dungeon[height-1][width - 1] = Math.max(1,dungeon[height-1][width-1]);
		for (int i = height - 2; i >= 0; i--) {
			dungeon[i][width - 1] = Math.max(1, dungeon[i + 1][width - 1] - dungeon[i][width - 1]);
		}
		for (int i = width - 2; i >= 0; i--) {
			dungeon[height - 1][i] = Math.max(1, dungeon[height - 1][i + 1] - dungeon[height - 1][i]);
		}

		for (int i = height - 2; i >= 0; i--) {
			for (int j = width - 2; j >= 0; j--) {
				dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
			}
		}
		return dungeon[0][0];
	}
}
