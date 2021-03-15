package Programmers.Level2;

/*
★★★☆☆
cheat: O
0H 15M
input이 10억인데 bfs? 어림도 없지. => 입력값으로 힌트주는걸 꼭 보자...
효율 터지면 그냥 그건 틀린문제니까.....
로직은 내가 생각했던게 맞았음.
*/
public class 점프와순간이동 {
  public static void main(String[] args) {
    int N = 5;
    // int N = 6;
    // int N = 5000;
    int answer = 0;

    while (N > 0) {
      if (N % 2 == 0) {
        N /= 2;
      }
      else {
        N--;
        answer++;
      }
    }
    System.out.println(answer);
  }
}
