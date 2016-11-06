package algorithm.code.leetcode;

import java.util.BitSet;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L204 {
    public int countPrimes(int n) {
        BitSet set = new BitSet(n);
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (set.get(i)) continue;
            else {
                res++;
                fillBits(set, i);
            }
        }
        return res;
    }

    private void fillBits(BitSet set, int i) {
        int temp = 2 * i;
        while (temp < set.size()) {
            set.set(temp);
            temp += i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L204().countPrimes(7));
    }
}
