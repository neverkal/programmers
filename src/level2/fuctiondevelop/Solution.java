package level2.fuctiondevelop;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();
        Queue<Integer> functionInfo = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int mod = (100 - progresses[i]) % speeds[i];
            int share = (100 - progresses[i]) / speeds[i];

            if (mod > 0) {
                functionInfo.add(share + 1);
            } else {
                functionInfo.add(share);
            }
        }

        int nowDays = 0;
        int cnt = 1;

        while (!functionInfo.isEmpty()) {
            int dequeDays = functionInfo.poll();

            if (nowDays == 0) {
                nowDays = dequeDays;
                continue;
            }

            if (nowDays >= dequeDays) {
                cnt++;
            } else {
                nowDays = dequeDays;
                answerList.add(cnt);
                cnt = 1;
            }
        }

        if (cnt > 0) {
            answerList.add(cnt);
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    @Test
    public void answer() {
        int[] testResult = {2,2};
        int[] testProgresses = {2,2,1,2};
        int[] testSpeeds = {1,1,1,1};

        Assert.assertArrayEquals(testResult, solution(testProgresses, testSpeeds));
    }
}
