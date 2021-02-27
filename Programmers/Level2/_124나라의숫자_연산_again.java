package Programmers.Level2;
/*
★★★☆☆
cheat: O
0H 20M
그냥 풀이 봐버림
n이 5억 이하
= 재귀로 풀면 효율성 통과 못 하는 문제
이런 연산문제 코테엔 안 나오겠지 ㅎ..나오면 시간 궤많이 쓸 것 같다.
*/
public class _124나라의숫자_연산_again {
  public static void main(String[] args) {
    //int n = 1;
    //int n = 2;
    //int n = 3;
    int n = 4;
    String answer = "";

    String[] num = {"4", "1", "2"};
    while (n > 0) {
      answer = num[n % 3] + answer;
      n = (n - 1) / 3;
    }
    System.out.println(answer);
  }
}
