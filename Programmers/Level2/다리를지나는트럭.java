package Programmers.Level2;
import java.util.LinkedList;
import java.util.Queue;
/*
★★★☆☆
cheat: O
2H
시간이 지나면 다리에서 빠져나가게 하는걸 어떻게 해야할지 고민하다가 옛날에 푼거 참고했다.
qEnterTime 존재만 힐끔하고 나머지는 내가 풀었당. 오래걸렸지만 ㅠㅠ
*/
public class 다리를지나는트럭 {
  public static void main(String[] args) {
    int truck_weights[] = {7, 4, 5, 6};
    int bridge_length = 2;
    int weight = 10;
    // int truck_weights[] = {10};
    // int bridge_length = 100;
    // int weight = 100;
    // int truck_weights[] = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
    // int bridge_length = 100;
    // int weight = 100;
    int answer = 0;

    Queue<Integer> qWeight = new LinkedList<>();
    Queue<Integer> qEnterTime = new LinkedList<>();
    int totalWeight = 0;
    int i = 0;
    int sec = 0;
    while (i==0 || !qEnterTime.isEmpty()){
      // 맨 앞 트럭이 다리를 다 건넌 경우
      if (qEnterTime.size() > 0 && qEnterTime.peek() + bridge_length == sec) {
        int firstWeight = qWeight.poll();
        qEnterTime.poll();
        totalWeight -= firstWeight;
      }

      // 현재 트럭이 다리에 올라갈 수 있는 경우
      if (i<truck_weights.length && totalWeight + truck_weights[i] <= weight) {
        qWeight.add(truck_weights[i]);
        qEnterTime.add(sec);
        totalWeight += truck_weights[i];
        i++;
      }
      sec++;

      //System.out.println(qWeight);
      //System.out.println(qEnterTime);
      //System.out.println("-----------");
    }
    answer = sec;
    //System.out.println("answer = "+ answer);
  }
}
