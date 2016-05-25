package algorithm.code.nyoj.nyoj58;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {

    static final int[][] map = {
            {1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,1,0,1},
            {1,0,0,1,1,0,0,0,1},
            {1,0,1,0,1,1,0,1,1},
            {1,0,0,0,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,1,0,0,1},
            {1,1,0,1,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1}
    };

    static final int[][] dict = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = new Scanner(new FileInputStream("src/main/resources/nyoj58.txt"),"utf8");

        int n = cin.nextInt();
        while((n -- ) > 0) {
            int sx = cin.nextInt();
            int sy = cin.nextInt();
            int ex = cin.nextInt();
            int ey = cin.nextInt();
            System.out.println(soultion(sx,sy,ex,ey));
        }
        cin.close();
    }

    public static int soultion(int sx, int sy, int ex, int ey) {

        int row = map.length;
        int col = map[0].length;
        boolean[][] vis = new boolean[row][col];
        Queue<Node> nodes = new LinkedList<Node>();

        boolean f = false;
        int x, y;

        Node node = null;
        nodes.add(new Node(sx, sy));

        while(!nodes.isEmpty()) {
            node = nodes.poll();
            x = node.x;
            y = node.y;
            if(x == ex && y == ey) {
                f = true;
                break;
            }

            for(int i=0; i<dict.length; i++) {
                int nx = x + dict[i][0];
                int ny = y + dict[i][1];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col) {
                    continue;
                }
                if(map[nx][ny] == 1 || vis[nx][ny]) {
                    continue;
                }
                Node next = new Node(nx, ny);
                next.size = node.size + 1;
                nodes.add(next);
                vis[nx][ny] = true;
            }
        }

//        if(f) {
            return node.size;
//        }
//        else return -1;
    }

}

class Node {
    int x, y;
    int size;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

