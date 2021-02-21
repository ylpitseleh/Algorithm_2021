package Programmers.Level2;

import java.util.ArrayList;

/*
★☆☆☆☆
cheat: X
0H 30M
순서 X => 조합
Easy
*/
public class 소수찾기 {
  public static void main(String[] args) {
    String numbers = "17";
    //String numbers = "4321";
    //String numbers = "011";
    int answer = 0;

    // 만들 수 있는 모든 경우 ArrayList에 넣기
    for (int i=1; i<=numbers.length(); i++) { // permu 길이
      boolean[] visited = new boolean[numbers.length()];
      permu(0, "", visited, numbers, i);
    }
    // 소수 구하기
    for (int i=0; i<al.size(); i++) {
      if (isPrime(al.get(i))) {
        answer++;
      }
    }
    System.out.println(answer);
  }

  static ArrayList<Integer> al = new ArrayList<>();
  public static void permu(int depth, String s, boolean[] visited, String numbers, int len) {
    if (depth == len) {
      int n = Integer.parseInt(s);
      if (!al.contains(n))
        al.add(n);
      return ;
    }
    for (int i=0; i<numbers.length(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        permu(depth+1, s+numbers.charAt(i), visited, numbers, len);
        visited[i] = false;
      }
    }
  }

  public static boolean isPrime(int num) {
    if (num < 2)
      return false;
    int n = 2;
    boolean primeFlag = true;
    while (n < num) {
      if (num % n == 0) {
        primeFlag = false;
        break ;
      }
      n++;
    }
    return primeFlag;
  }
}
