package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L412 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String str = "";
            if (i % 3 == 0) {
                str = "Fizz";
            }
            if (i % 5 == 0) {
                str += "Buzz";
            }
            if (str.isEmpty()) str = String.valueOf(i);
            list.add(str);
        }
        return list;
    }
}
