package Programmers.Level2;

import java.util.ArrayList;
import java.util.HashMap;
/*
★☆☆☆☆
cheat: X
0H 20M
*/
public class 오픈채팅방 {
  public static void main(String[] args) {
    String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
    String[] answer = {};

    HashMap<String, String> hm = new HashMap<>();
    for (int i=0; i<record.length; i++) {
      String[] recordSplit = record[i].split(" ");
      String act = recordSplit[0];
      String id = recordSplit[1];
      String name = "";
      if (!act.equals("Leave")) {
        name = recordSplit[2];
      }
      if (act.equals("Enter")) {
        hm.put(id, name);
      }
      else if (act.equals("Change")) {
        hm.put(id, name);
      }
    }

    ArrayList<String> ansAl = new ArrayList<>();
    for (int i=0; i<record.length; i++) {
      String[] recordSplit = record[i].split(" ");
      String act = recordSplit[0];
      String id = recordSplit[1];
      String name = "";
      if (!act.equals("Leave")) {
        name = recordSplit[2];
      }
      if (act.equals("Enter")) {
        ansAl.add(hm.get(id)+"님이 들어왔습니다.");
      }
      else if (act.equals("Leave")) {
        ansAl.add(hm.get(id)+"님이 나갔습니다.");
      }

    }
    System.out.println(hm);
    System.out.println(ansAl);
    answer = new String[ansAl.size()];
    for (int i=0; i<ansAl.size(); i++) {
      answer[i] = ansAl.get(i);
    }
  }
}
