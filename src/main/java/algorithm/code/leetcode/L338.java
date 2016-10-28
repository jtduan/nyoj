package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) res[i] = res[i - 1] + 1;
            else {
                res[i] = res[i - 1] + 1;
                int temp = i - 1;
                while ((temp & 1) == 1) {
                    res[i]--;
                    temp = temp >> 1;
                }
            }
        }
        return res;
    }
}
