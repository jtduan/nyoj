package algorithm.code.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 二分图算法 步骤:
 * while(存在增广路径){
 *     变换增广路径上的线段颜色(将非匹配边变为匹配边,将匹配边变为非匹配边),匹配的个数会增加1
 * }
 * 结束
 *
 * 使用DFS或者BFS判断是否存在增广路径
 *
 * 注意:需要的几个变量:
 * graph[][]原始图
 * graph_col[][]标记图上当前的所有增广路径
 * color[] 节点的颜色,用以判断该节点是否可以作为起点
 *
 * ***以下两个变量是寻求增广路径需要的***
 * visited[] 该节点再一次寻找增广路径的过程中是否遍历过(BFS中该数组还能记住上一节点位置)
 * need[] 该节点需要红色边还是黑色边(红遍代表匹配边,黑边代表非匹配边,DFS中该数组用参数代替)
 */
public class BipartiteGraph {

    public int[][] graph;
    public int len;

    public int[] color;

    public BipartiteGraph(int[][] graph) {
        this.graph = graph;
        this.len = graph.length;
    }
    /**
     * 判断一个图是否为二分图
     * BFS方法
     */
    public boolean isBipartiteGraph() {
        this.color=new int[len];

        for (int i = 0; i < len; i++) {
//            if (color[i] == 0 && !dfs(i, len, 1)) {//遍历各个连通分支
            if (color[i] == 0 && !bfs(i, len, 1)) {//遍历各个连通分支
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int s, int len,int col) {
        color[s]=col;
        for(int i=0;i<len;i++){
            if(graph[s][i]>0 && color[i]==color[s]) return false;
            if(graph[s][i]>0 && color[i]==0 && !dfs(i,len,-col)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int s, int len,int col) { //col参数不是必须的,用以标记第一个点的颜色
        Queue<Integer> p = new ArrayDeque<Integer>();
        p.add(s);
        color[s] =col;
        while(!p.isEmpty()) {
            int from =p.poll();
            for(int i = 0; i < len; i++) {
                if(graph[from][i]>0 && color[i] == 0) {
                    p.add(i);
                    color[i] = -color[from];//染成不同的颜色
                }
                if(graph[from][i]>0 && color[from] == color[i])//颜色有相同，则不是二分图
                    return false;
            }
        }
        return true;
    }

    public int[][] graph_col;//定义二分图中的所有线段颜色,某些情况下可以直接在graph上做标记(使用+1和-1),1为匹配线
    public int visited[];


    /**
     * 查找二分图的最大匹配
     * 注意DFS和BFS中visited不同数字含义不同
     */
    public int[][] getMaxPairs(){
        this.graph_col = new int[len][len];
        this.color=new int[len];
        this.visited = new int[len];//记录一次查找增广路时DFS经过的节点,避免无限循环,可以与color公用(不直观)

        while(true){
            int i=0;
//            while(i<len &&(color[i]!=0 ||(color[i]==0 && !dfs_paris(i,0)))){
            while(i<len &&(color[i]!=0 ||(color[i]==0 && !bfs_paris(i)))){
                i++; //此时color[i]=0表示未匹配点 1为匹配点,不存在-1
            }
            if(i<len){  //DFS需要
                color[i]=1;
            }
            if(i==len){//完成搜索输出结果
                return graph_col;
            }
        }
    }

    /**
     * 需要为二分图才能正确运算出结果
     * @param s
     * @return
     */
    private boolean bfs_paris(int s) {
        Arrays.fill(visited,-1); //visit[i]存储当前增广路径节点的上一节点,-1为不存在
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.offer(s);
        int[] need = new int[len];//need[i]表示以该节点为起点需要的线段颜色
        need[s]=0; //第一次需要黑色边

        while(!q.isEmpty()){
            int from = q.poll();
            if(need[from]==1 && color[from]==0){//需要一条红色边,找到了增广路径
                color[from]=1;
                int temp=from;
                while(visited[temp]!=-1){
                    graph_col[visited[temp]][temp]=1-need[visited[temp]];
                    graph_col[temp][visited[temp]]=1-need[visited[temp]];
                    temp=visited[temp];
                }
                color[temp]=1;
                return true;
            }
            for(int i=0;i<len;i++){//这段代码无法判断奇数边的情况,因此使用该算法必须保证图为二分图
                if(visited[i]==-1 && graph[from][i]>0 && graph_col[from][i]==need[from]){
                    q.add(i);
                    visited[i]=from;
                    need[i]=1-need[from];
                }
            }
        }
        return false;
    }

    private boolean dfs_paris(int s,int col) {
        visited[s]=1;
        for(int i=0;i<len;i++){
            if(graph[s][i]>0 && graph_col[s][i]==col && visited[i]==0){
                if(dfs_paris(i,1-col)){
                    graph_col[s][i]=1-col;
                    graph_col[i][s]=1-col;
                    visited[s]=0;
                    return true;
                }
            }
        }
        if(col==1 && color[s]==0){//找到了增广路径
            color[s]=1;
            visited[s]=0;
            return true;
        }
        visited[s]=0;
        return false;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,0,0,1,1,0},
                {0,0,0,0,0,1},
                {0,0,0,1,0,0},
                {1,0,1,0,0,0},
                {1,0,0,0,0,0},
                {0,1,0,0,0,0}};
//        int[][]graph = new int[][]{
//                {0,1,0,1,0},
//                {1,0,1,0,0},
//                {0,1,0,1,1},
//                {1,0,1,0,0},
//                {0,0,1,0,0}};
        BipartiteGraph bipartiteGraph = new BipartiteGraph(graph);
        System.out.println(bipartiteGraph.isBipartiteGraph());


        int[][] res = bipartiteGraph.getMaxPairs();
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res.length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
