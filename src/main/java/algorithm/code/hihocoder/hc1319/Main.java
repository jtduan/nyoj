package algorithm.code.hihocoder.hc1319;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 * @date 2016/11/3
 * <p>
 * DFS/BFS
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/hc1319.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();
        int x = cin.nextInt();
        int y = cin.nextInt();
        int[][] graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = cin.nextInt();
            }
        }
        if (graph.length == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(dfs(graph, x, y, graph[x][y]));
    }

    private static int dfs(int[][] graph, int x, int y, int val) {
        if (x < 0 || x > graph.length-1 || y < 0 || y > graph[0].length-1) return 0;
        if (graph[x][y] != val) return 0;
        int res = 4;
        graph[x][y] = -1;
        if (x > 0 && graph[x - 1][y] == -1) res -= 2;
        if (y > 0 && graph[x][y - 1] == -1) res -= 2;
        if (x < graph.length - 1 && graph[x + 1][y] == -1) res -= 2;
        if (y < graph[0].length - 1 && graph[x][y + 1] == -1) res -= 2;

        res += dfs(graph, x + 1, y, val);
        res += dfs(graph, x - 1, y, val);
        res += dfs(graph, x, y - 1, val);
        res += dfs(graph, x, y + 1, val);
        return res;
    }
}
