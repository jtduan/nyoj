package algorithm.code.poj.poj1088;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hero on 2016/5/12.
 */
public class Main {
    public static void main(String[] args){//throws FileNotFoundException {
        Scanner cin= null;
        //cin = new Scanner(new FileInputStream("src/main/java/poj/java/poj1088/dataSource.txt"),"utf8");
        cin = new Scanner(System.in);
        int R=cin.nextInt();
        int C=cin.nextInt();
        int[][] nums=new int[R][C];
        generate(nums,cin);

        getLongestPath(nums);
    }

    private static void getLongestPath(int[][] nums) {
        Point array[] = new Point[nums.length*nums[0].length];
        int[][] res=new int[nums.length][nums[0].length];
        int index=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                Point p =new Point();
                array[index]=p;
                array[index].num=nums[i][j];
                array[index].i=i;
                array[index].j=j;
                index++;
                //nums[i][j]=0;
            }
        }
        Arrays.sort(array);

        for(int i=0;i<array.length;i++){
            res[array[i].i][array[i].j]=findmax(array[i].i==0 || nums[array[i].i-1][array[i].j]>= nums[array[i].i][array[i].j]? 0 : res[array[i].i-1][array[i].j],
                    array[i].j==0|| nums[array[i].i][array[i].j-1]>= nums[array[i].i][array[i].j]? 0 : res[array[i].i][array[i].j-1],
                    array[i].i==nums.length-1 || nums[array[i].i+1][array[i].j]>= nums[array[i].i][array[i].j]? 0 : res[array[i].i+1][array[i].j],
                    array[i].j==nums[0].length-1|| nums[array[i].i][array[i].j+1]>= nums[array[i].i][array[i].j]? 0 : res[array[i].i][array[i].j+1])+1;
        }
        System.out.println(findmax(res));
    }

    private static int findmax(int[][] nums) {
        int max=nums[0][0];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
               max = max<nums[i][j]?nums[i][j]:max;
            }
        }
        return max;
    }

    private static int findmax(int a, int b, int c, int d) {
        int temp=a;
        if(b>temp){
            temp=b;
        }
        if(c>temp){
            temp=c;
        }
        if(d>temp){
            temp=d;
        }
        return temp;
    }



    private static void generate(int[][] nums,Scanner cin) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                nums[i][j]=cin.nextInt();
            }
        }
    }
}
class Point implements Comparable<Point>{
    public int i;
    public int j;
    public int num;

    @Override
    public int compareTo(Point p) {
        return num - p.num;
    }
}