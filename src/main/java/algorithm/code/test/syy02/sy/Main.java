package algorithm.code.test.syy02.sy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/sy01.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int p = 0; p < N; p++) {
            int M = cin.nextInt();
            Node node[] = new Node[M];
            for (int i = 0; i < M; i++) {
                node[i] = new Node(cin.nextInt(), cin.nextInt(), -cin.nextInt() + cin.nextInt());
            }
            System.out.println(solution(node));
        }
    }

    private static int solution(Node[] nodes) {
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.E - o2.E;
            }
        });
        int[] res = new int[53];
        for (int i = 0; i < 53; i++) {
            if (i > 0) res[i] = res[i - 1];
            for (Node node : nodes) {
                if (node.E == i) {
                    if (node.S == 0) {
                        res[i] = Math.max(res[i], Math.max(0, node.val));
                    } else {
                        res[i] = Math.max(res[i], res[node.S - 1] + Math.max(0, node.val));
                    }
                }
            }
        }
        return res[52];
    }
}

class Node {
    int S;
    int E;
    int val;

    public Node(int s, int e, int val) {
        S = s;
        E = e;
        this.val = val;
    }
}