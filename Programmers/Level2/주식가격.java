package Programmers.Level2;
/*
★★★★☆
cheat: O
2H
PQ 쓰고 오만 방정 떨었는데 생각해보니 PQ 써서 푸는게 아니었다..
"문제를 잘 읽자."
그냥은 지나가는 개도 풀겠지만 스택 써서 해결하는건 이해를 못하겠다...흑흑...흑...
*/
public class 주식가격 {
  public static void main(String[] args) {
    int prices[] = {1, 2, 3, 2, 3};
    int len = prices.length;
    int answer[] = new int[prices.length];

    for (int i=0; i<len; i++) {
      int cnt = 0;
      for (int j=i+1; j<len; j++) {
        cnt++;
        if (prices[i] > prices[j]) {
          break ;
        }
      }
      answer[i] = cnt;
    }
    //return answer;
  }
}
