package Programmers.Level2;

public class 땅따먹기 {
  public static void main(String[] args) {
    int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
    int answer = 0;

    for (int i=1; i<land.length; i++) {
      for (int j=0; j<4; j++) {
        int max = 0;
        for (int k=0; k<4; k++) {
          if (k != j) {
            max = Math.max(max, land[i-1][k]);
          }
        }
        land[i][j] += max;
        answer = Math.max(answer, land[i][j]);
      }
    }


    for (int i=0; i<land.length; i++) {
      for (int j=0; j<4; j++) {
        System.out.print(land[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println(answer);
  }
}
