package Programmers.Level2;
/*
★★★★☆
cheat: O
2H
0이 자연수냐? 뒤질래?
첨에 테케 범위 안 보고 조합으로 풀었다가 시초나서 엎고 다시 그리디 + StringBuilder로 풀었다.
일단 2중 for문 범위 어디까지인지 구하는데 한 시간 정도 쓰고 질문에서 0도 자연수라고 본다길래 int max = 0으로 해놨던거 -1로 바꾸니까 정답 다 맞았다.
0을 자연수라고 하냐 문제 개 ㅂㅅ
*/
public class 큰수만들기 {
  public static void main(String[] args) {
    String number = "1924";
    int k = 2;
    // String number = "1231234";
    // int k = 3;
    // String number = "4177252841";
    // int k = 4;
    StringBuilder sb = new StringBuilder();

    int len = number.length() - k;
    int maxIdx = -1;
    for (int i=0; i<len; i++) {
      int max = -1;
      for (int j=maxIdx+1; j<=k+i; j++) {
        if (number.charAt(j)-'0' > max && maxIdx < j) {
          max = number.charAt(j)-'0';
          maxIdx = j;
        }
      }
      sb.append(number.charAt(maxIdx));
    }
    String answer = sb.toString();
    System.out.println(answer);
  }
}
