package algorithm.code.graph;

import java.util.Arrays;

/**
 * 最大流问题
 * 求解步骤:(类似于二分图)
 * while(存在增广路径){
 *     更新增广路径
 * }
 *
 * 使用SFPA求最短增广路径(或者BFS,DFS,Dijkstra),每次求最短路径会减少while循环的次数
 *
 * 需要使用的几个变量:
 * int[][] graph 原始有向图(各个线段最大流量)
 * int[][] cur 当前网络的流量
 *
 * SFPA算法需要用到的变量
 * lowest[] 各个点的最小距离
 * queue[] 模拟队列(SFPA不要求先进先出)
 */
public class MaxNetworkFlows {
    public static int[][] graph;
    public static int[][] cur;

    public MaxNetworkFlows(int[][] graph) {
        this.graph = graph;
        this.cur = new int[graph.length][graph.length];
    }

    public static void getMaxNetworkFlows(int start, int end){
        if(start == end) return;
        while(true) {
            int[] res = SFPA(start);
            if (res[end] == end) break;
            int p =end;
            while (p != start) {
                if (graph[res[p]][p] > 0) {
                    cur[res[p]][p]++;
                } else {
                    cur[res[p]][p]--;
                }
                p = res[p];
            }
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                System.out.print(cur[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] SFPA(int start) {
        int n = graph.length;
        int[] lowcost = new int[n];
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        /**
         * 将flag数组改为 队列用于记录待遍历节点
         */
        int[] queue = new int[n];
        int[] mst = new int[n];
        for(int i=0;i<n;i++){
            mst[i]=i;
        }
        int j, q;
        queue[start] = 1;
        lowcost[start] = 0;
        while (true) {
            q = 0;
            while (q < n && queue[q] == 0) {
                q++;
            }
            if (q == n) break;
            for (j = 0; j < n; j++) {
                if (lowcost[q]+1 < lowcost[j] && (cur[q][j]<graph[q][j]||cur[j][q]>0)) {
                    lowcost[j] = lowcost[q]+1;
                    queue[j] = 1;
                    mst[j] = q;
                }
            }
            queue[q] = 0;
        }
//        for (int p = 0; p < n; p++) {
//            System.out.println(lowcost[p] + " " + mst[p]);
//        }
        return mst;
    }

    public static void main(String[] args) {
        int[][] graph =new int[][]{
                {0,5,4,0,0},
                {0,0,4,0,2},
                {0,0,0,6,0},
                {0,1,0,0,8},
                {0,0,0,0,0},
        };
        new MaxNetworkFlows(graph).getMaxNetworkFlows(0,4);
    }
}
