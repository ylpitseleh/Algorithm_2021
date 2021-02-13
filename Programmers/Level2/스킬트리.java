package Programmers.Level2;
/*
★★☆☆☆
cheat: X
0H 40M
skill.indexOf()했을 때
1, 2는 안 되고 0, 1, 2여야되는게 포인트
그거 말곤 easy
*/
public class 스킬트리 {
  public static void main(String[] args) {
    String skill = "CBD";
    String skill_trees[] = {"BACDE", "CBADF", "AECB", "BDA"};
    int answer = 0;

    for (int i=0; i<skill_trees.length; i++) {
      boolean ansFlag = true;
      String s = skill_trees[i];
      int skillIdx = 0;
      int skillChar = skill.charAt(skillIdx);
      for (int j=0; j<s.length(); j++) {
        char c = s.charAt(j);
        if (c == skillChar && skillIdx < skill.length() - 1) { // 무조건 C->B->D 순으로 나와야 하니까(B->D (X))
          skillChar = skill.charAt(++skillIdx);
        }
        else if (skill.indexOf(c) != -1 && c != skillChar) { // c가 skill에 있는데 순서가 오름차순이 아니면 땡탈락
          ansFlag = false;
          break ;
        }
      }
      if (ansFlag) {
        answer++;
      }
    }
    System.out.println(answer);
  }

}
