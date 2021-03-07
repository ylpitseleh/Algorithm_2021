package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/*
☆☆☆☆☆
cheat: X
0H 20M
Easy
*/
public class 튜플 {
  public static void main(String[] args) {
    // String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
    // String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
    // String s = "{{20,111},{111}}";
    // String s = "{{123}}";
     String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
    int[] answer = {};

    String[] str = s.replaceAll("\\{", "").split("},");
    str[str.length-1] = str[str.length-1].substring(0, str[str.length-1].length()-2); // 맨 뒤에 붙은 }} 없애기
    // 문자열 길이 순으로 정렬
    Arrays.sort(str, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
          return s1.length() - s2.length();
      }
    });

    ArrayList<Integer> ansAl = new ArrayList<>();
    for (int i=0; i<str.length; i++) {
      String[] numSplit = str[i].split(",");
      for (int j=0; j<numSplit.length; j++) {
        if (!ansAl.contains(Integer.parseInt(numSplit[j]))) {
          ansAl.add(Integer.parseInt(numSplit[j]));
        }
      }
    }
    System.out.println(ansAl);
    answer = new int[ansAl.size()];
    for (int i=0; i<ansAl.size(); i++) {
      answer[i] = ansAl.get(i);
    }
  }
}
