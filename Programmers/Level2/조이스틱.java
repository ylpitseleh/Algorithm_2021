package Programmers.Level2;
/*
★★★★☆
cheat: O
3H
순서대로 세기 vs 뒤로가서 세기
이걸 어떻게 구현할지 고민했는데 그냥 카운트로만 더해주면 되는거였다.. 이 부분만 보고 나머지는 내가 풀었다.
name.length()만큼 for문 돌면서 name.charAt(i)=='A' 면 거기부터 while문 돌면서 A 몇 개인지 세서 푸는 방법도 있다.
*/
public class 조이스틱 {
  public static void main(String[] args) {
    //String name = "JEROEN";
    //String name = "JAN";
    //String name = "JBAAAN"; //(5, 3)
    //String name = "JBAAN"; //(4, 3)
    //String name = "JBAN"; //(3, 3)
    //String name = "JBAEAAAEAAE"; //(10, 10) len = 10, 연속된 A = 3
    //String name = "JBAEAAAEN"; //(8, 8) len = 9, 연속된 A = 3
    //String name = "A";
    String name = "B";
    int answer = 0;

    // 조이스틱 위, 아래 이동
    int[] alpha = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                  13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    // 조이스틱 왼쪽, 오른쪽 이동 카운트 (Math.min(그냥 -> 순서대로 세기, 뒤로가서 세기))
    /*
    JBAAAN = Math.min(5, 3)
    JBAAN = Math.min(4, 3)
    JBAN = Math.min(3, 3)
    ex) JBCAAAN
    1) 그냥 -> 순서대로 세기
    name.length() - 1 = 6
    2) 뒤로가서 세기
    (name.length()-1) - 연속된 A 길이 + (연속된 A가 나오기 전까지 길이-1) = 5
    */

    int ACntStartIdx = -1;
    int ACnt = 0;
    int maxACnt = -1;
    for (int i=0; i<name.length(); i++) {
      // 연속된 A 카운트
      if (name.charAt(i) == 'A') {
        ACnt++;
        if (maxACnt < ACnt) {
          maxACnt = ACnt;
          ACntStartIdx = i - maxACnt + 1;
        }
      }
      else if (name.charAt(i) != 'A'){
        ACnt = 0;
      }
    }
    boolean aFlag = true;
    for (int i=0; i<name.length(); i++) {
      if (name.charAt(i) != 'A') {
        aFlag = false;
        break ;
      }
    }
    int leftRightCnt = 0;
    if (!aFlag) {
      if (maxACnt == -1)
        leftRightCnt = name.length() - 1;
      else
        leftRightCnt = Math.min(name.length()-1, (name.length()-1 - maxACnt + ACntStartIdx-1));
    }
    int upDownCnt = 0;
    for (int i=0; i<name.length(); i++) {
      upDownCnt += alpha[name.charAt(i)-'A'];
    }
    answer = leftRightCnt + upDownCnt;
    System.out.println(answer);
  }
}
