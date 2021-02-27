package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/*
★★☆☆☆
cheat: X
2H
순열 = 순서 O
조합 = 순서 X
조합을 구해야지! ex) 1, 2, 3 / 순서 O = (1, 2), (2, 1), (3, 1), (1, 3), (3, 2), (2, 3) / 순서 X = (1, 2), (1, 3), (2, 3)
문제는 쉬운데 누가누가 구현 빨리하나 대결임. 이런거 빨리 풀 수 있도록 준비하자..
*/
public class 메뉴리뉴얼_again {
  public static void main(String[] args) {
    String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
    int[] course = {2, 3, 4}; // 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 개수
    // String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
    // int[] course = {2, 3, 5};
    // String[] orders = {"XYZ", "XWY", "WXA"};
    // int[] course = {2, 3, 4};
    String[] answer = {};

    // 모든 순열 카운트해서 HashMap에 넣기
    for (int i=0; i<orders.length; i++) {
      for (int j=0; j<course.length; j++) {
        // 순열 길이 = course[j]
        boolean[] visited = new boolean[orders[i].length()];
        // orders[i]를 오름차순으로 정렬시킨다 (permu가 아닌 조합으로 풀기 위함)
        String splitS[] = orders[i].split("");
        Arrays.sort(splitS);
        String s = String.join("", splitS);
        combi(0, "", visited, s, course[j]);
      }
    }

    // 최대값 구하기
    HashMap<Integer, Integer> maxCnt = new HashMap<>();
    hm.forEach((key, value)->{
      if (!maxCnt.containsKey(key.length()) && value >= 2) {
        maxCnt.put(key.length(), value);
      }
      else if (maxCnt.containsKey(key.length()) && maxCnt.get(key.length()) <= value){
        maxCnt.put(key.length(), value);
      }
    });

    // 최대값에 해당하는거 answer에 저장
    ArrayList<String> ans = new ArrayList<>();
    hm.forEach((key, value)->{
      maxCnt.forEach((maxKey, maxValue)->{
        if (key.length() == maxKey && value == maxValue) {
          ans.add(key);
        }
      });
    });
    answer = ans.toArray(new String[0]); // String[0]은 뭐지
    Arrays.sort(answer);
    //for (int i=0; i<answer.length; i++)
      //System.out.println(answer[i]);
    //return answer;
  }

  static HashMap<String, Integer> hm = new HashMap<>();
  public static void combi(int depth, String s, boolean[] visited, String origin, int len) {
    if (depth == len) {
      if (hm.containsKey(s)) {
        hm.put(s, hm.get(s)+1);
      }
      else {
        hm.put(s, 1);
      }
      return ;
    }
    for (int i=depth; i<origin.length(); i++) {
        visited[i] = true;
        if (depth == 0 || (depth > 0 && s.charAt(depth-1) < origin.charAt(i)))
          combi(depth+1, s+origin.charAt(i), visited, origin, len);
        visited[i] = false;
    }
  }
}
