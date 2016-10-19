package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注意：
 * 某一种思路 编码较为复杂时，注意变换编码方式(回溯变分治，循环变递归)
 * @author jtduan
 * @date 2016/10/18
 * 一开始将list作为属性，报ConcurrentModifiedException
 * 2个嵌套的diffWaysToCompute()函数均返回属性list,肯定会有问题~
 */
public class L241 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }
        if (input.matches("[0-9]+")) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(Integer.parseInt(input));
            return temp;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') {
                List<Integer> list_left = diffWaysToCompute(input.substring(0, i));
                List<Integer> list_right = diffWaysToCompute(input.substring(i + 1));
                for (int left : list_left) {
                    for (int right : list_right) {
                        list.add(left + right);
                    }
                }
            }

            if (input.charAt(i) == '*') {
                List<Integer> list_left = diffWaysToCompute(input.substring(0, i));
                List<Integer> list_right = diffWaysToCompute(input.substring(i + 1));
                for (int left : list_left) {
                    for (int right : list_right) {
                        list.add(left * right);
                    }
                }
            }

            if (input.charAt(i) == '-') {
                List<Integer> list_left = diffWaysToCompute(input.substring(0, i));
                List<Integer> list_right = diffWaysToCompute(input.substring(i + 1));
                for (int left : list_left) {
                    for (int right : list_right) {
                        list.add(left - right);
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> l = new L241().diffWaysToCompute("2*3*4");
        for (int i : l) {
            System.out.println(i);
        }
    }
}
