package algorithm.code.test.sy02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> list;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/sy02.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int p = 0; p < N; p++) {
            int M = cin.nextInt();
            cin.nextLine();
            String begin = cin.nextLine();
            String end = cin.nextLine();
            list = new ArrayList<String>();
            solution(begin.toCharArray(), end.toCharArray());
            System.out.println(list.size() - 1);
            for (String str : list) {
                System.out.println(str);
            }
        }
    }

    private static void solution(char[] state, char[] end) {
        list.add(String.valueOf(state));
        for (int i = state.length - 1; i >= 0; i--) {
            if (state[i] != end[i]) changeState(state, i);
        }
    }

    private static void changeState(char[] state, int index) {
        if (index >= 1) {
            if (state[index - 1] == 'D') {
                changeState(state, index - 1);
            }
            for (int i = index - 2; i >= 0; i--) {
                if (state[i] == 'L') changeState(state, i);
            }
        }
        state[index] = state[index] == 'D' ? 'L' : 'D';
        list.add(String.valueOf(state));
    }
}
