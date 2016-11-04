package algorithm.code.leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jtduan
 * @date 2016/11/4
 */
public class L401 {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            List<Integer> hours = getHour(i, 3);
            List<Integer> minutes = getMinutes(num - i, 5);
            for (Integer hour : hours) {
                for (Integer minute : minutes) {
                    res.add(hour + ":" + String.format("%02d",minute));
                }
            }
        }
        return res;
    }

    private List<Integer> getMinutes(int i, int len) {
        if (i > len + 1) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        if (i == 0) {
            res.add(0);
            return res;
        }
        List<Integer> list = getMinutes(i - 1, len - 1);
        for (int hour : list) {
            if ((hour + (1 << len)) < 60) res.add(hour + (1 << len));
        }
        res.addAll(getMinutes(i, len - 1));
        return res;

    }

    private List<Integer> getHour(int i, int len) {
        if (i > len + 1) return Collections.emptyList();
        List<Integer> res = new ArrayList<>();
        if (i == 0) {
            res.add(0);
            return res;
        }
        List<Integer> list = getHour(i - 1, len - 1);
        for (int hour : list) {
            if ((hour + (1 << len)) < 12) res.add(hour + (1 << len));
        }
        res.addAll(getHour(i, len - 1));
        return res;
    }

    public static void main(String[] args) {
        List<String> strs = new L401().readBinaryWatch(7);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
