package Programmers.Level2;
/*
★★★★★
cheat: O
2H
재귀 넘나 어려운거.,...
풀이 보고 재귀 어떻게 돌아가는지 일일이 그려보니까 그렇구나 싶긴 한데 
비슷한 문제를 내가 풀 수 있을까..?
*/
public class 타겟넘버_again {
  public static void main(String[] args) {
    int[] numbers = {1, 1, 1, 1, 1};
    int target = 3;

    dfs(0, target, numbers);
    System.out.println("answer = "+answer);
  }
  static int answer = 0;
  private static void dfs(int depth, int target, int[] numbers) {
    if (depth == numbers.length) {
      int sum = 0;
      for (int i=0; i<numbers.length; i++) {
        System.out.print(numbers[i]+" ");
        sum += numbers[i];
      }
      System.out.println();
      if (sum == target) {
        answer++;
      }
      return;
    }

    numbers[depth] *= 1;
    dfs(depth+1, target, numbers);

    numbers[depth] *= -1;
    dfs(depth+1, target, numbers);
  }
}