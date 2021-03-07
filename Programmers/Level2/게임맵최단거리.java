package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;
/*
☆☆☆☆☆
cheat: X
0H 15M
Easy
*/
public class 게임맵최단거리 {
  static int dy[] = {-1, 1, 0, 0};
  static int dx[] = {0, 0, -1, 1};
  static Queue<Pos> q = new LinkedList<>();
  static class Pos {
    int y;
    int x;
    Pos (int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
  public static void main(String[] args) {
    //int maps[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
    int maps[][] = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

    int answer = 0;
    int h = maps.length;
    int w = maps[0].length;
    boolean[][] visited = new boolean[h][w];
    int[][] dist = new int[h][w];
    bfs(0, 0, visited, dist, maps, h, w);
    if (dist[h-1][w-1] == 0) {
      answer = -1;
    }
    else {
      answer = dist[h-1][w-1];
    }
    for (int i=0; i<h; i++) {
      for (int j=0; j<w; j++) {
        System.out.print(dist[i][j]+" ");
      }
      System.out.println();
    }
  }
  private static void bfs(int y, int x, boolean[][] visited, int[][] dist, int[][] maps, int h, int w) {
    q.add(new Pos(0, 0));
    dist[0][0] = 1;

    while (!q.isEmpty()) {
      Pos p = q.poll();
      for (int i=0; i<4; i++) {
        int ny = p.y + dy[i];
        int nx = p.x + dx[i];

        if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
          continue;
        }
        if (visited[ny][nx] || maps[ny][nx] == 0) {
          continue;
        }
        q.add(new Pos(ny, nx));
        visited[ny][nx] = true;
        dist[ny][nx] = dist[p.y][p.x] + 1;
      }
    }
  }
}
