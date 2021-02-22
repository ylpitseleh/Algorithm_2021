package Programmers.Level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 더맵게 {
  public static void main(String[] args) {
    //int scoville[] = {1, 2, 3, 9, 10, 12};
    int scoville[] = {0, 1};
    int K = 7;
    int answer = 0;

    // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int i=0; i<scoville.length; i++) {
      pq.add(scoville[i]);
    }
    System.out.println(pq);
    while (pq.peek() < K && pq.size() >= 2) {
      Integer a = pq.poll();
      Integer b = pq.poll();
      int mix = a + (b*2);

      pq.add(mix);
      answer++;
    }
    if (pq.peek() < K)
      answer = -1;
    System.out.println(pq);


    System.out.println(answer);
  }
}
