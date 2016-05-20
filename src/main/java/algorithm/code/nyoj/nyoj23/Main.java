package algorithm.code.nyoj.nyoj23;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  nyoj模板代码
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj23.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int N = cin.nextInt();
        int M = cin.nextInt();
        System.out.println(solution(N,M));
    }

    private static String solution(int N,int M) {
        return N%(M+1)==0?"Lose":"Win";
    }
}
