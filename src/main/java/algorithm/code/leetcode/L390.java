package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L390 {
    public int lastRemaining(int n) {
        int leftest = 1;
        int distance = 1;
        boolean direction = true;
        while (n > 1) {
            if ((n & 1) == 1 || ((n & 1) == 0 && direction)) {
                leftest += distance;
            }
            direction = !direction;
            n = n >> 1;
            distance = distance << 1;
        }
        return leftest;
    }

    public static void main(String[] args) {
        System.out.println(new L390().lastRemaining(5));
    }
}
