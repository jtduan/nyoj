package algorithm.code.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtduan
 * @date 2016/10/25
 */
public class L378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (n == 0) return 0;
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0, matrix[0][0]));
        matrix[0][0] = Integer.MAX_VALUE;
        while (k > 1) {
            k--;
            Point p = queue.poll();
            if (p.x < n - 1 && matrix[p.x + 1][p.y] < Integer.MAX_VALUE) {
                queue.add(new Point(p.x + 1, p.y, matrix[p.x + 1][p.y]));
                matrix[p.x + 1][p.y]=Integer.MAX_VALUE;
            }
            if (p.y < n - 1 && matrix[p.x][p.y + 1] < Integer.MAX_VALUE) {
                queue.add(new Point(p.x, p.y + 1, matrix[p.x][p.y + 1]));
                matrix[p.x][p.y + 1]=Integer.MAX_VALUE;
            }
        }
        return queue.poll().val;
    }

    class Point implements Comparable {
        int x;
        int y;
        int val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Object o) {
            return this.val - ((Point) o).val;
        }
    }
}
