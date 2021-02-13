package Programmers.Level2;
/*
★★★☆☆
cheat: O
0H 40M
연산일것 같아서 풀이 봤는데 그냥 하드코딩으로 풀어도 되는거였다. 삼각형을 왼쪽으로 몰아서 직각삼각형으로 만들어서 푸는걸 꼭 생각해내야함.
https://minhamina.tistory.com/58
나랑 로직은 같은데 구현이 너무 깔끔하다. 다시 풀 땐 저렇게 풀면 될 것 같다. 저렇게 풀면 stage 변수도 안 써도 된다.
*/
public class 삼각달팽이 {
  public static void main(String[] args) {
    //int n = 4;
    //int n = 5;
    int n = 6;

    int map[][] = new int[n][n];
    int num = 1;
    int y = 0;
    int x = 0;
    int stage = 0; // 0단계(=y증가), 1단계(=x증가), 2단계(=x,y감소)
    for (int i=n; i>=1; i--) { // 6 5 4 3 2 1
      if (stage == 3)
        stage = 0;
      for (int j=0; j<i; j++) { // 6(0, 1, 2, 3, 4, 5) / 5(0, 1, 2, 3, 4)
        if (stage == 0)
          map[y++][x] = num;
        else if (stage == 1)
          map[y][x++] = num;
        else if (stage == 2)
          map[y--][x--] = num;
        num++;
      }
      if (stage == 0) {
        y -= 1;
        x += 1;
      }
      else if (stage == 1) {
        x -= 2;
        y -= 1;
      }
      else if (stage == 2) {
        x += 1;
        y += 2;
      }
      stage++;
    }
    int idx = 0;
    int answer[] = new int[num - 1];
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        if (map[i][j] == 0) {
          break;
        }
        else {
          answer[idx++] = map[i][j];
        }
      }
    }
    // return answer;
  }

}
