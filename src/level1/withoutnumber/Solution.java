package level1.withoutnumber;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        int[] checkNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < checkNumber.length; i++) {
            int check = checkNumber[i];

            if(!IntStream.of(numbers).anyMatch(x -> x == check)) {
                answer += check;
            }
        }

        return answer;
    }
}
