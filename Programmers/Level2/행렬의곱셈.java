package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 10M
*/
public class 행렬의곱셈 {
  public static void main(String[] args) {
    int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
    int[][] arr2 = {{3, 3}, {3, 3}};
    int[][] answer = {};
    answer = new int[arr1.length][arr1[0].length];

    for (int i=0; i<answer.length; i++) {
      for (int j=0; j<answer[0].length; j++) {
        int val = 0;
        for (int k=0; k<arr2.length; k++) {
          val += arr1[i][k] * arr2[k][j];
        }
        answer[i][j] = val;
      }
    }

    for (int i=0; i<answer.length; i++) {
      for (int j=0; j<answer[0].length; j++) {
        System.out.print(answer[i][j]+" ");
      }
      System.out.println();
    }
  }
}
