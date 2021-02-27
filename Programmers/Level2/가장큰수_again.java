package Programmers.Level2;

import java.util.Arrays;
import java.util.Comparator;
/*
★★★★☆
cheat: O
0H 30M
그냥 베낌. String도 비교해서 정렬할 수 있다는거 기억해야 할 듯.
Comparable, Comparator를 잘 써보자!
다음에 다시 풀기
*/
public class 가장큰수_again {
  public static void main(String[] args) {
    int[] numbers = {6, 10, 2};
    String answer = "";

    String strs[] = new String[numbers.length];
    for (int i=0; i<numbers.length; i++) {
			strs[i] = Integer.toString(numbers[i]);
    }

    Arrays.sort(strs, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);
      }
    });

    if (strs[0].equals("0")) { // strs = {0} 일 때
      answer += "0";
      //return answer;
    }
    for (int i=0; i<strs.length; i++)
      answer += strs[i];
    System.out.println(answer);
    //return answer;
  }
}
