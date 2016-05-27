package algorithm.code.graph;

/**
 * 欧拉回路
 * 欧拉路径
 */
public class Euler {
    public static int[][] map;
    public static boolean[][] vis;


    public static int[] path;
    public static int len_path=0;

    public Euler(int n) {
        map=new int[n][n];
        vis=new boolean[n][n];
    }

    public Euler(int[][] graph) {
        int n = graph.length;
        map=new int[n][n];
        vis=new boolean[n][n];
        path = new int [500];
        len_path =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j]=graph[i][j];
            }
        }
    }

    /**
     * 有向图和无向图判断是否存在欧拉回路
     * @param graph
     * @param directed
     * @return
     */
    public static boolean hasEulerCircle(int[][] graph,boolean directed){
        if(!MinimumSpanningTree.isConnectedGraph(graph))return false;
        int len=graph.length;
        int degree[] = new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(graph[i][j]!=0 &&graph[i][j]!=Integer.MAX_VALUE){
                    degree[i]+=1;
                    if(directed)degree[j]-=1;
                    else degree[j]+=1;
                }
            }
        }
        if(directed) {
            for (int i = 0; i < len; i++) {
                if(degree[1]!=0) return false;
            }
            return true;
        }
        for (int i = 0; i < len; i++) {
            if((degree[i]&1) == 1) return false;
        }
        return true;
    }
    public static boolean hasEulerLine(int[][] graph,boolean directed){
        if(!MinimumSpanningTree.isConnectedGraph(graph))return false;
        int len=graph.length;
        int degree[] = new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(graph[i][j]!=0 &&graph[i][j]!=Integer.MAX_VALUE){
                    degree[i]+=1;
                    if(directed)degree[j]-=1;
                    else degree[j]+=1;
                }
            }
        }
        if(directed) {
            int num_1 = 0;
            int num__1 = 0;
            for (int i = 0; i < len; i++) {
                if (degree[i] == 1) num_1++;
                if (degree[i] == -1) num__1++;
            }
            if(num_1==1 && num__1==1) return true;
            return false;
        }
        int num_odd=0;
        for (int i = 0; i < len; i++) {
            if((degree[i]&1)==0)num_odd++;
        }
        if(num_odd==2||num_odd==0) return true;
        return false;
    }

    /**
     * 输出欧拉回路或欧拉路径
     * @param graph
     * @return
     */
    public static int[] printEuler(int[][] graph){
        Euler e = new Euler(graph);
        e.euler(0);
        path[len_path++] = 0;
        return path;
    }
    void euler(int u)
    {
        for(int v=0;v<map.length;v++) //当需要按某一顺序排序输出时，修改该for循环的遍历条件
        {
            if(map[u][v]!=0 && !vis[u][v])  //map[u][v]存储该边的权重用以顺序输出
            {
                vis[u][v] = vis[v][u] = true;//如果是有向图的只需判断一个
                euler(v);
//                System.out.printf("%d %d\n",u,v);
                path[len_path++]=v;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,2,3,10,2},
                {2,0,2,1,5},
                {3,2,0,8,5},
                {10,1,8,0,1},
                {2,5,5,1,0},
        };

        int[] res = Euler.printEuler(graph);
        for(int i=Euler.len_path-1;i>=0;i--){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
