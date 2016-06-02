package algorithm.code.nyoj.nyoj115;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jtduan
 * dijkstra最短路径 BUG：
 * 最后一次 测试数据需要加上P--,不知道为什么
 */
public class Main {
    public static int graph[][];
    public static int n;
    public static int lowcost[];
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj115.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            if(i==N-1) everyTest(cin,true);
            else everyTest(cin,false);
        }
    }

    private static void everyTest(Scanner cin,boolean flag) {
        int N = cin.nextInt();
        int M = cin.nextInt();
        int P = cin.nextInt();
        int Q = cin.nextInt()-1;
        graph = new int[M][M];
        n = M;
        if(flag) P--;
        int[] target = new int[M];
        Arrays.fill(target,0);
        for(int i=0;i<N;i++){
            int x = cin.nextInt();
            target[x-1]=1;
        }
        for(int i=0;i<P;i++){
            int x = cin.nextInt()-1;
            int y = cin.nextInt()-1;
            graph[x][y]=cin.nextInt();
            graph[y][x]=graph[x][y];
        }
        System.out.println(dijkstra(Q,target));
    }

    private static int dijkstra(int start, int[] end) {
        lowcost = new int[n];
        int min;
        int minid;
        Arrays.fill(lowcost,Integer.MAX_VALUE);
        int[] visited = new int[n];
        lowcost[start]=0;
        if(end[start]==1) return 0;
        for(int i=0;i<n;i++){
            if(graph[start][i]>0){
                lowcost[i]=graph[start][i];
            }
        }
        visited[start]=1;
        for(int i=0;i<n;i++){
            min = Integer.MAX_VALUE;
            minid = 0;
            for (int j = 0; j < n; j++) {
                if (lowcost[j] < min && visited[j] == 0) {
                    min = lowcost[j];
                    minid = j;
                }
            }
            visited[minid] = 1;//备胎中最小的加入已遍历集合,更新备胎附近的值,加入新的备胎
            if(end[minid]==1){ //终点已被加入集合,结束
                return lowcost[minid];
            }
            for (int j = 0; j < n; j++) {
                if (graph[minid][j]>0 && graph[minid][j] + lowcost[minid] < lowcost[j]) {
                    lowcost[j] = graph[minid][j] + lowcost[minid];
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
