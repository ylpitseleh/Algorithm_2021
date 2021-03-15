package Programmers.Level2;

import java.util.Stack;
/*
★★★☆☆
cheat: O
1H 0M
시초떠서 그냥 답 봤다. 이런건 충분히 코테 나올 수 있고 스택으로 생각해서 풀어야하는데
이런거 테케 없이 문제 나오면 답도 없다. 스택, 큐 쓰는거 잘 하자...
*/
public class 짝지어제어하기 {
  public static void main(String[] args) {
    // String s = "baabaa";
     String s = "cdcd";
    int answer = 0;

    Stack<Character> st = new Stack<>();
    st.add(s.charAt(0));
    for (int i=1; i<s.length(); i++) {
      if (!st.isEmpty() && st.peek() == s.charAt(i)) {
        st.pop();
      }
      else {
        st.add(s.charAt(i));
      }
    }

    if (st.isEmpty()) {
      answer = 1;
    }
    else {
      answer = 0;
    }
    // return answer;
  }
}
