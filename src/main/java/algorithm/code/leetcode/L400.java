package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/21
 */
public class L400 {
    public int findNthDigit(int n) {
        int cur = 1;
        int num = 1;
        while ((long)cur + (long)9 * num * bits(num)-1 < (long)n) {
            cur = cur + 9 * num * bits(num);
            num = num * 10;
        }
        int res_num = num + (n - cur) / bits(num);
        int bits = bits(num) - (n - cur) % bits(num);
        return (res_num / (int) Math.pow(10, bits - 1)) % 10;
    }

    private int bits(int num) {
        int bits = 0;
        while (num != 0) {
            num = num / 10;
            bits++;
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(new L400().findNthDigit(1000000000));
    }
}
