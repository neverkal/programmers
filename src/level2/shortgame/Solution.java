package level2.shortgame;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n = 0;
    static int m = 0;

    boolean[][] visited;

    public int solution(int[][] maps) {
        int answer = 0;

        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];

        answer = bfs(maps, 0, 0);
        return answer;
    }

    public int bfs(int[][] maps, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            // 모두 방문하였으면 return
            if (node.x == n - 1 && node.y == m - 1) return node.cost;

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }

        return -1;
    }

    public class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    @Test
    public void answerTest() {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        Assert.assertEquals(-1, solution(maps));
    }
}
