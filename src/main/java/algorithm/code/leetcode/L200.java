package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L200 {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;
        int UF[] = new int[grid.length * grid[0].length];
        for (int i = 0; i < UF.length; i++) {
            int x = i / grid[0].length;
            int y = i % grid[0].length;
            if (grid[x][y] == '1') {
                UF[i] = i;
                count++;
                if (y >= 1 && grid[x][y - 1] == '1') {
                    count -= union(UF, i, i - 1);
                }
                if (x >= 1 && grid[x - 1][y] == '1') {
                    count -= union(UF, i, i - grid[0].length);
                }
            }
        }

        return count;
    }

    private int union(int[] UF, int a, int b) {
        int root1 = find(UF, a);
        int root2 = find(UF, b);
        if (root1 == root2) return 0;
        UF[root1] = root2;
        return 1;
    }

    private int find(int[] UF, int a) {
        while (UF[a] != a) {
            UF[a] = UF[UF[a]];
            a = UF[a];
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new L200().numIslands(new char[][]{{'1','0'},{'1','1'}}));
    }
}
