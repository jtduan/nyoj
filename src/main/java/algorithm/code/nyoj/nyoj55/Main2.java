package algorithm.code.nyoj.nyoj55;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *  使用java自带的PriorityQueue实现
 *  PriorityQueue内部还是采用堆的形式
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj55.txt"),"utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        for(int i=1;i<=n;i++){
            queue.offer(cin.nextLong());
        }
        long sum = 0;
        long a;
        long b;
        while(queue.size()>1){
            a=queue.poll();
            b=queue.poll();
            sum=sum+a+b;
            queue.offer(a+b);
        }
        System.out.println(sum);
        int test =2;
        int test2=test<<1;
        System.out.println(test +" "+test2);
    }
}
