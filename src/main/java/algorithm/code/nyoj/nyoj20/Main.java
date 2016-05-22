package algorithm.code.nyoj.nyoj20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  nyoj模板代码
 */
public class Main {
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
        int a,b;
        int M = cin.nextInt();
        int S = cin.nextInt();
        int[] origin = new int[M+1];
        int[] pre = new int [M+1];
        int[] next = new int [M+1];
        int[] res = new int[M+1];
        for(int i=1;i<M;i++) {
            a = cin.nextInt();
            b = cin.nextInt();
            if (a > b) {
                pre[a] = b;
                next[b] = a;
            } else {
                pre[b] = a;
                next[a] = b;
            }
        }

        for(int i=1;i<=M;i++){
            System.out.print(pre[i]+" ");
        }
        System.out.println();

        for(int i=1;i<=M;i++){
            System.out.print(next[i]+" ");
        }
        System.out.println();

        int p=S;
        while(pre[p]!=0){
            res[pre[p]]=p;
            p=pre[p];
        }
        int q=S;
        while(next[q]!=0){
            res[next[q]]=q;
            q=next[q];
        }
        res[S]=-1;
        for(int i=1;i<=M;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
