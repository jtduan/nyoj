package algorithm.code.graph;

import java.util.Arrays;

/**
 * 速成版prim算法
 * 可以改造为迪克斯拉算法
 * 注意 区别
 * 1、Dijkstra算法需要一个额外的数组记录该点是否已存在
 * 2、Dijkstra算法lowcost[]存储的是起点到该点的距离
 * <p>
 * Prim算法中，lowcost[i]=0表示该点在已遍历集合中
 * lowcost[i]<MAX表示该点在待遍历集合中（每次取出最小的）
 * lowcost[i]=MAX表示该点距离目前构造的树还很远……
 * <p>
 * dijkstra算法中，无法用0表示已遍历了，因此需要而外的数组存储
 * <p>
 * <p>
 * Dijkstra算法与SFPA算法区别
 * 1、SFPA算法出队顺序没有要求
 * 2、SFPA可以重复入队
 * <p>
 * 在没有负权边的图中，若SFPA采用优先队列每次都出最小的边，则与dijkstra算法相同
 * SFPA算法寻找A与B的最短距离时需要找到A到所有点的最短距离
 */
public class Prim_Dijkstra {
    static int MAX = Integer.MAX_VALUE;

    public static int prim(int[][] graph, int n) {
        char[] c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        int[] lowcost = new int[n];
        int[] mst = new int[n]; //存储该节点的上一节点
        int i, j, min, minid, sum = 0;

        for (i = 1; i < n; i++) {
            lowcost[i] = graph[0][i];
            mst[i] = 0;
        }

        for (i = 1; i < n; i++) {

            min = Integer.MAX_VALUE;
            minid = 0;
            for (j = 1; j < n; j++) {
                if (lowcost[j] < min && lowcost[j] != 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
//            System.out.println(c[mst[minid]] + "到" + c[minid] + " 权值：" + min);

            sum += min;
            lowcost[minid] = 0;

            for (j = 1; j < n; j++) {
                if (graph[minid][j] < lowcost[j]) {
                    lowcost[j] = graph[minid][j];
                    mst[j] = minid; //存储该节点的上一节点
                }
            }
        }

//        System.out.println("sum:" + sum);
        return sum;

    }

    public static void dijkstra(int[][] graph, int n) { //假设从0开始
        int[] lowcost = new int[n];
        int[] flag = new int[n];
        int[] mst = new int[n];
        int i, j, min, minid;
        for (i = 1; i < n; i++) {
            lowcost[i] = graph[0][i];
            mst[i] = 0;
        }
        flag[0] = 1;
        for (i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            minid = 0;
            for (j = 1; j < n; j++) {
                if (lowcost[j] < min && flag[j] == 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
//            System.out.println(c[mst[minid]] + "到" + c[minid] + " 权值：" + min);
            flag[minid] = 1;
            for (j = 1; j < n; j++) {
                if (graph[minid][j] < Integer.MAX_VALUE && graph[minid][j] + lowcost[minid] < lowcost[j]) {
                    lowcost[j] = graph[minid][j] + lowcost[minid];
                    mst[j] = minid; //该节点的上一节点，通过解析该数组可以打印出一条路径
                }
            }
        }
        for (int p = 0; p < n; p++) {
            System.out.println(lowcost[p] + " " + mst[p]);
        }
    }

    public static void SFPA(int[][] graph, int n) {//假设从0开始遍历
        char[] c = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'E', 'F'};
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
        int j, q, min, minid, sum = 0;
        queue[0] = 1;
        lowcost[0] = 0;
        while (true) {
            q = 0;
            while (q < n && queue[q] == 0) {
                q++;
            }
            if (q == n) break;
            for (j = 0; j < n; j++) {
                if (graph[q][j] < Integer.MAX_VALUE && graph[q][j] + lowcost[q] < lowcost[j]) {
                    lowcost[j] = graph[q][j] + lowcost[q];
                    queue[j] = 1;
                    mst[j] = q;
                }
            }
            queue[q] = 0;
        }
        for (int p = 0; p < n; p++) {
            System.out.println(lowcost[p] + " " + mst[p]);
        }

    }

//        System.out.println("sum:" + sum);


    public static void main(String[] args) {
//        int[][] map = new int[][]{
//                {0, 10, MAX, MAX, MAX, 11, MAX, MAX, MAX},
//                {10, 0, 18, MAX, MAX, MAX, 16, MAX, 12},
//                {MAX, MAX, 0, 22, MAX, MAX, MAX, MAX, 8},
//                {MAX, MAX, 22, 0, 20, MAX, MAX, 16, 21},
//                {MAX, MAX, MAX, 20, 0, 26, MAX, 7, MAX},
//                {11, MAX, MAX, MAX, 26, 0, 17, MAX, MAX},
//                {MAX, 16, MAX, MAX, MAX, 17, 0, 19, MAX},
//                {MAX, MAX, MAX, 16, 7, MAX, 19, 0, MAX},
//                {MAX, 12, 8, 21, MAX, MAX, MAX, MAX, 0}
//        };

        int[][] map = new int[][]{
                {0,4,8,9,4},
                {4,0,9,9,10},
                {8,9,0,1,9},
                {9,9,1,0,2},
                {4,10,9,2,0}};
//        SFPA(map, map.length);
//        dijkstra(map, map.length);
        System.out.println(prim(map,map.length));
    }

}