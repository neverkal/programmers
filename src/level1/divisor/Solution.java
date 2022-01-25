package level1.divisor;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int count = 0;

            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }

            if (count % 2 == 0) answer += i;
            else answer -= i;
        }

        return answer;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(52, solution(24, 27));
    }
}
