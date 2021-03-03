package Programmers.Level2;

public class 가장큰정사각형찾기 {
  public static void main(String[] args) {
    int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
    //int[][] board = {{0,0,1,1},{1,1,1,1}};
    int answer = 0;

    int h = board.length;
    int w = board[0].length;

    for (int i=1; i<h; i++) {
      for (int j=1; j<w; j++) {
        if (board[i][j] != 0 && board[i][j-1] != 0 && board[i-1][j] != 0 && board[i-1][j-1] != 0) {

          if (board[i][j-1] == board[i-1][j] && board[i-1][j] == board[i-1][j-1]) {
            board[i][j]++;
          }
        }
      }
    }

    for (int i=0; i<h; i++) {
      for (int j=0; j<w; j++) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
  }
}
