package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 15M
1단계급 문제. 다시 볼 필요도 없음
*/
public class h_index {
  public static void main(String[] args) {
    // 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-index
    int[] citations = {3, 0, 6, 1, 5};
    int answer = 0;

    int n = citations.length;
    int avg = 0;
    for (int i=0; i<citations.length; i++) {
      avg += citations[i];
    }
    avg /= n;
    for (int i=avg; i>=1; i--) { // h번
      int under = 0;
      int over = 0;
      for (int j=0; j<n; j++) {
        if (citations[j] >= i) {
          over++;
        }
        else {
          under++;
        }
      }
      if (under <= i && over >= i) {
        answer = i;
        break ;
      }
    }
    System.out.println(answer);
  }
}
