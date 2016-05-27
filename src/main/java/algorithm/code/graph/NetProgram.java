package algorithm.code.graph;

/**
 * Created by hero on 2016/5/27.
 */
public class NetProgram {
    public static int num = 0;//标记输出队列
    public static int match[];//标志节点的度，无向图，不区分入度和出度
    public static int[][] graph;
    public static int[] res;

    public NetProgram(int[][] graph) {
        int n = graph.length;
        this.graph = graph;
        res = new int[500];
        match = new int[n];
        num=0;
    }

    /**
     * 输出欧拉路径
     * @param graph
     * @return
     */
    public static int[] printEuler(int[][] graph){
        NetProgram pro =  new NetProgram(graph);
        int len = graph.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(graph[i][j]!=0){
                    match[i]++;
                    match[j]++;
                }
            }
        }
        pro.solve(0);
        return res;
    }
    private static void solve(int x) {
        if (match[x] == 0)
            res[num++] = x;
        else {
            for (int k = 0; k < graph.length; k++) {
                if (graph[x][k] != 0) {
                    graph[x][k]=0;
                    graph[k][x]=0;
                    match[x]--;
                    match[k]--;
                    solve(k);
                }
            }
            res[num++] = x;
        }
    }
}
