package algorithm.code.nyoj.nyoj448;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 * 连续和 最接近0 的值(nlogn)
 * 连续和 最远离0 的值
 * 注意:num[j]-num[i]是i,j之间连续和不含i,因此还需要num[j]-0参与最小值比较
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj448.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        String str = cin.nextLine();
        String[] num = str.split(" ");

        solution(num);

    }

    private static void solution(String[] str) {
        char nums[] = str[0].toCharArray();
        int p = Integer.parseInt(str[1]);

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i] && p > 0) {
                stack.pop();
                p--;
            }
            stack.push(nums[i]);
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character ch:stack){
            sb.append(ch);
        }
        System.out.println(sb.substring(0,sb.length()-p));
    }
}
