package Programmers.Level2;
/*
★☆☆☆☆
cheat: X
0H 15M
Easy
*/
public class 숫자의표현 {
  public static void main(String[] args) {
    int n = 15;
    int answer = 0;

    int start = 1;
    int end = 1;
    int sum = 0;
    while (end <= n) {
      if (sum < n) {
        sum += end;
        end++;
      }
      else if (sum > n) {
        sum -= start;
        start++;
      }
      else if (sum == n) {
        System.out.println("start = "+start+", end = "+end+" / sum = "+sum);
        answer++;
        sum -= start;
        start++;
        sum += end;
        end++;
      }
    }
    System.out.println("ANSWER = "+answer);
  }
}
