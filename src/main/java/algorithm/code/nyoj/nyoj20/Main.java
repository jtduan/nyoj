package algorithm.code.nyoj.nyoj20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  nyoj模板代码
 */
public class Main {
    public static int prev[];
    public static StringBuilder[] graph;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj20.txt"),"utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }

    }
    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int S = cin.nextInt();
        prev = new int[N+1];
        Arrays.fill(prev,-1);
        prev[S]=S;
        graph = new StringBuilder[N+1];
        for(int i=0;i<N-1;i++){
            int a = cin.nextInt();
            int b = cin.nextInt();
            if(graph[a]==null){
                graph[a]=new StringBuilder();
            }
            if(graph[b]==null){
                graph[b]=new StringBuilder();
            }
            graph[a].append(b).append(";");
            graph[b].append(a).append(";");
        }
        dfs(S);
        prev[S]=-1;
        for(int i=1;i<N;i++){
            System.out.print(prev[i]+" ");
        }
        System.out.println(prev[N]);
    }

    private static void dfs(int s) {
        for(String str:graph[s].toString().split(";")){
            int num =Integer.parseInt(str);
            if(prev[num]==-1){
                prev[num]=s;
                dfs(num);
            }
        }
    }
}