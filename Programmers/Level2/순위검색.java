package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
/*
미완성. 나중에 다시 풀기
*/
public class 순위검색 {
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

    HashMap<String, ArrayList<Integer>> hm = new HashMap<>(); // key = javabackendjuniorpizza, value = 150
    for (int i=0; i<info.length; i++) {
      String sp[] = info[i].split(" ");
      int score = Integer.parseInt(sp[sp.length-1]);
      String s = "";
      for (int j=0; j<sp.length-1; j++) {
        s += sp[j]+" ";
      }
      makeAllCases();
    }
    System.out.println(hm);

  }
  // '-'이 들어갈 수 있는 모든 경우의 수(16가지)를 만들어주는 메소드
  static ArrayList<Integer> al = new ArrayList<>();
  static ArrayList<Integer> total = new ArrayList<>();
  private static void makeAllCases() {
    if (al.size() == 4) {
      System.out.println(al);
      return ;
    }

    for (int i=0; i<2; i++) {
      al.add(i);
      makeAllCases();
      al.remove(al.size()-1);
    }
  }
}
