package level1.knumberorder;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array, commands));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            ArrayList<Integer> checkArray = new ArrayList<>();

            int start = commands[i][0];
            int end = commands[i][1];
            int numberCount = commands[i][2];

            for(int j = start; j <= end; j++) checkArray.add(array[j-1]);

            Collections.sort(checkArray);

            answer[i] = checkArray.get(numberCount - 1);
        }

        return answer;
    }
}
