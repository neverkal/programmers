package level2.targetnumber;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        int cnt = 0;

        // 최종 깊이까지 탐색을 끝냈을 때, 값을 비교
        if (depth == numbers.length) {
            // 문제 조건 비교
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        cnt += dfs(numbers, target, depth + 1, sum + numbers[depth]); // 맨 처음 +1 로 시작하는 경우, 이후로는 해당 노드의 + 1
        cnt += dfs(numbers, target, depth + 1, sum - numbers[depth]); // 맨 처음 -1 로 시작하는 경우, 이후로는 해당 노드의 - 1

        return cnt;
    }

    @Test
    public void answerTest() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Assert.assertEquals(5, solution(numbers, target));
    }
}
