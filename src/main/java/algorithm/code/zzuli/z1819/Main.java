package algorithm.code.zzuli.z1819;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int NUM = cin.nextInt();
        while (NUM-- > 0) {
            int n = cin.nextInt();
            int a = cin.nextInt();
            int b = cin.nextInt();
            int m = cin.nextInt();
            String[] res = solution(n, a, b, m);
            if(res.length>=1)System.out.print(res[0]);
            for(int i=1;i<res.length;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }

    private static String[] solution(int n, int a, int b, int m) {
        int start = Math.max(a, b);
        int[] flag = new int[start * (m + 1) + 1];
        flag[start] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = flag.length - 1; j >= start; j--) {
                if (flag[j - a] == 1 || flag[j - b] == 1) flag[j] = 1;
            }
        }
        String[] res = new String[start * m + 1];
        int j = 0;
        for (int i = start; i < flag.length; i++) {
            if (flag[i] == 1) res[j++] = String.valueOf(i + n - start);
        }
        return Arrays.copyOfRange(res, 0, j);
    }

}
