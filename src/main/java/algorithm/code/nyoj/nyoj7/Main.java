package algorithm.code.nyoj.nyoj7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj7.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            int homeNum = cin.nextInt();
            int[] x = new int[homeNum];
            int[] y = new int[homeNum];
            for(int j=0;j<homeNum;j++){
                x[j]= cin.nextInt();
                y[j]=cin.nextInt();
            }
            System.out.println(solution(x,y));
        }
    }

    private static int solution(int[] x, int[] y) {
        Arrays.sort(x);
        Arrays.sort(y);
        int x_mid = x[x.length/2];
        int y_mid = y[y.length/2];
        int res=0;
        for(int i=0;i<x.length;i++){
            res+=Math.abs(x_mid-x[i]);
            res+=Math.abs(y_mid-y[i]);
        }
        return res;
    }
}
