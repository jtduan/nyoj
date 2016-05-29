package algorithm.code.nyoj.nyoj206;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 找到A*B中有多少个矩形
 * 注意: int转long需要强制转换
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj206.txt"), "utf8");
        cin = new Scanner(System.in);

        while (cin.hasNext()) {
            int A = cin.nextInt();
            int B = cin.nextInt();
            System.out.println(soultion(A, B));
        }
    }

    private static long soultion(int a, int b) {
        return (long)a*(a+1)*b*(b+1)/4;
    }
}
