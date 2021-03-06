package LeetCode;

import java.util.ArrayList;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {
  public static void main(String[] args) {
    int candies[] = {1, 2, 3, 2, 4};
    int extraCandies = 3;


    int max = 0;
    for (int i=0; i<candies.length; i++) {
      max = Math.max(max, candies[i]);
    }
    ArrayList<Boolean> answer = new ArrayList<>();
    for (int i=0; i<candies.length; i++) {
      if (candies[i] + extraCandies >= max) {
        answer.add(true);
      }
      else {
        answer.add(false);
      }
    }
    // return answer;
  }
}
