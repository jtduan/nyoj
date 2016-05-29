package algorithm.code.utils;

import java.util.Arrays;

/**
 * 通过验证
 * 不使用优先队列的最小生成树算法
 * i,j之间不存在节点时用0表示
 */
public class MinTree {
    int[] lowcost;
    int[] prev; //存储该节点的上一节点
    int n;
    private int[][] graph;

    public MinTree(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.lowcost = new int [n];
        this.prev = new int [n];
    }

    public int prim() {
        /**
         * 以0节点为起点,因此数组可以从1开始
         */
        int i, j, min, minid,sum=0;

        Arrays.fill(lowcost,Integer.MAX_VALUE);
        Arrays.fill(prev,-1);
        for (i = 1; i < n; i++) {
            if(graph[0][i]>0){
                lowcost[i] = graph[0][i];
                prev[i]=0;
            }
        }

        for (i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            minid = 0;
            for (j = 1; j < n; j++) {
                if (lowcost[j] < min && lowcost[j] != 0) { //最小生成树不需要记录距离,因此lowest[i]=0表示该节点已经在集合中
                    min = lowcost[j];
                    minid = j;
                }
            }
            sum += min;
            lowcost[minid] = 0;//该节点加入集合

            for (j = 1; j < n; j++) {
                if (graph[minid][j]>0 && graph[minid][j] < lowcost[j]) {
                    lowcost[j] = graph[minid][j];
                    prev[j] = minid; //存储该节点的上一节点
                }
            }
        }
        for(i=1;i<lowcost.length;i++){
            if(lowcost[i]>0) return -1; //不存在最小生成树
        }
        return sum;
    }

    public int[] getMinTree(){
        if(prim()!=-1) return prev;//prev存储最小生成树中每个节点的上一跳
        return null;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,4,8,9,0},
                {4,0,9,9,0},
                {8,9,0,1,0},
                {9,9,1,0,0},
                {0,0,0,0,0}};
        MinTree mintree = new MinTree(graph);
        System.out.println(mintree.prim());
        int[] res=mintree.getMinTree();
//        for(int i=0;i<res.length;i++){
//            System.out.println(res[i]);
//        }
    }
}
