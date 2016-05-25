package algorithm.code.nyoj.nyoj36;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * nyoj模板代码
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj36.txt"),"utf8");
        cin = new Scanner(System.in);
        int N = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        String str1 = cin.nextLine();
        String str2 = cin.nextLine();
        solution(" "+str1, " "+str2);
        solution2(str1,str2);
    }

    private static void solution(String str1, String str2) {
        int res[][]=new int[str1.length()][str2.length()];
        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    res[i][j]=res[i-1][j-1]+1;
                }
                else{
                    res[i][j]=Math.max(res[i-1][j],res[i][j-1]);
                }
            }
        }
        System.out.println(res[str1.length()-1][str2.length()-1]);
    }

    /**
     * 注意各种边界条件和循环方向的控制
     * @param str1
     * @param str2
     */
    private static void solution2(String str1, String str2) {
        int[] len = new int[str1.length() + 1];
        int max = 0;
        for (int i = 0; i < str1.length(); i++) {
            int j=str2.length()-1;
            int cur=max;
            while(j>=0){
                if (str1.charAt(i) == str2.charAt(j)) {
                    while(cur > 0 && len[cur]>=j) cur--;
                    len[++cur]=j;
                    if(max<cur) max =cur;
                }
                j--;
            }
        }
        System.out.println(max);
    }
}
