package Programmers.Level2;

import java.util.Arrays;
/*
☆☆☆☆☆
cheat: X
0H 5M
*/
public class 최댓값과최솟값 {
  public static void main(String[] args) {
    String s = "1 2 3 4";
    // String s = "-1 -2 -3 -4";
    // String s = "-1 -1";
    String answer = "";

    String str[] = s.split(" ");
    int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(nums);
    answer += Integer.toString(nums[0])+" "+Integer.toString(nums[nums.length-1]);
    System.out.println(answer);
  }
}
