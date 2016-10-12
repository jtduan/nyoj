package algorithm.code.nyoj.nyoj207;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 0: 同类
 * 2：子吃父
 * 1: 父吃子
 */
public class Main {

    private int[] set; //联通关系
    private int[] priority; //父子关系（权值）

    public Main(int n) {
        set = new int[n];
        priority = new int[n];
        for (int i = 0; i < n; ++i) {
            set[i] = i;
            priority[i] = 0;
        }
    }

    public void union(int p, int q, int _priority) {
        int x = find(p);
        int y = find(q);
        set[x] = y;
        priority[x] = (_priority + priority[q] - priority[p] + 3) % 3;
    }

    public int find(int p) {
        if (p == set[p]) {
            return p;
        }
        int root = find(set[p]);
        priority[p] = (priority[p] + priority[set[p]]) % 3;
        set[p] = root;
        return root;
    }

    public int relation(int p, int q) {
        return (priority[p] - priority[q] + 3) % 3;
    }
    public void print(){
        for(int j=0;j<set.length;j++){
            System.out.print(set[j]+" ");
        }
        System.out.println();
        for(int j=0;j<priority.length;j++){
            System.out.print(priority[j]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj207.txt"), "utf8");
        cin = new Scanner(System.in);

        int N = cin.nextInt();
        int K = cin.nextInt();

        int wrong = 0;
        Main ufs = new Main(N + 1);
        for (int i = 1; i <= K; i++) {
            int D = cin.nextInt();
            int X = cin.nextInt();
            int Y = cin.nextInt();
            if (X > N || Y > N) {
                wrong++;
                continue;
            }
            if (D == 1) {
                if (ufs.find(X) != ufs.find(Y)) {
                    ufs.union(X, Y, 0);
                    continue;
                } else if (ufs.relation(X, Y) != 0) {
                    wrong++;
                }
            }
            if (D == 2) {
                if (ufs.find(X) != ufs.find(Y)) {
                    ufs.union(X, Y, 2);
                    continue;
                } else if (ufs.relation(X, Y) != 2) {
                    wrong++;
                }
            }
        }
        System.out.println(wrong);
    }
}