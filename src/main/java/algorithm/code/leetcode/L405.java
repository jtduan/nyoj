package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L405 {
    public String toHex(int num) {
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        for (int i = 28; i >= 0; i -= 4) {
            int res = 0;
            for (int j = 0; j <= 3; j++) {
                if ((num >> (i + j) & 1) == 1) res += 1 << j;
            }
            if (sb.length() != 0 || res != 0) sb.append(chars[res]);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new L405().toHex(-1));
    }
}
