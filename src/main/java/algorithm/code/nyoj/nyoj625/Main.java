package algorithm.code.nyoj.nyoj625;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 多参数动态规划
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj625.txt"), "utf8");
        cin= new Scanner(System.in);
        while (cin.hasNext()) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int num[] = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = cin.nextInt();
        }
        solution(num, N);
    }

    private static void solution(int[] num, int n) {
        int[] before = new int[n + 1];
        int[] after = new int[n + 1];
        int mark = -1;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += num[i];
            if (before[i + 1] > num[i] + after[i + 1]) {
                before[i] = before[i + 1];
            } else {
                before[i] = num[i] + after[i + 1];
                mark = i + 1;
            }
            if (mark > 0) after[i] = before[mark];
        }

        System.out.println(before[0] + " " + after[0] + " " + (sum - before[0] - after[0]));
    }
}
