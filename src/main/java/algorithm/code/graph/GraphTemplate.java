//package algorithm.code.graph;
//
//import java.util.Arrays;
//import java.util.function.BiFunction;
//
///**
// * Created by hero on 2016/5/27.
// */
//public class GraphTemplate {
//
//    public static int MAX =Integer.MAX_VALUE;
//    public static int[] SFPA(int[][] graph, int start,BiFunction<Integer,Integer,Integer> f) {//假设从0开始遍历
//        int n = graph.length;
//        int[] lowcost = new int[n];
//        Arrays.fill(lowcost, Integer.MAX_VALUE);
//        /**
//         * 将flag数组改为 队列用于记录待遍历节点
//         */
//        int[] queue = new int[n];
//        int[] mst = new int[n];
//        for(int i=0;i<n;i++){
//            mst[i]=i;
//        }
//        int j, q;
//        queue[start] = 1;
//        lowcost[start] = 0;
//        while (true) {
//            q = 0;
//            while (q < n && queue[q] == 0) {
//                q++;
//            }
//            if (q == n) break;
//            for (j = 0; j < n; j++) {
//                if (f.apply(lowcost[q],graph[q][j]) < lowcost[j]) {
//                    lowcost[j] = f.apply(lowcost[q],graph[q][j]);
//                    queue[j] = 1;
//                    mst[j] = q;
//                }
//            }
//            queue[q] = 0;
//        }
////        for (int p = 0; p < n; p++) {
////            System.out.println(lowcost[p] + " " + mst[p]);
////        }
//        return mst;
//    }
//    public static void main(String[] args) {
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
//        int[] res = GraphTemplate.SFPA(map,0,(a,b)->{
//            if(a ==  Integer.MAX_VALUE || b ==Integer.MAX_VALUE) return Integer.MAX_VALUE;
//            return a+b;
//        });
//        int cur =6;
//        while(res[cur]!=cur){
//            System.out.println(cur);
//            cur=res[cur];
//        }
//        System.out.println(cur);
//    }
//}
