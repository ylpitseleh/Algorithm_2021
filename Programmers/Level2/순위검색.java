package Programmers.Level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
/*
미완성. 나중에 다시 풀기
*/
public class 순위검색 {
  static int[][] cases = new int[16][4];
  public static void main(String[] args) {
    // 모든 경우의수가 2*2*2*2 = 16 밖에 안 되니까 그냥 다 hashmap에 넣기
    String[] info = {"java backend junior pizza 150",
                     "python frontend senior chicken 210",
                     "python frontend senior chicken 150",
                     "cpp backend senior pizza 260",
                     "java backend junior chicken 80",
                     "python backend senior chicken 50"};
    String[] query = {"java and backend and junior and pizza 100", //1
                      "python and frontend and senior and chicken 200", //1
                      "cpp and - and senior and pizza 250", //1
                      "- and backend and senior and - 150", //1
                      "- and - and - and chicken 100", //2
                      "- and - and - and - 150"}; //4
    int[] answer = {};

    // - 인것 = 0, 문자열인것 = 1 로 4가지 경우의 수를 모두 구한다.
    int[] tmp = new int[4];
    makeAllCases(0, tmp);

    // HashMap에 Info 넣기
    HashMap<String, ArrayList<Integer>> hm = new HashMap<>(); // key = java backend junior pizza , value = 150
    for (int i=0; i<info.length; i++) {
      String infoSplit[] = info[i].split(" ");
      int infoScore = Integer.parseInt(infoSplit[4]); // 4번째 인덱스가 점수
      String hmKey = String.join(" ", infoSplit[0], infoSplit[1], infoSplit[2], infoSplit[3]); // 원소들 사이에 " "을 넣어줌
      if (hm.containsKey(hmKey)) {
        hm.get(hmKey).add(infoScore);
        hm.put(hmKey, hm.get(hmKey));
      }
      else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(infoScore);
        hm.put(hmKey, al);
      }
      // 미리 만들어놓은 16가지 경우의 수를 돌면서 1이면 문자열, 0이면 -를 String에 붙여서 hm에 넣는다.
      String[] casesList = new String[16]; // 모든 경우의 수를 넣을 배열
      for (int j=0; j<16; j++) {
        String str = ""; // 맨 끝에 공백 포함돼있음
        StringBuilder sb = new StringBuilder();
        for (int k=0; k<4; k++) {
          StringBuilder s = new StringBuilder();
          if (cases[j][k] == 0) {
            s.append(infoSplit[k]);
          }
          else if (cases[j][k] == 1) {
            s.append("-");
          }

          if (str.equals("")) { // -이 맨 앞이면
            sb.append(s+" ");
          }
          else {
            sb.append(s+" ");
          }
        }
        //casesList[j] = str.substring(0, str.length() - 1); // 마지막 공백 1글자 제거
        casesList[j] = sb.substring(0, sb.length() - 1); // 마지막 공백 1글자 제거
        System.out.println(casesList[j]);
      }

      for (int j=0; j<16; j++) {
        if (!casesList[j].equals(hmKey)) { // 경우의 수가 hmKey와 같지 않으면 현재 점수 추가
          if (hm.containsKey(casesList[j])) {
            hm.get(casesList[j]).add(infoScore);
            hm.put(casesList[j], hm.get(casesList[j]));
          }
          else {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(infoScore);
            hm.put(casesList[j], al);
          }
        }
      }
    }

    // hm.forEach((key, value)-> {
    //   System.out.println(String.format("[%s] %s", key, value));
    // });

    answer = new int[query.length];
    for (int i=0; i<query.length; i++) {
      String[] querySplit = query[i].replaceAll(" and ", " ").split(" ");
      String oneQuery = String.join(" ", querySplit[0], querySplit[1], querySplit[2], querySplit[3]);
      int queryScore = Integer.parseInt(querySplit[4]);
      if (hm.containsKey(oneQuery)) {
        // list의 점수들 중에 queryScore보다 같거나 큰게 몇 개인지 이진탐색 (안 하면 시초)
        answer[i] = binarySearch(queryScore, hm.get(oneQuery));
      }
    }
    System.out.println("answer");
    for (int i=0; i<answer.length; i++) {
      System.out.print(answer[i]+" ");
    }
  }

  static int cnt = 0;
  private static void makeAllCases(int depth, int[] tmp) {
    if (depth == 4) {
      for (int i=0; i<4; i++) {
        cases[cnt][i] = tmp[i];
      }
      cnt++;
      return;
    }
    tmp[depth] = 1;
    makeAllCases(depth+1, tmp);
    tmp[depth] = 0;
    makeAllCases(depth+1, tmp);
  }

  private static int binarySearch(int target, ArrayList<Integer> scores) {
    int start = 0;
    int end = scores.size();
    Collections.sort(scores);
    while (start < end) {
      int mid = (start + end) / 2;
      if (scores.get(mid) < target) {
        start = mid + 1;
      }
      else {
        end = mid;
      }
    }
    return scores.size() - start;
  }
}
