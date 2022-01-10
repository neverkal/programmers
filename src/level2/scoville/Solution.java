package level2.scoville;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

public class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean scovilleFlag = false;

        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            scovilleQueue.add(scoville[i]);
        }

        while (!scovilleQueue.isEmpty()) {
            if (scovilleQueue.size() <= 1) {
                if (scovilleQueue.poll() >= K) scovilleFlag = true;
                break;
            }

            int scovillePoint = scovilleQueue.poll();

            if (scovillePoint < K) {
                int nextScovillePoint = scovilleQueue.poll();
                scovilleQueue.add(scovillePoint + (nextScovillePoint * 2));

                answer++;
            } else {
                scovilleFlag = true;
            }
        }


        return (scovilleFlag) ? answer : -1;
    }

    @Test
    public void answerTest() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        Assert.assertEquals(2, solution(scoville, k));
    }
}
