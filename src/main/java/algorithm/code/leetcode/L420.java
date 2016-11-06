package algorithm.code.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jtduan
 * @date 2016/11/1
 */
public class L420 {
    public int strongPasswordChecker(String s) {
        int flag = 3;
        if (s.matches(".*\\d.*")) flag--;
        if (s.matches(".*[a-z].*")) flag--;
        if (s.matches(".*[A-Z].*")) flag--;
        if (s.length() < 6) {
            Pattern p = Pattern.compile("(\\w)\\1\\1");
            Matcher matcher = p.matcher(s);
            while (matcher.find()) {
                flag = Math.max(0, flag - 1);
            }
            return 6 - s.length() + flag;
        }

        if (s.length() > 20) {
            StringBuilder sb  = new StringBuilder();
            sb.append(s.charAt(0)).append(s.charAt(1));
            for(int i=2;i<s.length();i++){
                if(sb.charAt(sb.length()-2)==sb.charAt(sb.length()-1) && sb.charAt(sb.length()-1)==s.charAt(i)){
                    continue;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Pattern p = Pattern.compile("(\\w)(?=\\1\\1)");
        Matcher matcher = p.matcher("ssssssssss");
        while (matcher.find()) {
            System.out.println("OJ");
        }
    }
}
