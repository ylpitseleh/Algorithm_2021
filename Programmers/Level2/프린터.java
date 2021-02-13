package Programmers.Level2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/*
★★★☆☆
cheat: X
1H
나머지 인쇄 대기 목록에서 가장 앞에 있는 문서보다 중요도가 높은 문서가 한 개라도 존재하면 대기목록에 가장 마지막에 넣습니다. = PQ라고 생각했다.
PQ(굳이 안 써도 됨)랑 Q랑 둘다 써서 풀었다. 뭔가 내 머리로 풀었다기보다 옛날에 푼게 기억에 남았던 것 같다.
근데 어차피 인덱스는 중요하지 않고 나보다 큰게 있냐 없냐만 중요해서 굳이 PQ에 idx까지 넣어서 안 하고 그냥 배열만 써도 된다.
*/
class Num implements Comparable<Num>{
  int val;
  int idx;
  Num (int val, int idx) {
    this.val = val;
    this.idx = idx;
  }
  // val(우선순위) 오름차순, val이 같으면 Idx 오름차순
  @Override
  public int compareTo (Num n) {
    return (this.val < n.val)? 1 : ((this.val == n.val)? 0 : -1);
    // if (this.val < s.val) {
    //   return 1;
    // }
    // else if (this.val == s.val) {
    //   if (this.idx < s.idx) {
    //     return 1;
    //   }
    // }
    // return -1;
  }
}

public class 프린터 {
  public static void main(String[] args) {
    int[] priorities = {2, 1, 3, 2};
    //int[] priorities = {1, 1, 9, 1, 1, 1};
    //int[] priorities = {5, 6, 1, 3, 2, 4};
    int location = 2;
    int answer = 0;

    // 그냥 Queue
    Queue<Num> q = new LinkedList<>();
    // 우선순위 기준 내림차순으로 정렬된 PriorityQueue
    PriorityQueue<Num> pq = new PriorityQueue<>();
    for (int i=0; i<priorities.length; i++) {
      q.add(new Num(priorities[i], i));
      pq.add(new Num(priorities[i], i));
    }

    int ansArr[] = new int[priorities.length];
    int i = 1;
    while (!q.isEmpty()) {
      Num qPoll = q.poll();
      Num pqPoll = pq.poll();
      // 현재 큐의 가장 앞에 있는 원소의 우선순위가 가장 크면
      if (qPoll.val == pqPoll.val) {
        ansArr[qPoll.idx] = i;
        i++;
      }
      // 아니면 다시 넣기
      else {
        q.add(qPoll);
        pq.add(pqPoll);
      }
    }
    answer = ansArr[location];
    System.out.println(answer);
    // return answer;
  }
}
