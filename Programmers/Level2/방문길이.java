package Programmers.Level2;
/*
★★★☆☆
cheat: O
0H 30M
일반적인 탐색문제처럼 (i, j)좌표를 방문했는지 안했는지 판별하는게 아니라,
해당 경로를 사용했는지 안했는지 판별해야되기 때문에,
매번 가는방향과 오는방향 (src x, src y, dstn x, dstn y), (dstn x, dstn y, src x, src y) 좌표 쌍을 저장하고,
동일한 튜플이 있는지 판별하는식으로 구현해야 한다.
---------
이걸 딱 보고 일반적인 탐색 문제가 아니라 경로를 사용했는지 판별해야 하는군. 이런 생각이 안 선다.
탐색처럼 풀다가 테케 다 틀렸다고 나와서 풀이 봤는데 beforeY, beforeX, nextY, nextX를 사용해야 하는 문제였다.
이것만 알면 풀이는 쉬운데.. Queue에 객체(bf, bx, ny, nx) 생성해서 넣어도 되고..
*/
public class 방문길이 {
  public static void main(String[] args) {
    String dirs = "ULURRDLLU";
    //String dirs = "LULLLLLLU";
    int answer = 0;

    int[][][][] maps = new int[11][11][11][11];
    // (4,4)가 원점
    int by = 5;
    int bx = 5;
    int ny = 5;
    int nx = 5;
    for (int i=0; i<dirs.length(); i++) {
      by = ny;
      bx = nx;
      if (dirs.charAt(i) == 'L') {
        if (bx - 1 < 0) {
          continue;
        }
        nx = bx - 1;
      }
      else if (dirs.charAt(i) == 'R') {
        if (bx + 1 >= 11) {
          continue;
        }
        nx = bx + 1;
      }
      else if (dirs.charAt(i) == 'U') {
        if (by - 1 < 0) {
          continue;
        }
        ny = by - 1;
      }
      else if (dirs.charAt(i) == 'D') {
        if (by + 1 >= 11) {
          continue;
        }
        ny = by + 1;
      }
      if (maps[by][bx][ny][nx] == 0 && maps[ny][nx][by][bx] == 0) {
        answer++;
      }
      maps[by][bx][ny][nx]++;
      maps[ny][nx][by][bx]++;
    }
    System.out.println("ANSWER = "+answer);
  }
}
