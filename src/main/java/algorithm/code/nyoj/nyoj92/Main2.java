package algorithm.code.nyoj.nyoj92;

/***
 * Title: e92
 * <p>
 * Description:
 *
 * @author zoulux
 * @date 2015年5月19日 下午7:00:11
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main2 {

    static StreamTokenizer st = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));

    static int[][] map = new int[1450][1450];

    static Queue<Integer> queue = new ArrayDeque<Integer>(); //使用linkedList空间占用将会很大

    static int W, H;

    public static void main(String[] args) throws IOException {
        st.nextToken();
        int N = (int) st.nval;
        while (N-- > 0) {
            queue.clear();
            st.nextToken();
            W = (int) st.nval;
            st.nextToken();
            H = (int) st.nval;

            handle(H, W);

            for (int i = 1; i <= H; i++) {
                for (int j = 1; j <= W; j++) {
                    st.nextToken();
                    map[i][j] = (int) st.nval;

                }
            }
            solve(H, W);
        }
    }


    private static void handle(int h, int w) {
        for (int i = 0; i < w + 2; i++) {
            map[0][i] = 1;
            map[h + 1][i] = 1;
        }
        for (int i = 0; i < h + 2; i++) {
            map[i][0] = 1;
            map[i][w + 1] = 1;
        }


    }


    private static void solve(int h, int w) {
        BFS(0, 0);
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static void BFS(int i, int j) {
        queue.add(i);
        queue.add(j);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            for (int k = 0; k < 4; k++) {
                int a = x + dir[k][0];
                int b = y + dir[k][1];
                if (a < 0 || b < 0 || a > H + 1 || b > W + 1 || map[a][b] == 0)
                    continue;
                map[a][b] = 0;
                queue.add(a);
                queue.add(b);
            }
        }
    }
}
