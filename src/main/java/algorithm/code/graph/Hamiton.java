package algorithm.code.graph;

import java.util.Arrays;

/**
 * 判断一个图是否为哈密顿回路
 * 求哈密顿回路路径
 */
public class Hamiton {

    /**
     * 输出一条Hamiton回路
     * 正常解法为回溯法
     * 通过存储中间状态可以修改为循环
     *
     * @param graph
     * @return cur 从起点到最后一个点依次经过的路径,不存在时返回空
     */
    public static int[] getHamiton(int[][] graph,int start) {
        int len = graph.length;
        int cur[] = new int[len+1]; //该数组存储当前层次**的起点**已经遍历到的节点下标，将回溯改为循环
        Arrays.fill(cur, -1);
//        int start = 1; //起点定义为0
        int k = 1; //当前层次
        cur[0] = start;

        boolean flag[] = new boolean[len];
        flag[start]=true;
        while (k >= 1) {
            /**
             * 删除第二个条件则可以hamtion从起点开始路径(需要注意是从起点开始,可能一幅图中含有hamtion不含环的路径但不是从起点开始)
             */
            if (k == len && graph[cur[k - 1]][start] > 0) {
                return Arrays.copyOf(cur,cur.length-1);
            }
            int j = cur[k] + 1;
            while (j < len) {
                if (flag[j] == false && graph[cur[k - 1]][j] > 0) { //存在路径且j不在以前的层次
                    if(cur[k]>=0)flag[cur[k]] = false;
                    cur[k] = j;
                    flag[j] = true; //j节点已经在cur中（使用该数组起到类似hashMap的效果,无需遍历cur判断）
                    k++;
                    break;
                }
                j++;
            }
            if (j == len) {
                if(cur[k]>=0)flag[cur[k]] = false;
                cur[k] = -1;
                k--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1,1,2,2},
                {1,0,0,0,0},
                {1,0,0,1,1},
                {2,0,1,0,1},
                {2,0,1,1,0}};
        int[] res = getHamiton(graph,0);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
