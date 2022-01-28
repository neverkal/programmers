package level1.ternaryscale;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        StringBuilder answerBuilder = new StringBuilder();

        // 3진법
        while (n > 0) {
            // 뒤집어서 저장
            answerBuilder.append(Integer.toString(n % 3));
            n = n / 3;
        }

        answerBuilder = answerBuilder.reverse();

        // 3진법 -> 10진법
        for (int i = 0; i < answerBuilder.length(); i++) {
            answer += Math.pow(3, i) * Integer.parseInt(String.valueOf(answerBuilder.charAt(i)));
        }

        return answer;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(229, solution(125));
    }
}
