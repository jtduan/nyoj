package algorithm.code.nyoj.nyoj88;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * nyoj模板代码
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj88.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        System.out.println(solution(n));
//        System.out.println(solution2(n));
    }

    private static int solution2(int n) {
        int res=0;
        for(int i=1;i<=n;i++){
            res=(res*2+1)%1000000;
        }
        return res;
    }

    private static long solution(int n) {
        if (n == 1) return 1;
        long res = solution(n / 2);
        if(n%2==0) {
            return ((res+1)*(res+1)-1)%1000000;
        }
        else{
            return (2*(res+1)*(res+1)-1)%1000000;
        }
    }
}
