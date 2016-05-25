package algorithm.code.nyoj.nyoj37;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  ** 经典问题 **添加最少的字符构成回文串
 *  标准解法：动态规划
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj37.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        cin.nextLine();
        for(int i=0;i<N;i++){
            everyTest(cin); //O（n^2)
//            everyTest2(cin); //O（n^3)
        }
    }

    private static void everyTest(Scanner cin) {
        String str =cin.nextLine();
        char[] chars=str.toCharArray();
        int len = str.length();
        int res[][] =new int[len+1][len+1];

        for(int i=0;i<len;i++){
            res[i][i]=0;
            res[i][i+1]=0;
        }

        for(int j=2;j<=len;j++){
            for(int i=j-2;i>=0;i--){
                if(chars[i]==chars[j-1]){
                    res[i][j]=res[i+1][j-1];
                }
                else{
                    res[i][j]=Math.min(res[i][j-1],res[i+1][j])+1;
                }
            }
        }
        System.out.println(res[0][len]);
    }

    /**
     * 不建议该方法O(n^3)
     * @param cin
     */
    private static void everyTest2(Scanner cin) {
        String str =cin.nextLine();
        int len = str.length();
        int res[][] =new int[len+1][len+1];
        for(int i=0;i<len;i++){
            res[i][i]=0;
            res[i][i+1]=0;
        }
        res[len][len]=0;
        for(int j=2;j<=len;j++){
            for(int i=j-2;i>=0;i--){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j-2;k++){
                    if(str.charAt(k) == str.charAt(j-1)){
                        min = Math.min(min,k-i+res[k+1][j-1]);
                    }
                }
                res[i][j]=Math.min(res[i][j-1]+1,min);
            }
        }
        System.out.println(res[0][len]);
    }
}
