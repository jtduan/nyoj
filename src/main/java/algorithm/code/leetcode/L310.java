package algorithm.code.leetcode;

import java.util.List;

/**
 * @author jtduan
 * @date 2016/10/18
 * 思路1：每次删除一层叶子节点，最后剩下的1个或2个点即为结果
 * 思路2：以其中一个叶子节点为根，记录该节点到其他叶子节点的路径，求所有路径公共序列，判断距离最大的2个点的距离，中间的一个或2个点即为结果
 */
public class L310 {
    private int[] visited;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        dfs();
        return null;
    }
}
