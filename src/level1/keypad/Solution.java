package level1.keypad;

public class Solution {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        System.out.println(solution(numbers, "left"));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answerBuilder = new StringBuilder();

        // 키패드를 숫자로 변경하여 풀이 진행
        int rightPoint = 12;
        int leftPoint = 10;

        for (int number : numbers) {
            if (number == 0) number = 11;

            if (number % 3 == 1) {
                answerBuilder.append("L");
                leftPoint = number;
            } else if (number % 3 == 0) {
                answerBuilder.append("R");
                rightPoint = number;
            } else {
                // 큰 숫자에서 작은 숫자 빼기
                int checkRightPoint = (number > rightPoint) ? number - rightPoint : rightPoint - number;
                int checkLeftPoint = (number > leftPoint) ? number - leftPoint : leftPoint - number;

                // ((현재 위치 - 누를 숫자 / 3) + ((현재 위치 - 누를 숫자) % 3)
                int calculateRightPoint = (checkRightPoint / 3) + (checkRightPoint % 3);
                int calculateLeftPoint = (checkLeftPoint / 3) + (checkLeftPoint % 3);

                if (calculateRightPoint > calculateLeftPoint) {
                    answerBuilder.append("L");
                    leftPoint = number;
                } else if (calculateRightPoint < calculateLeftPoint) {
                    answerBuilder.append("R");
                    rightPoint = number;
                } else {
                    if (hand.equals("right")) {
                        answerBuilder.append("R");
                        rightPoint = number;
                    } else {
                        answerBuilder.append("L");
                        leftPoint = number;
                    }
                }
            }
        }

        return answerBuilder.toString();
    }
}
