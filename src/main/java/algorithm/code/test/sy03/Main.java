package algorithm.code.test.sy03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/sy03.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int p = 0; p < N; p++) {
            char[][] map = new char[9][9];
            cin.nextLine();
            for (int i = 0; i < 9; i++) {
                String str = cin.nextLine();
                for (int j = 0; j < 9; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            dfs(map);

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            System.out.println();
        }
    }

    private static boolean dfs(char[][] map) {
        char[] chars = new char[]{'W', 'E', 'T', 'U', 'D', 'H', 'X', 'B', 'M'};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 'O') {
                    for (int k = 0; k < 9; k++) {
                        if (valid(map, i, j, chars[k])) {
                            map[i][j] = chars[k];
                            if (dfs(map)) return true;
                            map[i][j] = 'O';
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
