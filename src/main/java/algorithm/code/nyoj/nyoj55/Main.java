package algorithm.code.nyoj.nyoj55;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 使用最小堆实现
 * 手动实现最小堆
 * 构建堆时可以采用heapUp 或者heapDown方法实现
 * 注意使用long类型
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj55.txt"), "utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int n = cin.nextInt();
        long[] num = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            num[i] = cin.nextInt();
        }
        int len = num.length;
        long sum = 0;
        buildMinHeap(num, len);
        while (len > 2) {
            long a = num[1];
            num[1] = num[--len];
            heapDown(num, len, 1);
            long b = num[1];
            num[1] = num[--len];
            heapDown(num, len, 1);
            sum = sum + a + b;
            num[len++] = a + b;
            heapUp(num, len - 1);
        }
        System.out.println(sum);
    }

    private static void heapUp(long[] heap, int i) {
        while (i > 1 && heap[i >> 1] > heap[i]) {
            long temp = heap[i];
            heap[i] = heap[i >> 1];
            heap[i >> 1] = temp;
            i = i / 2;
        }
    }

    private static void heapDown(long[] heap, int len, int j) { //第i个节点heapDown
        while (j << 1 < len) {
            int child = j << 1;
            if (child < len - 1 && heap[child] > heap[child + 1]) child = child + 1;
            if (heap[j] > heap[child]) {
                long temp = heap[j];
                heap[j] = heap[child];
                heap[child] = temp;
                j = child;
            } else {
                break;
            }
        }
    }

    private static void buildMinHeap(long[] num, int len) {
        for (int i = (len - 1) >> 1; i >= 1; i--) {
            heapDown(num, len, i);
        }
//        for(int i=2;i<len;i++){
//            heapUp(num,i);
//        }
    }
}
