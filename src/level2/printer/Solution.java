package level2.printer;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> printProcess = new LinkedList<>(); // 중요도 정보
        Queue<Integer> orderPrint = new LinkedList<>(); // 순서 정보

        ArrayList<Integer> finishedOrder = new ArrayList<>();

        // 큐로 초기화
        for (int i = 0; i < priorities.length; i++) {
            printProcess.add(priorities[i]);
            orderPrint.add(i);
        }

        // 큐가 없을 때 까지 반복
        while(!printProcess.isEmpty()) {
            int nowPriority = printProcess.poll();
            int nowOrder = orderPrint.poll();

            int maxPrintProcess = printProcess.stream().max(Integer::compare).orElse(-1);

            if (nowPriority >= maxPrintProcess) {
                finishedOrder.add(nowOrder);
            } else {
                printProcess.add(nowPriority);
                orderPrint.add(nowOrder);
            }
        }

        // location 위치 찾아내기
        for (int i = 0; i < finishedOrder.size(); i++) {
            if (finishedOrder.get(i) == location) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    @Test
    public void answerTest() {
        int[] priorites = {1, 1, 9, 1, 1, 1};

        Assert.assertEquals(5, solution(priorites, 0));
    }
}
