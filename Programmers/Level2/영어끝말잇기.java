package Programmers.Level2;

import java.util.HashSet;
/*
★★☆☆☆
cheat: X
0H 15M
Easy
*/
public class 영어끝말잇기 {
  public static void main(String[] args) {
    // int n = 3;
    // String words[] = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
    // int n = 5;
    // String words[] = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
    int n = 2;
    String words[] = {"hello", "one", "even", "never", "now", "world", "draw"};
    int[] answer = new int[2];
    HashSet<String> hs = new HashSet<>();
    hs.add(words[0]);
    int idx = -1;
    for (int i=1; i<words.length; i++) {
      if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || hs.contains(words[i])) {
        idx = i;
        break;
      }
      hs.add(words[i]);
    }
    if (idx == -1) {
      answer[0] = 0;
      answer[1] = 0;
    }
    else {
      answer[0] = idx % n + 1;
      answer[1] = idx / n + 1;
    }
    System.out.println(answer[0]+" "+answer[1]);
  }
}
