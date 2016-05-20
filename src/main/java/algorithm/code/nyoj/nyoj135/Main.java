package algorithm.code.nyoj.nyoj135;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  nyoj模板代码
 *  参考 =====博弈论=====
 *  尼姆博弈+巴什博弈
 *
 */
public class Main {
    public static int num=0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj135.txt"),"utf8");
        cin= new Scanner(System.in);
        int T = cin.nextInt();
        for(int i=0;i<T;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        boolean win = false;
        int res=0;
        for(int i=0;i<N;i++){
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = a%(b+1);
            res ^=c;
        }
        if(res!=0){
            System.out.println("Win");
        }
        else {
            System.out.println("Lose");
        }
    }
}
