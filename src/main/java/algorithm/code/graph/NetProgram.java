package algorithm.code.graph;

import java.util.Arrays;

/**
 * Created by hero on 2016/5/27.
 */
public class NetProgram {
    public static int num = 0;//标记输出队列
    public static int match[];//标志节点的度，无向图，不区分入度和出度
    public static int[][] graph;
    public static int[] res;
    public static int len;

    public NetProgram(int[][] graph) {
        this.len = graph.length;
        this.graph = graph;
        res = new int[500];
        match = new int[len];
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

    /**
     * 哈密顿回路
     * 该算法在不存在hamiton回路时会报错
     */
    public static int[] hamilton(int[][] graph){
        NetProgram pro =  new NetProgram(graph);
        int k;
        boolean[] s=new boolean[len];
        for(int i = 0; i < len; i++){
            res[i] = -1;
            s[i] = false;
        }
        k = 1;
        s[0] = true;
        res[0] = 0;
        while(k >= 0){
            res[k]++;
            while(res[k] < len){
                if(!s[res[k]] && graph[res[k - 1]][res[k]]>0)
                    break;
                else
                    res[k]++;
            }
            if((res[k] < len) && (k != len - 1)){
                s[res[k++]] = true;
            }
            else if((res[k] < len) && k == len - 1 && graph[res[k]][res[0]]>0)
                return Arrays.copyOf(res,len);
            else{
                res[k] = -1;
                k--;
                s[res[k]] = false;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0,1,1,2,2},
                {1,0,0,0,1},
                {1,0,0,1,1},
                {2,0,1,0,1},
                {2,1,1,1,0}};
        int [] res =NetProgram.hamilton(graph);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
