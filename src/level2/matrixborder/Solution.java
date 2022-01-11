package level2.matrixborder;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int number = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = number + 1;
                number++;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int top, left, bottom, right = 0;

            top = queries[i][0] - 1;
            left = queries[i][1] - 1;
            bottom = queries[i][2] - 1;
            right = queries[i][3] - 1;

            int tmp = matrix[top][left];
            int min = tmp;

            // 아래에서 위
            for (int y = top; y < bottom; y++) {
                matrix[y][left] = matrix[y + 1][left];
                min = Math.min(min, matrix[y + 1][left]);
            }

            // 왼쪽에서 오른쪽
            for (int x = left; x < right; x++) {
                matrix[bottom][x] = matrix[bottom][x + 1];
                min = Math.min(min, matrix[bottom][x + 1]);
            }

            // 위에서 아래
            for (int y = bottom; y > top; y--) {
                matrix[y][right] = matrix[y - 1][right];
                min = Math.min(min, matrix[y - 1][right]);
            }

            // 왼쪽에서 오른쪽
            for (int x = right; x > left; x--) {
                matrix[top][x] = matrix[top][x - 1];
                min = Math.min(min, matrix[top][x - 1]);
            }

            matrix[top][left + 1] = tmp;

            answer[i] = min;
        }

        return answer;
    }

    @Test
    public void answerTest() {
        int[] expectArray1 = {8, 10, 25};
        int[][] testQueries1 = {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3},
        };

        Assert.assertArrayEquals(expectArray1, solution(6, 6, testQueries1));
    }

}
