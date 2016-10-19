package algorithm.code.graph;

/**
 * @author jtduan
 * @date 2016/10/17
 * 拓扑排序的非递归实现：维护一个入度为0的队列，
 * 每次取出一个点，同时该点相连的其他节点入度减1，若入度为0 则加入队列
 */
public class Kahn {
    public int[] Kahn_sort(int[][] graph){
        int[] in = new int[graph.length];
        int res[] = new int[graph.length];
        int cur=0;
        int max=0;

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[0].length;j++){
                if(graph[i][j]>0) in[j]++;
            }
        }
        for(int i=0;i<in.length;i++){
            if(in[i]==0) res[max++]=i;
        }

        while(max<graph.length){
            if (cur >= max) return new int[0];

            int temp = res[cur++];
            for(int i=0;i<graph.length;i++){
                if(graph[temp][i]>0) {
                    graph[temp][i]=0;
                    in[i]--;
                    if (in[i] == 0) {
                        res[max++] = i;
                    }
                }
            }
        }
        return res;
    }
}
