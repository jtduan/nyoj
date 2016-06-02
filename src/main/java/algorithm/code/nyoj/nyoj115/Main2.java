package algorithm.code.nyoj.nyoj115;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static int X = 100000000;

    public static int[][] map = new int[1002][1002];
    public static int[] dis = new int[1002];
    public static boolean[] vis = new boolean[1002];
    public static int[] army = new int[1002];

    public static void init(int cities, int dest) {
        for (int t = 1; t <= cities; t++) {
            dis[t] = (t == dest ? 0 : X);
            vis[t] = false;
        }
        for (int i = 1; i <= cities; i++) {
            for (int j = 1; j <= cities; j++) {
                map[i][j] = X;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = scan.nextInt();
        while (times-- != 0) {
            Arrays.fill(dis, 0);
            Arrays.fill(army, 0);
            int i, j;
            int armies = scan.nextInt();
            int cities = scan.nextInt();
            int roads = scan.nextInt();
            int dest = scan.nextInt();

            init(cities, dest);
            if (times == 0)
                roads = roads - 1;
            for (i = 1; i <= armies; i++) {
                int x = scan.nextInt();
                army[x] = 1;
            }
            for (i = 1; i <= roads; i++) {
                int start = scan.nextInt();
                int end = scan.nextInt();
                int lenght = scan.nextInt();
                if (map[start][end] > lenght)
                    map[start][end] = map[end][start] = lenght;
            }
            for (i = 1; i <= cities; i++) {
                int temp = 0, data = X;
                for (j = 1; j <= cities; j++) {
                    if (!vis[j] && dis[j] < data) {
                        temp = j;
                        data = dis[j];
                    }
                }
                if (X == data) break;
                vis[temp] = true;
                for (j = 1; j <= cities; j++) {
                    dis[j] = (dis[j] > dis[temp] + map[temp][j] ? dis[temp] + map[temp][j] : dis[j]);
                }
            }
            int maxlenght = X;
            for (int k = 1; k <= cities; k++) {
                if (army[k] == 1 && dis[k] < maxlenght) {
                    maxlenght = dis[k];
                }
            }
            System.out.println(maxlenght);
        }
    }
}
