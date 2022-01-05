package level1.mocktest;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    final static int[] playerPattern1 = {1,2,3,4,5};
    final static int[] playerPattern2 = {2,1,2,3,2,4,2,5};
    final static int[] playerPattern3 = {3,3,1,1,2,2,4,4,5,5};

    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};
        System.out.println(solution(answer));
    }

    public static int[] solution(int[] answers) {
        int[] answerCount = new int[3];

        int player1Count = answerCaculate(playerPattern1, answers);
        int player2Count = answerCaculate(playerPattern2, answers);
        int player3Count = answerCaculate(playerPattern3, answers);

        answerCount[0] = player1Count;
        answerCount[1] = player2Count;
        answerCount[2] = player3Count;

        Arrays.sort(answerCount);

        int maxCount = answerCount[2];
        ArrayList<Integer> answerList = new ArrayList<>();

        if (maxCount == player1Count) {
            answerList.add(1);
        }

        if (maxCount == player2Count) {
            answerList.add(2);
        }

        if (maxCount == player3Count) {
            answerList.add(3);
        }

        int[] answer = new int[answerList.size()];
        int answerSize = 0;

        for (int answerListValue : answerList) {
            answer[answerSize++] = answerListValue;
        }

        return answer;
    }

    public static int answerCaculate(int[] pattern, int[] answers) {
        int countAnswer = 0;
        int patterPoint = 0;

        for (int answer : answers) {
            if (answer == pattern[patterPoint]) countAnswer++;
            patterPoint = (patterPoint == pattern.length - 1) ? 0 : patterPoint + 1;
        }

        return countAnswer;
    }

}
