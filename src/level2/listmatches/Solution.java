package level2.listmatches;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int solution(int n, int a, int b) {
        int answer = 0;

        while(true) {
            answer++;
            a = (int) Math.ceil((double) a / 2);
            b = (int) Math.ceil((double) b / 2);

            if (a == 0 || b == 0 || a == b)
                break;
        }

        return answer;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(3, solution(8, 4, 7));
    }
}
