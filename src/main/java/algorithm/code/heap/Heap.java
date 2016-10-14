package algorithm.code.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap{
    /**
     * 最小堆的简单代码实现
     * @param heap
     * @param i
     */
    private static void heapUp(long[] heap, int i) {
        while (i > 1 && heap[i >> 1] > heap[i]) {
            long temp = heap[i];
            heap[i] = heap[i >> 1];
            heap[i >> 1] = temp;
            i = i / 2;
        }
    }

    private static void heapDown(long[] heap, int len, int j) {

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
