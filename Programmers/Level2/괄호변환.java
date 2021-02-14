package Programmers.Level2;

import java.util.Stack;
/*
★★☆☆☆
cheat: X
1H 20M
무시무시해 보이지만 문제에 나와있는대로 구현만 하면 끝..
괄호 )( => () 반대방향으로 변환하는거라던가
리팩토링 할 수 있겠지만 귀찮다.. 답 맞은걸로 감사
*/
public class 괄호변환 {
  public static void main(String[] args) {
    String p = "(()())()";
    //String p = ")(";
    //String p = "()))((()";

    String answer = "";
    // (()))( 균형잡힌 괄호 문자열
    // (())() 올바른 괄호 문자열

    answer = divide(p);
    System.out.println("ANSWER = "+answer);
  }
  private static String answer = "";

  private static String divide(String w) {
    if (w.equals(""))
      return "";

    String u = "";
    String v = "";
    int rightCnt = 0; // (
    int leftCnt = 0; // )
    boolean correctFlag = false; // 올바른 괄호 문자열 ()()  (()) )(()
    Stack<Character> st = new Stack<>(); // (가 있으면 pop, 없으면 짝이 안 맞는 것
    for (int i=0; i<w.length(); i++) {
      if (w.charAt(i) == '(') {
        rightCnt++;
        st.add('(');
      }
      else if (w.charAt(i) == ')') {
        leftCnt++;
        if (!st.isEmpty() && st.peek() == '(') {
          st.pop();
        }
      }
      if (rightCnt == leftCnt) { // for문 처음부터 돌렸을 때 첫번째 나오는 균형잡힌 문자열
        u = w.substring(0, i+1);
        v = w.substring(i+1, w.length());
        if (st.isEmpty()) { // 스택이 비어있으면 올바른 괄호 문자열
          correctFlag = true;
        }
        break ;
      }
    }
    if (correctFlag) { // u가 올바른 괄호 문자열이라면
      return (u + divide(v));
    }
    else { // u가 올바른 괄호 문자열이 아니라면
      String str = "(";
      v = divide(v);
      str += v;
      str += ')';
      u = u.substring(1, u.length()-1);
      String newU = "";
      for (int i=0; i<u.length(); i++) {
        if (u.charAt(i) == '(')
          newU += ')';
        else
          newU += '(';
      }
      u = newU;
      str += newU;
      return str;
    }
  }

}
