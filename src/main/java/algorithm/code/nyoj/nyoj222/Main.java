package algorithm.code.nyoj.nyoj222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  求数字中1得个数(未通过)
 *  在nyoj281题目中通过!
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj222.txt"),"utf8");
//        cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        long sum1=solution2(a-1);
        long sum2=solution2(b);
        System.out.println(sum2-sum1);
    }

//    /**
//     * 十进制
//     * @param a
//     * @return
//     */
//    private static long solution(int a) {
//        if(a<=0) return 0;
//        int left;
//        int right;
//        int digit;
//        long res=0;
//        int i=1;//
//        while(a/i!=0){
//            left=a/i;
//            right=a%i; //该位数右边的数字
//            digit=left%10; //该位数的数字
//            left=left/10; //该位数左边的数字
//            if(digit>1) res=res+(left+1)*i;
//            if(digit==1) res=res+left*i+right+1;
//            if(digit==0) res=res+left*i;
//            i=10*i;
//        }
//        return res;
//    }

    /**
     * 二进制
     * @param a
     * @return
     */
    private static long solution2(int a) {
        if(a<=0) return 0;
        int left=a;
        int right=0;
        int digit=0;
        long res=0;
        int i=0;// 比如:2
        long num=1; //比如:100
        while(a>=num){
            right=a & ((1<<i)-1); //该位数右边的数字
            digit=left&1; //该位数的数字
            left=left>>1; //该位数左边的数字
            if(digit==1) res+=(left<<i)+right+1;
            else if(digit==0) res+=left<<i;
            num=num<<1;
            i++;
        }
        return res;
    }
}
