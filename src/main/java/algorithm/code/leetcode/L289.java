package algorithm.code.leetcode;

/**
 * @author jtduan
 * @date 2016/10/19
 */
public class L289 {
    public void gameOfLife(int[][] board) {
        if(board.length==0){
            return;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                update(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]/2;
            }
        }
    }

    private void update(int[][] board, int i, int j) {
        int lives = 0;
        if(i-1>=0 && (board[i-1][j]&1)==1){
            lives++;
        }
        if(i+1<board.length && (board[i+1][j]&1)==1){
            lives++;
        }
        if(j-1>=0 && (board[i][j-1]&1)==1){
            lives++;
        }
        if(j+1<board[0].length && (board[i][j+1]&1)==1){
            lives++;
        }

        if(j-1>=0 && i-1>=0 && (board[i-1][j-1]&1)==1){
            lives++;
        }
        if(j-1>=0 && i+1<board.length && (board[i+1][j-1]&1)==1){
            lives++;
        }
        if(j+1<board[0].length && i-1>=0 && (board[i-1][j+1]&1)==1){
            lives++;
        }
        if(j+1<board[0].length && i+1<board.length && (board[i+1][j+1]&1)==1){
            lives++;
        }



        if(board[i][j]==1 && (lives==2||lives==3)){
            board[i][j]=3;
        }
        if(board[i][j]==0 && lives==3){
            board[i][j]=2;
        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1},{1,0}};
        new L289().gameOfLife(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                System.out.println(nums[i][j]);
            }
        }
    }
}
