package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L440 {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        while(k > 0) {
            if(1 == k) return cur;
            int sum = calc(n, cur);
            if(k > sum) {
                k -= sum;
                cur = cur + 1;
            }
            else {
                k --;
                cur = cur * 10;
            }
        }
        return cur;
    }
    int calc(int n, int cur) {
        int ans = 0, t = 1;
        while(cur <= n) {
            if(cur + t - 1 <= n) ans += t;
            else ans += n - cur + 1;
            cur *= 10;
            t *= 10;
        }
        return ans;
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
        System.out.println(new L440().calc(12, 1));
    }
}
