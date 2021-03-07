package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 15M
Easy
*/
public class 이진변환반복하기 {
  public static void main(String[] args) {
    // String s = "0111010";
    // String s = "110010101001";
    // String s = "01110";
     String s = "1111111";
    int[] answer = {};

    int cnt = 0;
    int removedZero = 0;
    String str2 = "";
    while (true) {
      if (s.equals("1")) {
        break;
      }
      int befLen = s.length();
      String str1 = s.replaceAll("0", "");
      int aftLen = str1.length();
      str2 = Integer.toBinaryString(str1.length());
      System.out.println(str2);
      s = str2;
      removedZero += befLen - aftLen;
      cnt++;
    }
    answer = new int[2];
    answer[0] = cnt;
    answer[1] = removedZero;
    System.out.println("ANSWER = "+answer[0]+" "+answer[1]);
  }
}
