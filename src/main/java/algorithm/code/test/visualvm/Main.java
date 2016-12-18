package algorithm.code.test.visualvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jtduan
 * @date 2016/11/15
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap map = new ConcurrentHashMap();
        while (true){
            List<Node> list  = new ArrayList<>();
            for(int i=0;i<10000;i++){
                add(list,i);
                map.put(new Object(),new Object());
            }
            Thread.sleep(30);
        }
    }

    private static void add(List<Node> list, int i) {
        list.add(new Node(i));
    }
}
class Node{
    int x;
    private List<Integer> list;

    public Node(int x) {
        this.x = x;
        this.list = new ArrayList<>();
    }
}