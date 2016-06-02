package algorithm.code.nyoj.nyoj120;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author jtduan
 * 强连通分量
 * 添加最少的线使之成为强连通图
 * 判断每个强连通分量对外的入度和出度为0 的个数
 * 找到最大的，就是需要添加的线段数（只有一个强连通分量除外）
 */
public class Main {
    public static int[][] graph;
    public static int n;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj120.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int M =cin.nextInt();
        graph = new int[M][M];
        for(int i=0;i<M;i++){
            int j;
            while((j = cin.nextInt())!=0){
                graph[i][j - 1] = 1;
            }
        }
//        graph[0][3] = 0;
//        graph[3][0] = 1;
        System.out.println(getStrongConnectedComponent());
    }


    /**
     * 有向图求强连通分量
     * 采用Targan算法
     * Kosaraju算法更易懂
     */

    public static Stack<Integer> stack;
    public static int[] visited;
    public static int[] low;
    public static int[] dfn;
    public static int[] root;

    public static int[] in;
    public static int[] out;
    public static int res=0;

    public static int getStrongConnectedComponent() {
        n = graph.length;
        stack = new Stack<Integer>();
        visited = new int[n];//0代表未访问,1代表在栈中,-1代表已出栈
        low = new int[n];
        dfn= new int[n];
        root = new int[n];
        in = new int[n];
        out = new int[n];
        res=0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j]>0 && root[i]!=root[j]){
                    in[root[j]]++;
                    out[root[i]]++;
                }
            }
        }
        int in_num=res;
        int out_num=res;
        for(int i=0;i<res;i++) {
            if(in[i]!=0) in_num--;
            if(out[i]!=0) out_num--;
        }
        if(res==1) return 0;
        return Math.max(in_num,out_num);
    }

    private static void dfs(int s) {
        stack.push(s);
        visited[s]=1;
        low[s]=stack.size();
        dfn[s]=stack.size();
        for (int j = 0; j < n; j++) {
            if (graph[s][j] > 0 && visited[j] == 0) {
                dfs(j);
            }
            else if (graph[s][j] > 0 && visited[j] == 1) {
                low[s]=Math.min(dfn[j],low[s]);
            }
        }
        if(low[s]>low[stack.peek()])low[s]=low[stack.peek()];
        if(dfn[s]==low[s]){
            while(stack.size()>=low[s]) {
                int temp =stack.pop();
                visited[temp]=-1;
                root[temp]=res;
            }
            res++;
        }
    }
}
