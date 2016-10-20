package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/20
 */
public class L130 {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }

        int UF[] = new int[board.length * board[0].length];
        int flag[] = new int[board.length * board[0].length];

        for (int i = 0; i < UF.length; i++) {
            int x = i / board[0].length;
            int y = i % board[0].length;
            if (board[x][y] == 'O') {
                UF[i] = i;
                if(x==0||y==0||x==board.length-1 || y==board[0].length-1) flag[i]=-1;

                if (y >= 1 && board[x][y - 1] == 'O') {
                    union(UF, i, i - 1,flag);
                }
                if (x >= 1 && board[x - 1][y] == 'O') {
                    union(UF, i, i - board[0].length,flag);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    if(flag[find(UF,board[0].length*i+j)]==0){
                        board[i][j]='X';
                    }
                }
            }
        }

        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(UF[board[0].length*i+j]);
            }
            System.out.println();
        }
    }

    private void union(int[] UF, int a, int b,int[]flag) {
        int root1 = find(UF, a);
        int root2 = find(UF, b);
        if (root1 == root2) return;
        UF[root1] = root2;
        if(flag[root1] == -1 || flag[root2]==-1) {
            flag[root2]=-1;
        }
    }

    private int find(int[] UF, int a) {
        while (UF[a] != a) {
            UF[a] = UF[UF[a]];
            a = UF[a];
        }
        return a;
    }

    public static void main(String[] args) {
        char[][] board =  new char[][]{
                {'O','X','X','O','X'},
                {'X','O','O','X','O'},
                {'X','O','X','O','X'},
                {'O','X','O','O','O'},
                {'X','X','O','X','O'}};
        new L130().solve(board);

        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
