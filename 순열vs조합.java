public class 순열vs조합 {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    boolean[] visited = new boolean[nums.length];
    int[] ans = new int[2];
    permu(0, visited, nums, ans);
    System.out.println("-------------");
    visited = new boolean[nums.length];
    ans = new int[2];
    combi(0, visited, nums, ans, 0);
  }
  // 순열
  private static void permu(int depth, boolean[] visited, int[] nums, int[] ans) {
    if (depth == ans.length) {
      for (int i=0; i<ans.length; i++) {
        System.out.print(ans[i]+" ");
      }
      System.out.println();
      return ;
    }
    for (int i=0; i<nums.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        ans[depth] = nums[i];
        permu(depth+1, visited, nums, ans);
        visited[i] = false;
      }
    }
  }
  // 조합
  private static void combi(int depth, boolean[] visited, int[] nums, int[] ans, int start) {
    if (depth == ans.length) {
      for (int i=0; i<ans.length; i++) {
        System.out.print(ans[i]+" ");
      }
      System.out.println();
      return ;
    }
    // start = 전에 끝난 것 보다 +1한 인덱스에서 시작해줘야 한다.
    for (int i=depth; i<nums.length; i++) {
      visited[i] = true;
      ans[depth] = nums[i];
      combi(depth+1, visited, nums, ans, i+1);
      visited[i] = false;
    }
  }
}
