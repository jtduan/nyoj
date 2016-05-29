package algorithm.code.nyoj.nyoj20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  nyoj模板代码
 */
public class Main2 {
    public static int prev[];
    public static Node[] nodes;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj20.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int S = cin.nextInt();
        prev=new int[N+1];
        Arrays.fill(prev,-1);
        prev[S]=S;
        nodes = new Node[N+1];
        for (int i = 0; i < N - 1; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            Node node = new Node(a);
            node.next=nodes[b];
            nodes[b]=node;

            Node node2 = new Node(b);
            node2.next=nodes[a];
            nodes[a]=node2;
        }
        dfs(S);
        prev[S]=-1;
        for(int i=1;i<N;i++){
            System.out.print(prev[i]+" ");
        }
        System.out.println(prev[N]);
    }

    private static void dfs(int s) {
        while(nodes[s]!=null){
            if(prev[nodes[s].val]==-1) {
                prev[nodes[s].val] = s;
                dfs(nodes[s].val);
            }
            nodes[s]=nodes[s].next;
        }
    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        next=null;
    }
}