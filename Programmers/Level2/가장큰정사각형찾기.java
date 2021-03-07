package Programmers.Level2;
/*
★★★★☆
cheat: O
1H 20M
DP는 너무 어려워 ㅠㅠ
식 다르게 세웠다가 테케 몇 개가 틀려서 그냥 답 봤다.
*/
public class 가장큰정사각형찾기 {
  public static void main(String[] args) {
    //int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
    //int[][] board = {{0,0,1,1},{1,1,1,1}};
    //int[][] board = {{0,1,1,0,1},{0,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
    //int[][] board = {{1,1,1,1,1}, {1,1,1,1,1}, {1,1,0,1,1}, {1,1,1,1,1}};
    int[][] board = {{0, 0},{0,0}};
    int answer = 0;

    int h = board.length;
    int w = board[0].length;
    int max = 1;
    // 1로 이루어진 가장 큰 정사각형
    for (int i=1; i<h; i++) {
			for (int j=1; j<w; j++) {
				if (board[i][j] != 0) {
          // 내 기준 왼쪽, 오른쪽, 왼쪽 대각선의 최소값을 찾아주면 됨. => 셋 중 하나가 0이면 정사각형이 아니니까 board[i][j]도 0이여야 하므로.
					board[i][j] = 1 + Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]);
					answer = Math.max(answer, board[i][j]);
				}
			}
		}

    for (int i=0; i<h; i++) {
      for (int j=0; j<w; j++) {
        System.out.print(board[i][j]+" ");
      }
      System.out.println();
    }
    answer = max * max;
    System.out.println(answer);
  }
}
