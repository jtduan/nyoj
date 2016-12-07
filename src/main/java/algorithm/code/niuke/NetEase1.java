package algorithm.code.niuke;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 网易2017秋招 【回文序列】
 * 难度：2
 * 如果一个数字序列逆置之后跟原序列是一样的就称这样的数字序列为回文序列。例如：
 * {1, 2, 1}, {15, 78, 78, 15} , {112} 是回文序列,
 * {1, 2, 2}, {15, 78, 87, 51} ,{112, 2, 11} 不是回文序列。
 * 现在给出一个数字序列，允许使用一种转换操作：
 * 选择任意两个相邻的数，然后从序列移除这两个数，并用这两个数字的和插入到这两个数之前的位置(只插入一个和)。
 * 现在对于所给序列要求出最少需要多少次操作可以将其变成回文序列。
 */
public class NetEase1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int num[] = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = cin.nextInt();
        }
        System.out.println(solution(num));
    }

    private static int solution(int[] num) {
        if (num.length <= 1) return 0;
        int l = 0;
        int r = num.length - 1;
        int sum_l = num[l];
        int sum_r = num[r];
        int res = 0;
        while (sum_l != sum_r && l < r) {
            if (sum_l > sum_r) {
                sum_r += num[--r];
            } else {
                sum_l += num[++l];
            }
            res++;
        }
        if (l >= r) {
            return res;
        }

        return res + solution(Arrays.copyOfRange(num, l + 1, r));
    }
}
