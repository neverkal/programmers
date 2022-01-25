package level2.formulamax;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Solution {

    static long answer = 0;
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public long solution(String expression) {
        char[] expressions = {'*', '+', '-'};
        boolean[] visited = new boolean[expressions.length];
        char[] orderExpressions = new char[expressions.length];

        String num = "";

        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                num += expression.charAt(i);
            }else{
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }

        nums.add(Long.parseLong(num));
        permutaion(expressions, 3, orderExpressions, 0, visited);

        return answer;
    }

    private static void permutaion(char[] expressions, int r, char[] temp, int current, boolean[] visited) {
        if (r == current) {
            operations(temp);
        } else {
            for (int i = 0; i < expressions.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[current] = expressions[i];
                    permutaion(expressions, r, temp, current + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }

    private static long calculate(long num1, long num2, char operator) {
        switch (operator) {
            case '*' :
                return num1 * num2;
            case '+' :
                return num1 + num2;
            case '-' :
                return num1 - num2;
            default:
                return 0;
        }
    }

    private static void operations(char[] expressions) {
        ArrayList<Long> cNums = new ArrayList<>(nums);
        ArrayList<Character> cOps = new ArrayList<>(ops);

        for (int i = 0; i < expressions.length; i++){
            for (int j = 0 ; j < cOps.size(); j++){
                if (expressions[i] == cOps.get(j)){
                    long res = calculate(cNums.remove(j), cNums.remove(j), expressions[i]);

                    cNums.add(j, res);
                    cOps.remove(j);

                    j--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(cNums.get(0)));
        return;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(300, solution("50*6-3*2"));
    }
}
