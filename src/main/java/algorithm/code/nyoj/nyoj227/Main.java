package algorithm.code.nyoj.nyoj227;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * @author jtduan
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        int num2 = queue.take();
        queue.put(1002);
        int num = queue.take();
        System.out.println(num2);
    }
}
