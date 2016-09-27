package algorithm.code.nyoj.nyoj542;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 思路：依次遍历已生成物品（可用反应物），将化学方程式左侧对应物品删除，若左侧为空，则可以将右侧生成物加入反应物列表，
 * 时间复杂度:O（m*n)
 */
public class Main {
    public static Map<String,List<Node>> map=new HashMap<String,List<Node>>();
    public static Set<String> set = new HashSet<String>();
    public static List<String> list = new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj542.txt"),"utf8");
        cin = new Scanner(System.in);
        while(cin.hasNext()){
            map.clear();
            set.clear();
            list.clear();
            int N = cin.nextInt();
            cin.nextLine();
            for(int i=0;i<N;i++){
                String str = cin.nextLine();
                Node n = new Node();
                n.source = new ArrayList<String>(Arrays.asList(str.split("=")[0].split("\\+")));
                n.target = new ArrayList<String>(Arrays.asList(str.split("=")[1].split("\\+")));
                for(String src: Arrays.asList(str.split("=")[0].split("\\+"))){
                    if(map.get(src)==null) {
                        map.put(src,new ArrayList<Node>());
                    }
                    map.get(src).add(n);
                }
            }
            int M = cin.nextInt();
            cin.nextLine();
            for(int i=0;i<M;i++) {
                String str = cin.nextLine();
                set.add(str);
                list.add(str);
            }
            soultion();
            List<String> l = list.subList(M,list.size());
            Collections.sort(l);
            System.out.println(l.size());
            for(String str : l){
                System.out.println(str);
            }
        }
    }

    private static void soultion() {
        for(int i=0;i<list.size();i++){
            List<Node> nodes = map.get(list.get(i));
            if(nodes == null) continue;
            for(Node node: nodes){
                node.source.remove(list.get(i));
                if(node.source.isEmpty()){
                    for(String str:node.target){
                        if(set.contains(str)) continue;
                        list.add(str);
                        set.add(str);
                    }
                }
            }
        }
    }
}
class Node{
    List<String> source;
    List<String> target;

    public Node() {
        this.source = new ArrayList<String>();
        this.target = new ArrayList<String>();
    }
}
