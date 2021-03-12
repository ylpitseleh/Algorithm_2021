package Programmers.Level2;

import java.util.ArrayList;

public class 수식최대화 {
  public static void main(String[] args) {
    String expression = "100-200*300-500+20";
    //String expression = "50*6-3*2";
    int answer = 0;

    String[] str = expression.split("\\*|-|\\+");
    ArrayList<Integer> numsOrigin = new ArrayList<>();
    for (int i=0; i<str.length; i++) {
      numsOrigin.add(Integer.parseInt(str[i]));
    }
    ArrayList<Character> opersOrigin = new ArrayList<>();
    for (int i=0; i<expression.length(); i++) {
      if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
        opersOrigin.add(expression.charAt(i));
      }
    }

    // String[] orders = {"+-*", "+*-", "*+-", "*-+", "-*+", "-+*",};
    // for (int i=0; i<orders.length; i++) {
    //   char first = orders[i].charAt(0); // 우선순위 1위
    //   char second = orders[i].charAt(1); // 우선순위 2위
    //   char third = orders[i].charAt(2); // 우선순위 3위
    //   ArrayList<Integer> nums = new ArrayList<>();
    //   nums.addAll(numsOrigin);
    //   ArrayList<Character> opers = new ArrayList<>();
    //   opers.addAll(opersOrigin);
    //   int idx = 0;
    //   while (opers.contains(opers.get(idx))) {

    //   }
    // }

  }
}