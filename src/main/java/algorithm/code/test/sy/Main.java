package algorithm.code.test.sy;

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
            Policy[] policies = new Policy[M];
            for (int i = 0; i < M; i++) {
                policies[i] = new Policy(cin.nextInt(), cin.nextInt(), cin.nextInt());
            }
            Arrays.sort(policies, new Comparator<Policy>() {
                @Override
                public int compare(Policy o1, Policy o2) {
                    if (o1.I * o2.D == o2.I * o1.D) return o1.index - o2.index;
                    return o2.I * o1.D - o1.I * o2.D;
                }
            });

            int day = 0;
            int Is = 0;
            for (int i = 0, len = policies.length; i < len; i++) {
                day += policies[i].D;
                Is += day * policies[i].I;
                if (i < len - 1) {
                    System.out.print(policies[i].index + " ");
                } else {
                    System.out.println(policies[i].index);
                }
            }
            System.out.println(Is);
        }
    }
}

class Policy {
    int index;
    int I;
    int D;

    public Policy(int index, int i, int d) {
        this.index = index;
        I = i;
        D = d;
    }
}
