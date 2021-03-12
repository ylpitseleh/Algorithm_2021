package Programmers.Level2;
/*
☆☆☆☆☆
cheat: X
0H 20M
toUpperCase(), toLowerCase() 써도 됨.
*/
public class JadenCase문자열만들기 {
  public static void main(String[] args) {
    //String s = "3people unFollowed me";
     String s = "for the last week";
    String answer = "";

    String strSplit[] = s.split(" ");
    for (int i=0; i<strSplit.length; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j=0; j<strSplit[i].length(); j++) {
        if (j == 0) {
          if (strSplit[i].charAt(j) >= 'a' && strSplit[i].charAt(j) <= 'z') {
            sb.append(Character.toString(strSplit[i].charAt(j)-32));
          }
          else {
            sb.append(Character.toString(strSplit[i].charAt(j)));
          }
        }
        else {
          if (strSplit[i].charAt(j) >= 'A' && strSplit[i].charAt(j) <= 'Z') {
            sb.append(Character.toString(strSplit[i].charAt(j)+32));
          }
          else {
            sb.append(Character.toString(strSplit[i].charAt(j)));
          }
        }
      }
      answer += sb;
      answer += " ";
    }
    answer = answer.substring(0, answer.length()-1);
    if (s.charAt(s.length()-1) == ' ') {
      answer += " ";
    }
    System.out.println(answer);
  }
}
