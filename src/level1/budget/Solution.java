package level1.budget;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int solution(int[] d, int budget) {
        int answer = 0;

        // 정렬
        Arrays.sort(d);

        for (int dp : d) {
            if (budget >= dp) {
                budget -= dp;
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    @Test
    public void solutionTest() {
        int[] d = {2,2,3,3};
        int budget = 10;

        Assert.assertEquals(4, solution(d, budget));
    }

}
