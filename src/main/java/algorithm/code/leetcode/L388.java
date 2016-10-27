package algorithm.code.leetcode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L388 {
    public int lengthLongestPath(String input) {
        String strs[] = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            int num = getTabNum(strs[i]);
            while (stack.size() > num) stack.pop();
            if (stack.isEmpty()) stack.push(strs[i].length()-num);
            else stack.push(stack.peek() + strs[i].length()-num+1);
            if(strs[i].contains("."))max = Math.max(stack.peek(), max);
        }
        return max;
    }

    public int getTabNum(String str) {
        int num = 0;
        int index = 0;
        while (str.charAt(index) == '\t') {
            num++;
            index++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new L388().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

        System.out.println("dir/subdir2/subsubdir2/file2.ext".length());
    }
}
