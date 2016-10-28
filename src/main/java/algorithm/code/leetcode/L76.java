package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/27
 */
public class L76 {
    public String minWindow(String s, String t) {
        int[] src = new int[256];
        int window[] = new int[256];

        if (t.length() > s.length()) return "";
        char[] chars_t = t.toCharArray();
        char[] chars_s = s.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            src[chars_t[i] - 'A']++;
        }

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            window[chars_s[right] - 'A']++;
            if (window[chars_s[right] - 'A'] == src[chars_s[right] - 'A'] && check(src, window)) break;
            right++;
        }
        if (right >= s.length()) return "";
        right++;
        int min = right;
        int min_l = 0;
        int min_r = right;
        while (right <= s.length()) {
            if (window[chars_s[left] - 'A'] > src[chars_s[left] - 'A']) {
                window[chars_s[left] - 'A']--;
                left++;
                if (min > right - left) {
                    min = right - left;
                    min_l = left;
                    min_r = right;
                }
            } else {
                if(right>=s.length()) break;
                window[chars_s[right] - 'A']++;
                right++;
            }
        }
        return String.valueOf(chars_s, min_l, min_r-min_l);
    }

    private boolean check(int[] src, int[] window) {
        for (int i = 0; i < 256; i++) {
            if (src[i] > window[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        double d = 0;
        double x=718272.0;
        d=x/3;
        System.out.println(d);
        System.out.println(d==239424);
//        System.out.println(new L76().minWindow2("abcffghdd","bbf"));
    }

    public String minWindow2(String s, String t) {
        int[] count=new int[128];
        for(char r:t.toCharArray()) count[r]++;
        int head=0,min=Integer.MAX_VALUE,total=t.length();
        for(int i=0,j=0;i<s.length();i++){
            if(count[s.charAt(i)]-->0) total--;
            while(total==0){
                if(i+1-j<min) {min=i+1-j;head=j;}
                if(++count[s.charAt(j++)]>0) total++;
            }
        }

        return min==Integer.MAX_VALUE?"":s.substring(head,head+min);
    }

}
