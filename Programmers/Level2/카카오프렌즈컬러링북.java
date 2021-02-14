package Programmers.Level2;
/*
★★☆☆☆
cheat: X
0H 30M
오랜만에 그래프 풀려니까 오래걸렸다. 옛날 같았으면 5분컷인데 ^^
DFS로도, BFS로도 풀 수 있는 문제. 완전 기초
*/
public class 카카오프렌즈컬러링북 {
  private static int dy[] = {-1, 1, 0, 0};
  private static int dx[] = {0, 0, -1, 1};
  public static void main(String[] args) {
    int m = 6;
    int n = 4;
    int picture[][] = {{1, 1, 1, 0},
                       {1, 2, 2, 0},
                       {1, 0, 0, 1},
                       {0, 0, 0, 1},
                       {0, 0, 0, 3},
                       {0, 0, 0, 3}}; // (그림에 몇 개의 영역이 있는지 = 4, 가장 큰 영역은 몇 칸인지 = 5)
    int numberOfArea = 0; // 총 몇 개의 영역이 있는지
    int maxSizeOfOneArea = 0; // 가장 큰 영역의 크기

    boolean visited[][] = new boolean[m][n];
    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        if (picture[i][j] != 0 && !visited[i][j]) {
          numberOfArea++;
          size = 0;
          visited[i][j] = true;
          dfs(i, j, picture, visited);
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
      }
    }

    int answer[] = {};
    answer = new int[2];
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    // return answer;
  }

  static int size = 0; // 영역의 크기
  private static void dfs (int y, int x, int picture[][], boolean[][] visited) {
    size++;

    for (int i=0; i<4; i++) {
      int ny = dy[i] + y;
      int nx = dx[i] + x;
      if (ny >= 0 && ny < picture.length && nx >= 0 && nx < picture[0].length) {
        if (picture[ny][nx] == picture[y][x] && !visited[ny][nx]) {
          visited[ny][nx] = true;
          dfs(ny, nx, picture, visited);
        }
      }
    }
  }
}
