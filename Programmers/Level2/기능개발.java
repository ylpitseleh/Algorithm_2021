package Programmers.Level2;

import java.util.ArrayList;
/*
★☆☆☆☆
cheat: X
0H 40M
그냥 졸라 쉬움..
*/
public class 기능개발 {
  public static void main(String[] args) {
    int progresses[] = {93, 30, 55};
    int speeds[] = {1, 30, 5};
    // int progresses[] = {95, 90, 99, 99, 80, 99};
    // int speeds[] = {1, 1, 1, 1, 1, 1};
    int answer[] = {};

    int len = progresses.length;
    int daysLeft[] = new int[len];
    ArrayList<Integer> ansAl = new ArrayList<>();

    for (int i=0; i<len; i++) {
      daysLeft[i] = (100 - progresses[i]) / speeds[i];
      if ((100 - progresses[i]) % speeds[i] != 0) {
        daysLeft[i]++;
      }
    }

    int beforeVal = daysLeft[0];
    int ans = 1;
    for (int i=1; i<len; i++) {
      if (beforeVal >= daysLeft[i]) {
        ans++;
      }
      else {
        ansAl.add(ans);
        ans = 1;
        beforeVal = daysLeft[i];
      }
    }
    ansAl.add(ans);

    answer = new int[ansAl.size()];
    for (int i=0; i<ansAl.size(); i++) {
      answer[i] = ansAl.get(i);
    }
    // return answer;
  }

}
