package algorithm.code.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 欧拉回路
 * 欧拉路径
 */
public class Euler {
    public static int[][] map;
    public static boolean[][] vis;


    public static int[] path;
    public static int len_path = 0;

    public Euler(int n) {
        map = new int[n][n];
        vis = new boolean[n][n];
    }

    public Euler(int[][] graph) {
        int n = graph.length;
        map = new int[n][n];
        vis = new boolean[n][n];
        path = new int[500];
        len_path = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = graph[i][j];
            }
        }
    }

    /**
     * 有向图和无向图判断是否存在欧拉回路
     *
     * @param graph
     * @param directed
     * @return
     */
    public static boolean hasEulerCircle(int[][] graph, boolean directed) {
        if (!MinimumSpanningTree.isConnectedGraph(graph)) return false;
        int len = graph.length;
        int degree[] = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (graph[i][j] != 0 && graph[i][j] != Integer.MAX_VALUE) {
                    degree[i] += 1;
                    if (directed) degree[j] -= 1;
                    else degree[j] += 1;
                }
            }
        }
        if (directed) {
            for (int i = 0; i < len; i++) {
                if (degree[1] != 0) return false;
            }
            return true;
        }
        for (int i = 0; i < len; i++) {
            if ((degree[i] & 1) == 1) return false;
        }
        return true;
    }

    public static boolean hasEulerLine(int[][] graph, boolean directed) {
        if (!MinimumSpanningTree.isConnectedGraph(graph)) return false;
        int len = graph.length;
        int degree[] = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (graph[i][j] != 0 && graph[i][j] != Integer.MAX_VALUE) {
                    degree[i] += 1;
                    if (directed) degree[j] -= 1;
                    else degree[j] += 1;
                }
            }
        }
        if (directed) {
            int num_1 = 0;
            int num__1 = 0;
            for (int i = 0; i < len; i++) {
                if (degree[i] == 1) num_1++;
                if (degree[i] == -1) num__1++;
            }
            if (num_1 == 1 && num__1 == 1) return true;
            return false;
        }
        int num_odd = 0;
        for (int i = 0; i < len; i++) {
            if ((degree[i] & 1) == 0) num_odd++;
        }
        if (num_odd == 2 || num_odd == 0) return true;
        return false;
    }

    /**
     * 输出欧拉回路或欧拉路径
     *
     * @param graph
     * @return 从终点到起点依次经过的点(逆序)
     */
    public static int[] printEuler(int[][] graph) {
        Euler e = new Euler(graph);
        e.euler(0);
        path[len_path++] = 0;
        return path;
    }

    void euler(int u) {
        for (int v = 0; v < map.length; v++) //当需要按某一顺序排序输出时，修改该for循环的遍历条件
        {
            if (map[u][v] != 0 && !vis[u][v])  //map[u][v]存储该边的权重用以顺序输出
            {
                vis[u][v] = vis[v][u] = true;//如果是有向图的只需判断一个
                euler(v);
//                System.out.printf("%d %d\n",u,v);
                path[len_path++] = v;
            }
        }
    }


    /**
     * 查找混合图的欧拉路径(待补充)
     */


    /**
     * 有向图求强连通分量
     * 采用Targan算法
     * Kosaraju算法更易懂
     */

    public static Stack<Integer> stack = new Stack<Integer>();
    public static int[] visited;
    int n;
    int[] low;
    int[] dfn;
    List<List<Integer>> list = new ArrayList<List<Integer>>();

    public List<List<Integer>> getStrongConnectedComponent() {
        n = map.length;
        visited = new int[n];//0代表未访问,1代表在栈中,-1代表已出栈
        low = new int[n];
        dfn= new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return list;
    }

    private void dfs(int s) {
        stack.push(s);
        visited[s]=1;
        low[s]=stack.size();
        dfn[s]=stack.size();
        for (int j = 0; j < n; j++) {
            if (map[s][j] > 0 && visited[j] == 0) {
                dfs(j);
            }
            else if (map[s][j] > 0 && visited[j] == 1) {
                low[s]=Math.min(dfn[j],low[s]);
            }
        }
        if(low[s]>low[stack.peek()])low[s]=low[stack.peek()];
        if(dfn[s]==low[s]){
            List<Integer> sub_list=new ArrayList<Integer>();
            while(stack.size()>=low[s]) {
                int temp =stack.pop();
                sub_list.add(temp);
                visited[temp]=-1;
            }
            list.add(sub_list);
        }
    }

    public static void main(String[] args) {
//        int[][] graph = new int[][]{
//                {0, 2, 3, 10, 2},
//                {2, 0, 2, 1, 5},
//                {3, 2, 0, 8, 5},
//                {10, 1, 8, 0, 1},
//                {2, 5, 5, 1, 0},
//        };
//         int[][] graph = new int[][]{
//                {0, 2, 3, 10},
//                {2, 0, 2, 1},
//                {3, 2, 0, 8},
//                {10, 1, 8, 0}
//         };
        int[][] graph = new int[][]{
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0},
        };
//        int[] res = Euler.printEuler(graph);
//        for (int i = Euler.len_path - 1; i >= 0; i--) {
//            System.out.print(res[i] + " ");
//        }
//        System.out.println();
        List<List<Integer>> list =new Euler(graph).getStrongConnectedComponent();
        for(List<Integer> sub_list: list){
            for(Integer i : sub_list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
