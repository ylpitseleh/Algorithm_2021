package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
★★★★☆
cheat: O
2H 0M
공포의 다익스트라.. 그냥 패턴을 외우는게 낫겠다.
다익스트라 = 한 정점에서 나머지 정점까지 최단 거리를 구할 때. 음수값은 계산 못함
          이차원 배열 쓰는 방법, ArrayList&PQ로 푸는 방법 있는데 후자가 빠르니 후자만 외우지뭐.
플로이드 와샬 = 각 정점간 최단 경로를 구할 때. 음수값 계산 가능

이해는 했다. 며칠뒤에 첨부터 다시 짜라고 한다면 ..?
*/
public class 배달_again_다익스트라 {
  static ArrayList<Pair>[] a;
	static int d[]; // distance
	static class Pair implements Comparable<Pair>{
		int dest; // 도착지
		int cost; // 비용
		Pair (int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
		@Override // pq에 비용이 적은 것 우선
		public int compareTo(Pair p) {
			return this.cost - p.cost;
		}
	}
  public static void main(String[] args) {
    // int N = 5; // 마을 개수
    // int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
    // int K = 3; // K 이하의 시간
    int N = 6;
    int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
    int K = 4;

    int answer = 0;
    a = new ArrayList[N];
		for (int i=0; i<N; i++)
			a[i] = new ArrayList<Pair>();
		for (int i=0; i<road.length; i++) {
			a[road[i][0]-1].add(new Pair(road[i][1]-1, road[i][2]));
      a[road[i][1]-1].add(new Pair(road[i][0]-1, road[i][2]));
		}
		d = new int[N]; // 0 부터 N까지 최소 비용
		Arrays.fill(d, Integer.MAX_VALUE);
		dijkstra(0);
		for (int i=0; i<N; i++) {
			if (d[i] <= K)
				answer++;
    }
    System.out.println(answer);
  }

  private static void dijkstra (int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		d[start] = 0;
		pq.add(new Pair(start, 0));

		while (!pq.isEmpty()) {
			Pair p = pq.poll();

			int cur = p.dest;
			int dist = p.cost;
			if (d[cur] < dist)
				continue ;
      for (int i=0; i<a[cur].size(); i++) { // a[0]에 있는건 다 넣음. 뭘 넣어도 MAX보단 작으니까
        // 뭐가 나와도 a[0]과 연결된거니까 next를 향하는곳이 현재(d[])보다 작으면 d[]를 갱신해준다.
				int next = a[cur].get(i).dest; // 선택된 노드의 인접 노드
				int nextDist = dist + a[cur].get(i).cost;
				if (nextDist < d[next]) {
          d[next] = nextDist;
          System.out.println(next+", "+a[cur].get(i).cost);
					pq.add(new Pair(next, nextDist));
				}
			}
		}
	}
}
