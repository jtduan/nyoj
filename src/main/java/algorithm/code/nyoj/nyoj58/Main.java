package algorithm.code.nyoj.nyoj58;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 *  广度优先遍历（BFS)
 *  未通过（wrong answer)
 *  更新：忽略了起点等于终点的情况！！
 */
public class Main {
    public static int[][] maps=new int[][]
           {{1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,1,0,1},
            {1,0,0,1,1,0,0,0,1},
            {1,0,1,0,1,1,0,1,1},
            {1,0,0,0,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1}};
    public static int dirctions[][]=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin= null;
//        cin = new Scanner(new FileInputStream("src/main/resources/nyoj58.txt"),"utf8");
        cin= new Scanner(System.in);
        int N = cin.nextInt();
        for(int i=0;i<N;i++){
            everyTest(cin);
        }
    }

    private static void everyTest(Scanner cin) {
        int start_x=cin.nextInt();
        int start_y=cin.nextInt();
        int end_x=cin.nextInt();
        int end_y = cin.nextInt();
        System.out.println(soultion(start_x,start_y,end_x,end_y));
    }

    public static int soultion(int start_x, int start_y, int end_x, int end_y) {
        if(start_x==end_x && start_y == end_y){
            return 0;
        }
        for(int j=0;j<=8;j++){
            for(int k=0;k<=8;k++){
                if(maps[j][k]==2)maps[j][k]=0;
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int cur=0; // 表示当前队列里的点所在的层数
        int cur_num=1; //表示cur该层在队列中还有几个点
        queue.add(start_x);
        queue.add(start_y);
        maps[start_x][start_y]=2;
        while(true){
            int x=queue.poll();
            int y =queue.poll();
            for(int i=0;i<4;i++){
                if(x+dirctions[i][0]==end_x && y+dirctions[i][1]==end_y){
//                    System.out.println(cur+1);
                    return cur+1;
                }
                else if(maps[x+dirctions[i][0]][y+dirctions[i][1]]==0){
                    queue.add(x+dirctions[i][0]);
                    queue.add(y+dirctions[i][1]);
                    maps[x+dirctions[i][0]][y+dirctions[i][1]]=2;
                }
            }
            if(--cur_num==0){
                cur++;
                cur_num=queue.size()/2;
            }
        }
    }
}
