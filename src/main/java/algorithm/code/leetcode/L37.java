package algorithm.code.leetcode;

/**
 * Created by djt on 11/6/16.
 */
public class L37 {
	public void solveSudoku(char[][] board) {
		dfs(board);
	}

	private static boolean dfs(char[][] map) {
		char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == '.') {
					for (int k = 0; k < 9; k++) {
						if (valid(map, i, j, chars[k])) {
							map[i][j] = chars[k];
							if (dfs(map)) return true;
							map[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	private static boolean valid(char[][] map, int x, int y, char ch) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == ch) return false;
			if (map[i][y] == ch) return false;
		}
		x = 3 * (x / 3);
		y = 3 * (y / 3);
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (map[i][j] == ch) return false;
			}
		}
		return true;
	}
}
