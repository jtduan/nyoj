package algorithm.code.nyoj.nyoj118;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  是否存在两个 最小生成树
 *  思路:每次选择一条最短线段加入生成树时,若存在多条最短线段,最终有的没有被加入最小生成树,这返回Yes,
 *  由于算法存储的是每个点的前一跳,因此可以分为两种情况
 *
 *  1, 备胎中有多个可以加入集合的节点,若最终这多个最小边最终有的没有被加入最小生成树中,说明存在多个最小生成树
 *  2, 某个点加入集合时它的前一跳有多种选择,也说明存在多个最小生成树
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj118.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int V =cin.nextInt();
        int E = cin.nextInt();
        int[][] graph = new int[V][V];
        for(int i=0;i<E;i++){
            int s = cin.nextInt()-1;
            int e = cin.nextInt()-1;
            graph[s][e]=cin.nextInt();
            graph[e][s]=graph[s][e];
        }
        solution(graph);
    }

    public static void solution(int[][] graph) {

        if(new MinTree(graph).prim()) System.out.println("Yes");
        else System.out.println("No");
    }
}

/**
 * 不使用优先队列的最小生成树算法
 * i,j之间不存在节点时用0表示
 */
class MinTree {
    int[] lowcost;
    int[] prev; //存储该节点的上一节点
    int n;
    private int[][] graph;
    public int[] flag;

    public MinTree(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        this.lowcost = new int [n];
        this.prev = new int [n];
        this.flag = new int[n];
    }


    public boolean prim() {
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
        lowcost[0]=0;
        for (i = 1; i < n; i++) {
            min = Integer.MAX_VALUE;
            minid = 0;
            for (j = 1; j < n; j++) {
                if (lowcost[j] < min && lowcost[j] != 0) { //最小生成树不需要记录距离,因此lowest[i]=0表示该节点已经在集合中
                    min = lowcost[j];
                    minid = j;
                }
            }

            for (j = 1; j < n; j++) {
                if (graph[minid][j] == min && j!=prev[minid]) {
                    if(lowcost[j] == 0)return true; //该节点加入集合是前一跳有多种选择
                }
            }
            for (j = 1; j < n; j++) {
                if (lowcost[j] == min && j!=minid) {
                    flag[j]=1; //j节点前一跳不能被更改
                }
            }

            lowcost[minid] = 0;//该节点加入集合

            for (j = 1; j < n; j++) {
                if (graph[minid][j]>0 && graph[minid][j] < lowcost[j]) {
                    if(flag[j]==1) return true; //试图更改j节点的前一跳
                    lowcost[j] = graph[minid][j];
                    prev[j] = minid; //存储该节点的上一节点
                }
            }
        }
        return false;
    }
}
