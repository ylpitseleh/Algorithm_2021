package Programmers.Level2;
/*
★★☆☆☆
cheat: X
2H
거의 두 시간 걸린거 실환가 ㅋㅋ
StringBuilder 쓰면 좀 더 간단하게 풀 수 있다. 마지막 원소가 equals연산에 포함이 안 돼서 짱구 굴리느라 힘들었다.
굳이 배열에 다 안 넣고 sb로 바로 전 꺼랑 연산하면서 풀 수 있다...
*/
public class 문자열압축 {
  public static void main(String[] args) {
    //String s = "aabbaccc";
    String s = "a";
    //String s = "ababcdcdababcdcd";
    //String s = "abcabcdede";
    //String s = "abcabcabcabcdededededede";
    //String s = "xababcdcdababcdcd";
    for (int i=1; i<=s.length()/2; i++) { // i개 단위로 자르기
      String substrs[] = new String[s.length()/i + (s.length()%i == 0 ? 0 : 1) + 1]; // i개 단위로 자른 문자열들 저장. 나머지가 0이 아니면 + 1 / +1 은 유효하지 않은 문자 하나 넣기 위해서
      int idx = 0;
      for (int j=0; j<s.length(); j+=i) { // i개 단위로 잘랐을 때 시작하는 첫 글자 index(s.len = 16, i=8일 때, 0, 8)
        String substr = s.substring(j, Math.min(j+i, s.length()));
        substrs[idx] = substr;
        idx++;
      }
      substrs[idx] = "!"; // 마지막 원소 equals 연산에 포함시키기 위해 마지막엔 유효하지 않은 문자 하나 넣어준다.
      makeResult(substrs);
    }
    answer = answer == Integer.MAX_VALUE? 1: answer; // s="a"일 때, 답은 1
    System.out.println(answer);
    // return answer;
  }

  private static int answer = Integer.MAX_VALUE;
  // substrs = {abc, abc, de, de}를 2abcdede로 만들기
  private static void makeResult(String substrs[]) {
    String result = "";
    int n = 1; // 2abcdede에서 2 역할
    for (int j=0; j<substrs.length-1; j++) {
      if (substrs[j].equals(substrs[j+1])) {
        n++;
      }
      else if (!substrs[j].equals(substrs[j+1])){
        if (n >= 2) {
          result += Integer.toString(n);
        }
        result += substrs[j];
        n = 1;
      }
    }
    answer = Math.min(answer, result.length());
  }
}
