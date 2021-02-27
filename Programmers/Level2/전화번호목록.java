package Programmers.Level2;

import java.util.Arrays;
/*
☆☆☆☆☆
cheat: X
0H 20M
String.startsWith()
괄호안에 char 말고 String도 들어갈 수 있다!!
*/
public class 전화번호목록 {
  public static void main(String[] args) {
    //String[] phone_book = {"119", "97674223", "1195524421"};
    //String[] phone_book = {"123","456","789"};
    //String[] phone_book = {"3", "34"};
    String[] phone_book = {"12","123","1235","567","88"};
    boolean answer = true;

    Arrays.sort(phone_book);
    for (int i=0; i<phone_book.length; i++) {
      String str1 = phone_book[i];
      for (int j=i+1; j<phone_book.length; j++) {
        String str2 = phone_book[j];
        if (str1.length() > str2.length()) {
          continue;
        }
        if (str2.substring(0, str1.length()).equals(str1)) {
          answer = false;
          break;
        }
      }
      if (!answer) {
        break;
      }
    }
    System.out.println(answer);
  }
}
