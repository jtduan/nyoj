package algorithm.code.hihocoder.hc___00;

import java.util.*;

/**
 * @author jtduan
 * @date 2016/11/22
 * hihoCoder太阁最新面经算法竞赛15
 * 难度：1
 */
public class Main {

    public static void main(String[] args) {

        Scanner cin = null;
        cin = new Scanner(System.in);
        int N = cin.nextInt();
        String[][] strs = new String[N][2];
        cin.nextLine();
        for (int i = 0; i < N; i++) {
            String line = cin.nextLine();
            strs[i] = line.split(" ");
        }
        f(strs);
    }

    private static void f(String[][] strs) {
        String start = "";
        String end = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(strs[i][0], map.getOrDefault(strs[i][0], 0) + 1);
        }
        for (int i = 0; i < strs.length; i++) {
            if (map.get(strs[i][1]) == null) {
                end = strs[i][1];
                continue;
            }
            map.put(strs[i][1], map.get(strs[i][1]) - 1);
            if (map.get(strs[i][1]) == 0) map.remove(strs[i][1]);
        }
        start = map.entrySet().iterator().next().getKey();
        System.out.println(start + " " + end);
    }
}
