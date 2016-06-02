package algorithm.code.utils;

import java.util.Arrays;

/**
 * 不使用 优先队列 的最短路径算法
 * 求最短路径,提供SFPA和Dijkstra算法求解
 */
public class MinPathes {
    private int n;
    private int[][] graph;
    /**
     * 存储起点到该点的最短距离
     */
    private int[] lowcost;

    /**
     * 存储路径的上一跳
     */
    private int[] prev;

    public MinPathes(int[][] graph) {
        this.graph = graph;
        this.n=graph.length;
        prev = new int[n];
        lowcost = new int[n];
    }

    /**
     * 使用条件:
     * 有向图/无向图
     * 正权边/负权边
     * 无负权环
     */
    public void SFPA(int start) {//假设从0开始遍历
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        int[] queue = new int[n];
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
                if (graph[q][j] >0 && graph[q][j] + lowcost[q] < lowcost[j]) {
                    lowcost[j] = graph[q][j] + lowcost[q];
                    queue[j] = 1;
                    prev[j] = q;
                }
            }
            queue[q] = 0;
        }
    }

    /**
     * 使用条件:
     * 有向图/无向图
     * 正权边
     * @param start
     * @param end
     * @return 两点的最短距离
     */
    public int Dijkstra(int start,int end) {
        int[] visited = new int[n]; //记录该节点是否已经遍历
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        int i, j, min, minid;
        /**
         * 初始,将起点加入已遍历集合visited[],更新lowest[](lowest[]中有值的为备胎)
         */
        for (i = 0; i < n; i++) {
            if(graph[start][i]>0){
                lowcost[i] = graph[start][i];
                prev[i] = start;
            }
        }
        visited[start] = 1;
        if(start == end){
            return 0;
        }
        lowcost[start]=0;
        for (i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;
            minid = 0;
            for (j = 0; j < n; j++) {
                if (lowcost[j] < min && visited[j] == 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
            visited[minid] = 1;//备胎中最小的加入已遍历集合,更新备胎附近放入值,加入新的备胎
            if(end == minid){ //终点已被加入集合,结束
                return lowcost[end];
            }
            for (j = 0; j < n; j++) {
                if (graph[minid][j]>0 && graph[minid][j] + lowcost[minid] < lowcost[j]) {
                    lowcost[j] = graph[minid][j] + lowcost[minid];
                    prev[j] = minid; //该节点的上一节点，通过解析该数组可以打印出一条路径
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public int getLowcostSFPA(int start,int end) {
        SFPA(start);
        return lowcost[end];
    }

    public int getLowcostDijkstra(int start,int end) {
        return Dijkstra(start,end);
    }

    public int[] getPathSFPA(int start,int end) {
        int[] res = new int[n];
        SFPA(start);
        int len=0;
        while(end!=-1){
            res[len++]=end;
            end=prev[end];
        }
        return Arrays.copyOf(res,len);
    }
    public int[] getPathDijkstra(int start,int end) {
        int[] res = new int[n];
        Dijkstra(start,end);
        int len=0;
        while(end!=-1){
            res[len++]=end;
            end=prev[end];
        }
        return Arrays.copyOf(res,len);
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 10, 0, 0, 0, 11, 0, 0, 0},
                {10, 0, 18, 0, 0, 0, 16, 0, 12},
                {0, 0, 0, 22, 0, 0, 0, 0, 8},
                {0, 0, 22, 0, 20, 0, 0, 16, 21},
                {0, 0, 0, 20, 0, 26, 0, 7, 0},
                {11, 0, 0, 0, 26, 0, 17, 0, 0},
                {0, 16, 0, 0, 0, 17, 0, 19, 0},
                {0, 0, 0, 16, 7, 0, 19, 0, 0},
                {0, 12, 8, 21, 0, 0, 0, 0, 0}
        };
        MinPathes min = new MinPathes(graph);
        System.out.println(min.getLowcostSFPA(7,7));
        int[] path = min.getPathDijkstra(7,7);
        for(int i=0;i<path.length;i++){
            System.out.println(path[i]);
        }
//        min.SFPA(0);
//        dijkstra(map, map.length);
//        for(int i=0;i<graph.length;i++){
//            System.out.println(min.getLowcost()[i]+ " "+min.getPrev()[i]);
//        }
    }

    public int[] getLowcost() {
        return lowcost;
    }

    public int[] getPrev() {
        return prev;
    }
}
