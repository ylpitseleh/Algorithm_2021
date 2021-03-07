package Programmers.Level2;

import java.util.Stack;
/*
☆☆☆☆☆
cheat: X
0H 5M
Easy
*/
public class 올바른괄호 {
  public static void main(String[] args) {
    //String s = "()()";
    // String s = "(())()";
    // String s = ")()(";
     String s = "(()(";
    boolean answer = true;

    Stack<Character> st = new Stack<>();
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) == '(') {
        st.add('(');
      }
      else {
        if (st.isEmpty()) {
          answer = false;
          break;
        }
        st.pop();
      }
    }
    if (!st.isEmpty()) {
      answer = false;
    }
    System.out.println(answer);
  }
}
