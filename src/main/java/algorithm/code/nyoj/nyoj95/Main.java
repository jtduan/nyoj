package algorithm.code.nyoj.nyoj95;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 暴力求解法
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj95.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int num[] = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = cin.nextInt();
        }
        solution(num);
    }

    private static void solution(int[] num) {
        if (num.length == 0) {
            return;
        }
        Arrays.sort(num);
        int longest =1;
        int longest_num=num[0];
        int current=1;
        for(int i=1;i<num.length;i++){
            if(num[i]==num[i-1]) current++;
            else{
                if(longest<current){
                    longest = current;
                    longest_num = num[i-1];
                }
                current=1;
            }
        }
        System.out.println(longest_num+" "+longest);
    }
}
