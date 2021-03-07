package Programmers.Level2;
/*
★☆☆☆☆
cheat: X
0H 40M
그냥.. 순열 사용한 구현..문제.. 쉬움
*/
public class 단체사진찍기 {
  public static void main(String[] args) {
    String[] data = {"N~F=0", "R~T>2"};
    int n = 2;
    // String[] data = {"M~C<2", "C~M>1"};
    // int n = 2;
    /*
    네오와 프로도는 나란히
    라이언은 튜브에게서 적어도 세 칸 이상 떨어져서
    */
    // A, C, F, J, M, N, R, T
    answer = 0; // 초기화 안 하면 틀렸다고 나옴. 쓰레기같은 프로그래머스
    char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    char[] res = new char[8];
    boolean[] visited = new boolean[8];
    permu(0, visited, res, members, data);
    System.out.println("answer = "+answer);
  }
  static int answer = 0;
  private static void permu(int depth, boolean[] visited, char[] res, char[] members, String[] data) {
    if (depth == res.length) {
      // for (int i=0; i<res.length; i++) {
      //   System.out.print(res[i]+" ");
      // }
      // System.out.println();
      String result = String.valueOf(res);
      boolean flag = true;
      for (int i=0; i<data.length; i++) {
        char a = data[i].charAt(0);
        char b = data[i].charAt(2);
        char sign = data[i].charAt(3);
        int idxDiff = Math.abs(result.indexOf(Character.toString(a)) - result.indexOf(Character.toString(b))) - 1;
        int n = data[i].charAt(4)-'0';
        if (sign == '=') {
          if (idxDiff != n) {
            flag = false;
            break;
          }
        }
        else if (sign == '>') {
          if (idxDiff <= n) {
            flag = false;
            break;
          }
        }
        else if (sign == '<') {
          if (idxDiff >= n) {
            flag = false;
            break;
          }
        }
      }
      if (flag) {
        answer++;
      }
      return;
    }
    for (int i=0; i<members.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        res[depth] = members[i];
        permu(depth+1, visited, res, members, data);
        visited[i] = false;
      }
    }
  }

}
