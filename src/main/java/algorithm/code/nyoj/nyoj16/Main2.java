package algorithm.code.nyoj.nyoj16;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 提交失败原因：
 * 1、忘记修改文件名
 * 2、line62  for循环i=0写成了i=1
 * 3、忽略了完成排序后 length相等的情况
 * time:60
 * memery:805
 */
public class Main2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = null;
        cin = new Scanner(new FileInputStream("src/main/resources/nyoj16.txt"), "utf8");
//        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for (int p = 0; p < N; p++) {
            int matrixNum = cin.nextInt();
            Matrix[] matrices = new Matrix[matrixNum];
            for(int i=0;i<matrixNum;i++) {
                int a=cin.nextInt();
                int b = cin.nextInt();
                matrices[i] = new Matrix(Math.max(a,b),Math.min(a,b));
            }
            Arrays.sort(matrices, new Comparator<Matrix>() {
                @Override
                public int compare(Matrix m1, Matrix m2) {
                    if(m1.length>m2.length){
                        return 1;
                    }
                    else if(m1.length<m2.length){
                        return -1;
                    }
                    else return 0;
                }
            });

            System.out.println(getlongestPath(matrices));
        }
    }

    private static int getlongestPath(Matrix[] matrices) {
//        for(Matrix m:matrices){
//            System.out.println(m.length+" "+ m.width);
//        }
        int[] num = new int[matrices.length];
        for(int i=0;i<num.length;i++){
            int max=0;
            for(int j = i-1;j>=0;j--){
                if(matrices[i].length > matrices[j].length && matrices[i].width>matrices[j].width) max = Math.max(max,num[j]);
            }
            num[i]=max+1;
        }
        int max=0;
        for(int i=0;i<num.length;i++){
            max = Math.max(num[i],max);
        }
        return max;
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
