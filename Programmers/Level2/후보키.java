package Programmers.Level2;

import java.util.ArrayList;

public class 후보키 {
  public static void main(String[] args) {
    String[][] relation = {{"100","ryan","music","2"}, {"200","apeach","math","2"}, {"300","tube","computer","3"}, {"400","con","computer","4"}, {"500","muzi","music","3"}, {"600","apeach","music","2"}};
    int result = 2;

    // 컬럼명으로 만들 수 있는 모든 경우의 수를 조합으로 구한다.
    ArrayList<int[]> allCases = new ArrayList<>();
    int columnSize = relation[0].length;
    int[] nums = new int[columnSize];
    for (int i=0; i<columnSize; i++) {
      nums[i] = i+1;
    }
    for (int i=1; i<=columnSize; i++) {
      int[] ans = new int[i];
      boolean[] visited = new boolean[i];
      combi(0, nums, ans, visited, 0);
    }
  }

  private static void combi(int depth, int[] nums, int[] ans, boolean[] visited, int start) {
    if (depth == ans.length) {
      for (int i=0; i<ans.length; i++) {
        System.out.print(ans[i]+" ");
      }
      System.out.println();
      return;
    }
    for (int i=start; i<nums.length; i++) {
      visited[i] = true;
      ans[depth] = nums[i];
      combi(depth+1, nums, ans, visited, i+1);
      visited[i] = false;
    }
  }
}
