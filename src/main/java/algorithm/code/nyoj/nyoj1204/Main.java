package algorithm.code.nyoj.nyoj1204;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj1204.txt"),"utf8");
        cin = new Scanner(System.in);
        while(cin.hasNext()){
            int N = cin.nextInt();
            int[] num = new int[N];
            for(int i=0;i<N;i++){
                num[i] = cin.nextInt();
            }
            int res[] = new int[N];
            int tmp[] = new int[N];
            soultion(num,res,tmp);
            System.out.println(res[N-1]);
        }
    }

    private static void soultion(int[] num, int[] res, int[] tmp) {
        int len =num.length;
        res[0]=0;
        tmp[0]=num[0];
        res[1]=0;
        tmp[1]=num[1];
        res[2]=Math.min(Math.min(num[0],num[1]),num[2]);
        tmp[2]=num[2];

        for(int i=3;i<len;i++){
            tmp[i]=res[i-1]+num[i];
            res[i]=Math.min(Math.min(tmp[i],tmp[i-1]),tmp[i-2]);
        }
    }
}
