package algorithm.code.graph;

import java.util.Arrays;

/**
 * 判断一个图是否为哈密顿回路
 * 求哈密顿回路路径
 */
public class Hamiton {
//    int graph[][] = {{0, 1, 0, 1, 0},
//        {1, 0, 1, 1, 1},
//        {0, 1, 0, 0, 1},
//        {1, 1, 0, 0, 1},
//        {0, 1, 1, 1, 0}};

    /**
     * 输出一条Hamiton回路
     * 正常解法为回溯法
     * 通过存储中间状态可以修改为循环
     *
     * @param graph
     */
    public static void getHamiton(int[][] graph) {
        int len = graph.length;
        int cur[] = new int[len + 1]; //该数组存储当前层次**的起点**已经遍历到的节点下标，将回溯改为循环
        Arrays.fill(cur, -1);
        int start = 0; //起点定义为0
        int k = 1; //当前层次
        cur[0] = start;

        boolean flag[] = new boolean[len];
        flag[start]=true;
        while (k >= 1) {
            int j = cur[k] + 1;
            while (j < len) {
                if (j == start && k == len && graph[cur[k - 1]][j] > 0) {
                    for (int p = 0; p < len; p++) {
                        System.out.println(cur[p]);
                    }
                    System.out.println();
                    return;
                }
                if (flag[j] == false && graph[cur[k - 1]][j] > 0) { //存在路径且j不在以前的层次
                    cur[k] = j;
                    flag[j] = true; //j节点已经在cur中（使用该数组起到类似hashMap的效果,无需遍历cur判断）
                    k++;
                    break;
                }
                j++;
            }
            if (j == len) {
                flag[cur[k]] = false;
                cur[k] = -1;
                k--;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 0}
        };
        getHamiton(graph);
    }
}
