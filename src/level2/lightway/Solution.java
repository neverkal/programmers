package level2.lightway;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Solution {

    static int R, C;
    static int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 }; // 방향 설정 : 아래, 왼, 위, 오른
    static boolean[][][] isVisited; // 방문 flag

    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();

        R = grid.length;
        C = grid[0].length();

        isVisited = new boolean[R][C][4]; // 방문 초기화

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[i][j][d]) answer.add(light(grid, i, j, d));
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    private static int light(String[] grid, int r, int c, int d) {
        int cnt = 0; // 이동거리

        while (!isVisited[r][c][d]) {
            cnt++;    // 거리증가
            isVisited[r][c][d] = true; // 방문처리

            if (grid[r].charAt(c) == 'L')
                d = d == 0 ? 3 : d - 1; // 좌회전
            else if (grid[r].charAt(c) == 'R')
                d = d == 3 ? 0 : d + 1; // 우회전

            r = (r + dr[d] + R) % R; // 거리 계산
            c = (c + dc[d] + C) % C; // 거리 계산
        }

        return cnt;
    }

    @Test
    public void answerTest() {
        int[] answer = {4,4};
        String[] grid = {"R", "R"};

        Assert.assertArrayEquals(answer, solution(grid));
    }

}
