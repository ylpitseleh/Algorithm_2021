package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 5M
*/
public class 피보나치수 {
  public static void main(String[] args) {
     int n = 3;
    // int n = 5;
    int answer = 0;
    // 1 1 2 3 5 8 13 21 ..
    int[] fibo = new int[n+1];
    fibo[1] = 1;
    if (n >= 2) {
      fibo[2] = 1;
    }
    for (int i=3; i<=n; i++) {
      fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
    }
    System.out.println(fibo[n]);
  }
}
