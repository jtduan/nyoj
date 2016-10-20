package algorithm.code.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L133 {

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    private Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map.clear();
        dfs(node);
        return map.get(node);
    }

    private void dfs(UndirectedGraphNode node) {
        if(node == null) return;
        if(map.containsKey(node)){
            return;
        }
        UndirectedGraphNode clone_node = new UndirectedGraphNode(node.label);
        map.put(node,clone_node);

        for(UndirectedGraphNode tmp:node.neighbors){
            dfs(tmp);
            clone_node.neighbors.add(map.get(tmp));
        }
    }
}
