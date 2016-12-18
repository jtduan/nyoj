package algorithm.code.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jtduan
 * @date 2016/12/5
 */
public class L233 {
    public int countDigitOne(int n) {
        int res = 0;
        int len = getLen(n);
        for (int i = len; i >= 1; i--) {
            int left = getLeft(n, i);
            int cur = getCur(n, i);
            int right = getRight(n, i);
            if (cur > 1) {
                res += Math.pow(10, i - 1) * (left + 1);
            } else if (cur == 1) {
                res += Math.pow(10, i - 1) * left + right + 1;
            } else {
                res += left * Math.pow(10, i - 1);
            }
        }
        return res;
    }

    private int getLeft(int n, int i) {
        return (int) (n / Math.pow(10, i));
    }

    private int getRight(int n, int i) {
        return (int) (n % Math.pow(10, i - 1));
    }

    private int getCur(int n, int i) {
        return (int) ((n / Math.pow(10, i - 1)) % 10);
    }

    private int getLen(int n) {
        int len = 0;
        while (n != 0) {
            n = n / 10;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new L233().countDigitOne(10));
    }
}
