package algorithm.code.nyoj.nyoj634;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 */
public class Main {
    private static int[] num1;
    private static int[] num2;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj634.txt"),"utf8");
//        cin = new Scanner(System.in);
        while(cin.hasNext()){
            int N = cin.nextInt();
            int K = cin.nextInt();
            num1 = new int[N];
            num2 = new int[N];
            for(int i=0;i<N;i++){
                num1[i]=cin.nextInt();
            }
            for(int i=0;i<N;i++){
                num2[i]=cin.nextInt();
            }
            soultion(K);
        }
    }

    private static void soultion( int k) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        int res[] = new int[k];
        int num1_1=num1.length-1;
        int num2_1=num2.length-1; // 一个数列

        int num1_2=num1.length-1; //
        int num2_2=num2.length-1; //

        while(k>0) {
            if(num1_1==num1_2 && num2_1==num2_2){
                if (num1[num1_1] + num2[num2_1] >= num1[num1_2] + num2[num2_2]) {
                    if (num1_1>0 && num2_1>0 && num1[num1_1] - num1[num1_1 - 1] >= num2[num2_1] - num2[num2_1 - 1]) {
                        num1_1--;
                    }else if (num2_1>0) {
                        num2_1--;
                    }else if(num1_1>0){
                        num1_1--;
                    }
                } else {
                    if (num1_2 >0 && num2_2>0 &&  num1[num1_2] - num1[num1_2 - 1] >= num2[num2_2] - num2[num2_2 - 1]) {
                        num1_2--;
                    } else if (num2_2>0) {
                        num2_2--;
                    }else if(num1_2>0){
                        num1_2--;
                    }
                }
            }
            if (num1[num1_1] + num2[num2_1] >= num1[num1_2] + num2[num2_2]) {
                res[--k]=num1[num1_1] + num2[num2_1];
                if (num1_1>0 && num2_1>0 && num1[num1_1] - num1[num1_1 - 1] >= num2[num2_1] - num2[num2_1 - 1]) {
                    num2_1--;
                }else if (num1_1>0) {
                    num1_1--;
                }else if(num2_1>0){
                    num2_1--;
                }
            } else {
                res[--k]=num1[num1_2] + num2[num2_2];
                if (num1_2 >0 && num2_2>0 &&  num1[num1_2] - num1[num1_2 - 1] >= num2[num2_2] - num2[num2_2 - 1]) {
                    num2_2--;
                } else if (num1_2>0) {
                    num1_2--;
                }else if(num2_2>0){
                    num2_2--;
                }
            }
        }
        for(int i=0;i<res.length-1;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println(res[res.length-1]);
    }
}
