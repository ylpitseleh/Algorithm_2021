package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 20M
Easy
*/
public class 카펫 {
  public static void main(String[] args) {
    int brown = 10;
    int yellow = 2;
    // int brown = 8;
    // int yellow = 1;
    // int brown = 24;
    // int yellow = 24;
    // int brown = 12;
    // int yellow = 4;
    int answer[] = new int[2];

    int total = brown + yellow;
    int w = yellow + 2;
    int h = total / w;
    while (true) {
      if (total % w == 0 && h >= 3 && w * h == total && (h-2)*(w-2) == yellow) {
        break;
      }
      w--;
      h = total / w;
    }
    answer = new int[2];
    answer[0] = w;
    answer[1] = h;
    System.out.println(answer[0]+" "+answer[1]);
  }

}
