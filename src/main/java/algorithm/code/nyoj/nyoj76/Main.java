package algorithm.code.nyoj.nyoj76;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author jtduan
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj76.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int m = cin.nextInt();
        int[] res=new int[m+4];
        res[1]=0;
        res[2]=1;
        res[3]=2;
        for(int i=4;i<=m;i++){
            res[i]=res[i-1]+res[i-2];
        }
        System.out.println(res[m]);
    }
}