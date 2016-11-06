package algorithm.code.hihocoder.hc1369;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author jtduan
 * @date 2016/11/3
 * 最大流问题一：基础版
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/hc1369.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        int M = cin.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < M; i++) {
            int start = cin.nextInt() - 1;
            int end = cin.nextInt() - 1;
            graph[start][end] += cin.nextInt();
        }
        System.out.println(new NetworkFlow(graph).getMaxNetworkFlows(0, N - 1));
    }
}

class NetworkFlow {
    public static int[][] graph;
    public static int[][] cur;

    public NetworkFlow(int[][] graph) {
        this.graph = graph;
        this.cur = new int[graph.length][graph.length];
    }

    public int getMaxNetworkFlows(int start, int end) {
        if (start == end) return 0;
        while (true) {
            int[] res = BFS(start, end);
            if (res[end] == Integer.MAX_VALUE) {
                int maxFlows = 0;
                for (int i = 0; i < graph[0].length; i++) {
                    maxFlows += cur[start][i];
                }
                return maxFlows;
            }
            int p = end;
            int maxFlows = Integer.MAX_VALUE;
            while (p != start) {
                if (graph[res[p]][p] > 0) {
                    maxFlows = Math.min(maxFlows, graph[res[p]][p] - cur[res[p]][p]);
                } else {
                    maxFlows = Math.min(maxFlows, cur[res[p]][p]);
                }
                p = res[p];
            }
            p = end;
            while (p != start) {
                if (graph[res[p]][p] > 0) {
                    cur[res[p]][p] += maxFlows;
                } else {
                    cur[res[p]][p] -= maxFlows;
                }
                p = res[p];
            }
        }
    }

    /**
     * 会超时
     * @param start
     * @return
     */
    private int[] SFPA(int start) {
        int[] res = new int[graph.length];
        int[] queue = new int[graph.length];
        int[] lowcost = new int[graph.length];
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        Arrays.fill(res, Integer.MAX_VALUE);
        lowcost[0] = 0;
        queue[0] = 1;
        while (true) {
            int p = 0;
            while (p < queue.length && queue[p] == 0) {
                p++;
            }
            if (p == queue.length) break;
            for (int i = 0; i < graph.length; i++) {
                if ((cur[p][i] < graph[p][i]) || (cur[i][p] > 0) && lowcost[p] + 1 < lowcost[i]) {
                    lowcost[i] = lowcost[p] + 1;
                    queue[i] = 1;
                    res[i] = p;
                }
            }
            queue[p]=0;
        }
        return res;
    }

    private int[] BFS(int start, int end) {
        int[] res = new int[graph.length];
        Arrays.fill(res, Integer.MAX_VALUE);
        Queue<Integer> set = new ArrayDeque<Integer>();
        set.add(start);
        while (res[end] == Integer.MAX_VALUE && !set.isEmpty()) {
            int p = set.poll();
            for (int i = 0; i < graph.length; i++) {
                if ((cur[p][i] < graph[p][i] || cur[i][p] > 0) && res[i] == Integer.MAX_VALUE) {
                    res[i] = p;
                    set.add(i);
                }
            }
        }
        return res;
    }
}