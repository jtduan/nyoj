package algorithm.code.nyoj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author jtduan
 * @date 2016/11/3
 */
public class MinimumSub {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/minimumsub.txt"), "utf8");
        cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int len = cin.nextInt();
            int num[] = new int[len];
            for (int i = 0; i < len; i++) {
                num[i] = cin.nextInt();
            }
            int[] res = f(num);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    private static int[] f(int[] num) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 1; i < num.length; i++) {
            if (num[i] - num[i - 1] < min) {
                min = num[i] - num[i - 1];
                res[0] = num[i - 1];
                res[1] = num[i];
            }
        }
        return res;
    }
}
