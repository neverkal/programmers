package level1.lotto;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {1, 2, 5, 6, 7, 8};

        int[] result = solution(lottos, win_nums);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        int highRank = 0;
        int lowRank = 0;

        for(int lottoNum : lottos) {
            Arrays.sort(win_nums);

            int winNumsCheckindex = Arrays.binarySearch(win_nums, lottoNum);

            if (winNumsCheckindex >= 0) {
                highRank += 1;
            } else if (lottoNum == 0) {
                highRank += 1;
                lowRank += 1;
            } else {
                lowRank +=1;
            }
        }

        if(lowRank < 6) {
            lowRank += 1;
        }

        if(highRank == 0) {
            highRank += 1;
        }

        answer[0] = 7 - highRank;
        answer[1] = lowRank;

        return answer;
    }
}
