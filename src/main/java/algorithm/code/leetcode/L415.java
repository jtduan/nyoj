package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/26
 */
public class L415 {
    public String addStrings(String num1, String num2) {
        int f = 0;
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        for (int i = 0; i < num1.length(); i++) {
            int sum = num1.charAt(i) - '0' + num2.charAt(i) - '0' + f;
            sb.append(sum % 10);
            f = sum / 10;
        }
        for (int i = num1.length(); i < num2.length(); i++) {
            int sum = num2.charAt(i) - '0' + f;
            sb.append(sum % 10);
            f = sum / 10;
        }
        if (f > 0) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
