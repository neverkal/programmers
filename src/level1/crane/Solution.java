package level1.crane;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> collector = new Stack<>();

        for(int move : moves) {
            int movePoint = move - 1;

            for(int i = 0; i < board.length; i++) {
                if (board[i][movePoint] > 0) {
                    if(!collector.isEmpty() && (collector.lastElement() == board[i][movePoint])) {
                        collector.pop();
                        answer+=2;
                    } else {
                        collector.push(board[i][movePoint]);
                    }

                    board[i][movePoint] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
