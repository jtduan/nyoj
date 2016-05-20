package algorithm.code.nyoj.nyoj16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * time:488
 * memery:866
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj16.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int p=0;p < N;p++) {
            int matrixNum = cin.nextInt();
            int[][] graph = new int[matrixNum][matrixNum];

            Matrix[] matrixs = new Matrix[matrixNum];
            for (int i = 0; i < matrixNum; i++) {
                matrixs[i] = new Matrix(cin.nextInt(), cin.nextInt());
                for (int j = 0; j < i; j++) {
                    if (Math.max(matrixs[i].length, matrixs[i].width) < Math.max(matrixs[j].length, matrixs[j].width) &&
                            Math.min(matrixs[i].length, matrixs[i].width) < Math.min(matrixs[j].length, matrixs[j].width)) {
                        graph[j][i] = 1;
                    } else if (Math.max(matrixs[i].length, matrixs[i].width) > Math.max(matrixs[j].length, matrixs[j].width) &&
                            Math.min(matrixs[i].length, matrixs[i].width) > Math.min(matrixs[j].length, matrixs[j].width)) {
                        graph[i][j] = 1;
                    }
                }
            }
            System.out.println(solution1(graph));
        }
    }

    private static int solution1(int[][] graph) {
        int[] res = new int[graph.length];
        for(int i = 0; i<graph.length;i++){
            dp(res,i,graph);
        }
        int max = 0;
        for(int i=0;i<res.length;i++){
            max=Math.max(max,res[i]);
        }
        return max;
    }

    private static void dp(int[] res, int i, int[][] graph) {
        if(res[i] > 0) return;
        int max =0;
        for(int j=0;j<graph.length;j++){
            if(graph[i][j] ==1) {
                dp(res, j, graph);
                max = Math.max(max, res[j]);
            }
        }
        res[i]=max+1;
    }
    public static class Matrix{
        int length;
        int width;

        public Matrix(int length, int width) {
            this.length = length;
            this.width = width;
        }
    }
}
