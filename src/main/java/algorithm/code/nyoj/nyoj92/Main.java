package algorithm.code.nyoj.nyoj92;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *  优化建议:
 *  使用ArrayDeque 而不是LinkedList
 *  使用静态变量(多次测试省内存)
 *  BFS中入队时置0!!!(出队时置0会超内存,因为队列中会存在相同的元素)
 */
public class Main {

    public static short pic[][] = new short[1443][1443];
    public static int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    static int M,N;
    public static Queue<Integer> queue = new ArrayDeque<Integer>();
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int nums=(int)st.nval;
        for(int i=0;i<nums;i++){
            everyTest(st);
        }
    }

    private static void everyTest(StreamTokenizer st) throws IOException {
        st.nextToken();
        N=(int)st.nval;
        st.nextToken();
        M=(int)st.nval;

        for(int j=0;j<=N+1;j++){
            pic[0][j]=1;
            pic[M+1][j]=1;
        }
        for(int i=1;i<=M;i++){
            for(int j=0;j<=N+1;j++){
                if(j==0||j==N+1) pic[i][j]=1;
                else{
                    st.nextToken();
                    pic[i][j]=(short)st.nval;
                }
            }
        }
        solution();
    }

    private static void solution() {
        queue.clear();
        bfs(0,0);
        for(int a = 1;a<=M;a++){
            for(int b=1;b<=N;b++){
                System.out.print(pic[a][b]);
                if(b!=N){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static void bfs(int a, int b) {
        queue.add(a);
        queue.add(b);
        while(!queue.isEmpty()) {
            int i = queue.poll();
            int j = queue.poll();
            pic[i][j] = 0;
            for (int p = 0; p < 4; p++) {
                int x = i + dir[p][0];
                int y = j + dir[p][1];
                if (x < 0 || y < 0 || x >  M+ 1 || y > N + 1 || pic[x][y] == 0)
                    continue;
                queue.add(x);
                queue.add(y);
            }
        }
    }
}
