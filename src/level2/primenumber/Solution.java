package level2.primenumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class Solution {

    static HashSet<Integer> answerList = new HashSet<>();

    public int solution(String numbers) {
        String[] numberList = numbers.split("");
        boolean[] visited = new boolean[numbers.length()];
        String[] output = new String[numberList.length];

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numberList, visited, 0, i, output);
        }

        return answerList.size();
    }

    public static void dfs(String[] numberList, boolean[] visited, int index, int r, String[] output) {
        if (r == index) {
            // 숫자 만들기
            StringBuilder numberBuiler = new StringBuilder();

            for (int i = 0; i < r; i++) {
                numberBuiler.append(output[i]);
            }

            int number = Integer.parseInt(numberBuiler.toString());
            boolean numberIsPrime = isPrimeNumber(number);

            // 중복 수 체크 필요
            if (numberIsPrime) answerList.add(number);

            // 거꾸로도 확인
            return;
        }

        if (index == numberList.length) {
            return;
        } else {
            for (int i = 0; i < numberList.length; i++) {
                if (visited[i] != true) {
                    visited[i] = true;
                    output[index] = numberList[i];
                    dfs(numberList, visited, index + 1, r, output);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean isPrimeNumber(int number) {
        boolean result = true;
        int end = (int)Math.sqrt(number);

        if (number == 0 || number == 1) return false;

        for(int i = 2; i <= end; i++) {
            if( number % i == 0) {
                result = false;
                break;
                //나누어 떨어지면 더이상 소수가 아니므로 break를 걸어 for문을 끝낸다.
            } else {
                result = true;
            }
        }

        return result;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(2, solution("011"));
    }
}
