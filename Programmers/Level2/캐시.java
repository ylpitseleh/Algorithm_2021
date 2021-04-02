package Programmers.Level2;

public class 캐시 {
  public static void main(String[] args) {
    int cacheSize = 2;
    String cities[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
    int answer = 0;
    if (cacheSize == 0) {
      answer = cities.length * 5;
      // return answer;
    }

    String[] cache= new String[cacheSize];
    int lru[] = new int[cacheSize];
    for (int i=0; i<cacheSize; i++) {
      cache[i] = ""; // String 초기화
      lru[i] = -1; //index가 0일 수도 있으니까
    }

    for (int i=0; i<cities.length; i++) {
      boolean cacheHit = false;
      for (int j=0; j<cacheSize; j++) {
        if (cache[j].toUpperCase().equals(cities[i].toUpperCase())) { // 캐시 hit
          lru[j] = i;
          cacheHit = true;
          answer++;
        }
      }
      if (!cacheHit) { // 캐시 miss
        int min = cities.length; // 최대값
        int minIdx = -1;
        for (int j=0; j<cacheSize; j++) {
          if (min > lru[j]) {
            min = lru[j];
            minIdx = j;
          }
        }
        cache[minIdx] = cities[i];
        lru[minIdx] = i;
        answer += 5;
      }
    }
    // return answer;
    System.out.println(answer);
  }
}
