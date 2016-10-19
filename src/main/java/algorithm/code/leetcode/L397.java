package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/17
 * 边界条件判断：Integer.MAX_VALUE
 */
public class L397 {
    public int integerReplacement(int n) {
        return func(n);
    }

    public int func(long n) {
        if(n==1) return 0;

        if (n % 2 == 0) {
            return func(n / 2) + 1;
        } else {
            return Math.min(func(n + 1), func(n - 1)) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new L397().integerReplacement(8));
        System.out.println(new L397().integerReplacement(2147483647));
        System.out.println(new L397().integerReplacement(255));
    }
}
