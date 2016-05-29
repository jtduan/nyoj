package algorithm.code.graph;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by hero on 2016/5/26.
 */
public class GraphTest extends TestCase {
    @Test
    public void testGenerateMinTree() {
        int[][] graph = new int[50][50];
        for (int k = 0; k <= 100; k++) {
            for (int i = 0; i < 50; i++) {
                for (int j = i + 1; j < 50; j++) {
                    graph[i][j] = new Double(10 * Math.random() + 1).intValue();
                    graph[j][i] = graph[i][j];
                }
            }

//        for(int i=0;i<5;i++){
//            for(int j=0;j<5;j++){
//                System.out.print (graph[i][j] +" ");
//            }
//            System.out.println();
//        }

            int[][] res = MinimumSpanningTree.generateMinTree_Prim(graph);
            int sum_Prim = 0;
            for (int i = 0; i < res.length; i++) {
                sum_Prim += graph[res[i][0]][res[i][1]];
            }

            int[][] res2 = MinimumSpanningTree.generateMinTree_Kruskal(graph);
            int sum_Kruskal = 0;
            for (int i = 0; i < res.length; i++) {
                sum_Kruskal += graph[res2[i][0]][res2[i][1]];
            }

            int sum = Prim_Dijkstra.prim(graph, 50);
//        System.out.println(sum);
//        System.out.println(sum_Kruskal);
//        System.out.println(sum_Prim);
            assertEquals("Prim", sum, sum_Prim);
            assertEquals("Kruskal", sum, sum_Prim);
        }
    }

    @Test
    public void testEuler() {
        int[][] graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                graph[i][j] = new Double(10 * Math.random() + 1).intValue();
                graph[j][i] = graph[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        int[] res = Euler.printEuler(graph);
        for(int i=Euler.len_path-1;i>=0;i--){
            System.out.print(res[i]+" ");
        }
        System.out.println();

        int[] res2 = NetProgram.printEuler(graph);
        for(int i=NetProgram.num-1;i>=0;i--){
            System.out.print(res2[i]+" ");
        }
        System.out.println();
    }

    @Test
    public void testHamiton(){
        int[][] graph = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                graph[i][j] = new Double(10 * Math.random() + 1).intValue()/5;
                graph[j][i] = graph[i][j];
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
//        for(int i=0;i<res.length;i++){
//            System.out.print(res[i]+" ");
//        }
//        System.out.println();

        int[] res2 = Hamiton.getHamiton(graph,0);
//        for(int i=0;i<res2.length;i++){
//            System.out.print(res2[i]+" ");
//        }
//        System.out.println();
//        assertEquals(res,res2);

    }
}
