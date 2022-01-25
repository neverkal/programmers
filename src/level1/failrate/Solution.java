package level1.failrate;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 실패율 정보를 저장할 map 초기화
        HashMap<Integer, Double> stageInfo = new HashMap<>();

        for(int i = 0; i < N; i++) {
            int stageReachCount = 0;
            int failCount = 0;
            double failPercent;

            for (int number : stages) {
                if (i + 1 == number) {
                    failCount++;
                    stageReachCount++;
                } else if (i + 1 < number) {
                    stageReachCount++;
                } else {
                    continue;
                }
            }

            failPercent = (stageReachCount == 0) ? 0 : (double) failCount / stageReachCount;
            stageInfo.put(i + 1, failPercent);
        }

        // 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<Map.Entry<Integer, Double>>(stageInfo.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        // return
        int index = 0;

        for (Map.Entry<Integer, Double> entry : entryList) {
            answer[index] = entry.getKey();
            index++;
        }

        return answer;
    }

    @Test
    public void answerTest() {
        int[] stages = {2,2,2,2,2};
        int[] answer = {2,3,4,5,1};

        Assert.assertArrayEquals(answer, solution(5, stages));
    }
}
