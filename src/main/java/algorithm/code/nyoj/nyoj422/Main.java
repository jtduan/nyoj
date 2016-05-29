package algorithm.code.nyoj.nyoj422;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  连续和 最接近0 的值(nlogn)
 *  连续和 最远离0 的值
 *  注意:num[j]-num[i]是i,j之间连续和不含i,因此还需要num[j]-0参与最小值比较
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj422.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int num[] = new int[N];
        for(int i=0;i<N;i++){
            num[i]=cin.nextInt();
        }
        System.out.println(solution(num,N));

    }

    private static int solution(int[] num, int n) {
        int min=Math.abs(num[0]);
        for(int i=1;i<n;i++){
            num[i]=num[i-1]+num[i];
            min = Math.min(Math.abs(num[i]),min);
        }
        Arrays.sort(num);
        int max = Math.max(Math.max(num[n-1],Math.abs(num[0])),num[n-1]-num[0]);
        for(int i=1;i<n;i++){
            if(num[i]-num[i-1]<min){
                min = num[i]-num[i-1];
            }
        }
        return max-min;
    }
}
