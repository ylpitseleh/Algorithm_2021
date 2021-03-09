public class _17_Letter_Combinations_of_a_Phone_Number {
  public static void main(String[] args) {
    int max = 0;
    for (int i=0; i<candies.length; i++) {
      max = Math.max(max, candies[i]);
    }
    ArrayList<Boolean> answer = new ArrayList<>();
    for (int i=0; i<candies.length; i++) {
      if (candies[i] + extraCandies >= max) {
        answer.add(true);
      }
      else {
        answer.add(false);
      }
    }
    return answer;
  }
}
