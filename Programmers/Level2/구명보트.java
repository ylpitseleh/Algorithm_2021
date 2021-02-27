package Programmers.Level2;

import java.util.Arrays;
/*
★★★☆☆
cheat: O
0H 40M
그리디 원리랑 방법은 알겠는데 구현이 잘 안 된다. 빡친다 쉬운건데ㅠ
*/
public class 구명보트 {
  public static void main(String[] args) {
    //int[] people = {70, 50, 80, 50}; // 50 50 70 80
    int[] people = {70, 80, 50};
    //int[] people = {10, 20, 30, 40, 80, 90};
    int limit = 100;
    int answer = 0;

    Arrays.sort(people);
    int i = 0;
    int j = people.length - 1;
    while (true) {
      if (i > j) {
        break;
      }
      int sum = people[i] + people[j];
      if (i == j) {
        sum = people[i];
      }
      System.out.println(i+" "+j);
      if (sum <= limit) {
        i++;
        j--;
        answer++;
        continue;
      }
      j--;
      answer++;
    }
    System.out.println(answer);
  }
}
