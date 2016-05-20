package algorithm.code.nyoj.nyoj2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 忘记判断 弹出栈时 栈为空的情况
 * time:118
 * memery:826
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj2.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        String str = cin.nextLine();
        for(int p=0;p < N;p++) {
            str = cin.nextLine();
            System.out.println(solution(str));
        }
    }

    private static String solution(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[') stack.push(str.charAt(i));
            else if ( str.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return "No";
            } else if (str.charAt(i) == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return "No";
            }
        }
        if (stack.isEmpty()) return "Yes";
        return "No";
    }
}
