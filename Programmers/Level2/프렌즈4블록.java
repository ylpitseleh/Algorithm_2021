package Programmers.Level2;

import java.util.ArrayList;
/*
테케 틀리는데 귀찮아...
*/
public class 프렌즈4블록 {
  static class Pos {
    int y;
    int x;
    Pos (int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  public static void main(String[] args) {
    // String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
    // int m = 6;
    // int n = 6;
    // String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
    String[] board = {"AABBEE",
                      "AAAEEE",
                      "VAAEEV",
                      "AABBEE",
                      "AACCEE",
                      "VVCCEE"};
    int m = 6;
    int n = 6;
    int answer = 0;
    char[][] boardChar = new char[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        boardChar[i][j] = board[i].charAt(j);
      }
    }

    while (true) {
      ArrayList<Pos> al = new ArrayList<>();
      // 2*2로 터질 좌표들 저장하기
      for (int i=0; i<m-1; i++) {
        for (int j=0; j<n-1; j++) {
          if (boardChar[i][j] != '*' && boardChar[i][j] == boardChar[i+1][j] && boardChar[i+1][j] == boardChar[i][j+1] && boardChar[i][j+1] == boardChar[i+1][j+1]) {
            // System.out.println(i+" "+j);
            al.add(new Pos(i, j));
            al.add(new Pos(i+1, j));
            al.add(new Pos(i, j+1));
            al.add(new Pos(i+1, j+1));
          }
        }
      }
      if (al.size() == 0) {
        break;
      }
      // 저장된 좌표들(삭제될 좌표들) 표시하기 = 중복이 있을 수 있어서
      for (int i=0; i<al.size(); i++) {
        Pos p = al.get(i);
        if (boardChar[p.y][p.x] != '*') {
          answer++;
        }
        boardChar[p.y][p.x] = '*';
      }
      // 표시된 좌표들 자리를 위에걸로 채우기 (지워질거 지우고 위에가 내려오게)
      for (int i=0; i<n; i++) { // 배열을 한 줄씩 세로로 보면서 계산해야 함
        for (int j=0; j<m; j++) {
          if (boardChar[j][i] == '*') { // 지워야 할 칸을 만나면
            char c = '*';
            for (int k=j-1; k>=0; k--) { // 그 칸 위에 있는 것 중에 처음 나오는 '*이 아닌 칸'을 저장
              if (boardChar[k][i] != '*') {
                c = boardChar[k][i];
                // System.out.println("C = "+c+", ("+k+", "+i+")");
                boardChar[k][i] = '*'; // 땡겨온 칸은 이제 없어진 칸이니까 '-'로 바꿈
                break;
              }
            }
            boardChar[j][i] = c;
          }
        }
      }
      drop(boardChar);
      System.out.println();
      System.out.println("---------------");
      for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
          System.out.print(boardChar[i][j]+" ");
        }
        System.out.println();
      }
    }
    System.out.println(answer);
  }

  private static void drop (char boardChar[][]) {
    for (int i=0; i<boardChar[0].length; i++) {
      //System.out.println(i);
      for (int j=0; j<boardChar.length; j++) {
        System.out.print(boardChar[i][j]+" ");
        Pos star = new Pos(-1, -1); // 알파벳이 내려가야 할 좌표
        if (boardChar[j][i] >= 'A' && boardChar[j][i] <= 'Z') {
          for (int k=j+1; k<boardChar.length; k++) {
            if (boardChar[k][i] == '*') {
              star = new Pos(k, i); // 제일 밑에 *을 저장해서 제일 밑으로 내려보낸다.
              System.out.println("STAR! "+k+" "+i);
            }
          }
        }
        if (star.y != -1 && star.x != -1) {
          boardChar[star.y][star.x] = boardChar[j][i];
          boardChar[j][i] = '*';
        }
      }
    }
  }
}
