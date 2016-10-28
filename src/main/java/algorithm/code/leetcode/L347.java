package algorithm.code.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jtduan
 * @date 2016/10/28
 */
public class L347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) queue.add(new Node(entry.getKey(), entry.getValue()));
            else if (queue.peek().count < entry.getValue()) {
                queue.poll();
                queue.add(new Node(entry.getKey(), entry.getValue()));
            }
        }
//        return queue.stream().mapToInt((node) -> node.num).boxed().collect(Collectors.toList());
        List<Integer> list = new ArrayList<>();
        for(Node n:queue){
            list.add(n.num);
        }
        return list;
    }

    class Node implements Comparable<Node> {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return count - o.count;
        }
    }
}
