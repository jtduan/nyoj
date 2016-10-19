package algorithm.code.leetcode;

import algorithm.code.graph.Kahn;

import java.util.Set;
import java.util.TreeSet;

/**
 * 拓扑排序
 */
public class L210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
        return Kahn_sort(graph);
    }

    public int[] Kahn_sort(int[][] graph) {
        int[] in = new int[graph.length];
        int res[] = new int[graph.length];
        int cur = 0;
        int max = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] > 0) in[j]++;
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) res[max++] = i;
        }
        while (max < graph.length) {
            if (cur >= max) return new int[0];
            int temp = res[cur++];
            for (int i = 0; i < graph.length; i++) {
                if (graph[temp][i] > 0) {
                    graph[temp][i] = 0;
                    in[i]--;
                    if (in[i] == 0) {
                        res[max++] = i;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
        int[] res = new L210().findOrder(10, prerequisites);
        for (int i = 0; i < res.length; i++) System.out.println(res[i]);
    }
}
