package level2.delivery;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    private int cost;
    private int here;

    Node(int cost, int here) {
        this.cost = cost;
        this.here = here;
    }

    public int getCost() {
        return cost;
    }

    public int getHere() {
        return here;
    }

    @Override
    public int compareTo(Node o) {
        return cost <= o.cost ? -1 : 1;
    }
}

public class Solution {

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dist = dijkstra(N, road, 1);

        for (int i : dist) {
            if (i <= K) answer++;
        }

        return answer;
    }

    public int[] dijkstra(int N, int[][] road, int start) {
        int[] dist = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            dist[i] = 500001;
        }
        dist[start] = 0;

        PriorityQueue<Node> q= new PriorityQueue<>();
        q.add(new Node(0, start));  // 1번 노드 초기화

        int cost, here;
        int cost2, there;

        while(!q.isEmpty()) {
            cost = q.peek().getCost();
            here = q.peek().getHere();
            q.poll();

            // 저장된 값보다 node의 비용이 더 큰 경우에는 계산할 필요 없음
            if (cost > dist[here]) continue;

            // 연결된 마을 찾아서 거리 계산
            for (int i = 0; i < road.length; i++) {
                if (road[i][0] == here) {
                    cost2 = road[i][2] + cost;
                    there = road[i][1];

                    if (cost2 < dist[there]) {
                        dist[there] = cost2;
                        q.add(new Node(cost2, there));
                    }
                } else if (road[i][1] == here) {
                    cost2 = road[i][2] + cost;
                    there = road[i][0];

                    if (cost2 < dist[there]) {
                        dist[there] = cost2;
                        q.add(new Node(cost2, there));
                    }
                }
            }
        }
        return dist;
    }

    @Test
    public void answerTest() {
        int N = 5;
        int K = 3;
        int[][] road = {
                {1, 2, 1},
                {2, 3, 3},
                {5, 2, 2},
                {1, 4, 2},
                {5, 3, 1},
                {5, 4, 2}
        };

        Assert.assertEquals(4, solution(N, road, K));
    }
}
