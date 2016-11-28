package algorithm.code.test.syy01.sy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static int[][] vis;
    static char[][] map;
    static int sx;
    static int sy;
    static int dx;
    static int dy;
    static Queue<Point> queue;
    static int res = -1;

    static int[][] dic = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/sy02.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int p = 0; p < N; p++) {
            int H = cin.nextInt();
            int W = cin.nextInt();
            sy = cin.nextInt();
            sx = cin.nextInt();
            dy = cin.nextInt();
            dx = cin.nextInt();
            map = new char[W + 2][H + 2];
            vis = new int[W + 2][H + 2];
            queue = new ArrayDeque<>();
            res = -1;
            cin.nextLine();
            Arrays.fill(map[0], 'O');
            Arrays.fill(map[W + 1], 'O');
            for (int i = 1; i <= W; i++) {
                String chars = cin.nextLine();
                map[i][0] = 'O';
                map[i][H + 1] = 'O';
                for (int j = 1; j <= H; j++) {
                    map[i][j] = chars.charAt(j - 1);
                }
            }
            solution(map);
        }
    }

    private static void solution(char[][] map) {
        queue.add(new Point(sx, sy, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dic.length; i++) {
                if (map[p.x + dic[i][0]][p.y + dic[i][1]] != 'O') {
                    dfs(p.x + dic[i][0], p.y + dic[i][1], p.val + 1, map[p.x + dic[i][0]][p.y + dic[i][1]]);
                }
            }
            if (res != -1) {
                System.out.println("Y " + (res - 1));
                return;
            }
        }
        System.out.println("N");
    }

    private static void dfs(int sx, int sy, int val, char ch) {
        if (Math.abs(sx - dx) <= 1 && Math.abs(sy - dy) <= 1) {
            if (res == -1) res = val;
            return;
        }

        if (map[sx][sy] != ch && map[sx][sy] != 'X') return;
        if (vis[sx][sy] > 0) return;

        vis[sx][sy] = val;
        if (map[sx][sy] == 'X') {
            queue.add(new Point(sx, sy, val));
        }
        for (int i = 0; i < dic.length; i++) {
            dfs(sx - dic[i][0], sy - dic[i][1], val, ch);
        }
    }
}

class Point {
    int x;
    int y;
    int val;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
