package LeetCode;

public class _53_Maximum_Subarray {
  public static void main(String[] args) {
    //int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] nums = {-2, -1};
    int answer = 0;

    int startIdx = 0;
    int endIdx = 0;
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i=0; i<nums.length; i++) {
      sum += nums[i];
      if (sum > max) {
        endIdx = i;
        //System.out.println(endIdx);
        max = sum;
      }
    }
    startIdx = endIdx;
    sum = nums[endIdx];
    for (int i=startIdx; i>=0; i--) {
      sum += nums[i];
      if (sum > max) {
        startIdx = i;
        //System.out.println(startIdx);
        max = sum;
      }
    }
    for (int i=startIdx; i<=endIdx; i++) {
      answer += nums[i];
    }
    System.out.println(startIdx+" "+endIdx);
    System.out.println(answer);
  }
}
