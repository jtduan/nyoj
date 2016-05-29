package algorithm.code.nyoj.nyoj222;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main2 {
    public static long fun(long n) {
        long sum = 0, tmp = 1, m;
        while (true) {
            if (n < tmp) break;
            tmp *= 2;
            m = (n + 1) % tmp;
            if (m > tmp / 2) {
                sum += (m - tmp / 2);
            }
            sum += (n + 1) / tmp * (tmp / 2);
        }
        return sum;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = new Scanner(new FileInputStream("src/main/resources/nyoj222.txt"),"utf8");
//        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            long n, m;
            n = cin.nextLong();
            m = cin.nextLong();
            if (n > m) {
                long p = n;
                n = m;
                m = p;
            }
            n = fun(n - 1);
            m = fun(m);
            m = m - n;
            System.out.println(m);
        }
    }
}