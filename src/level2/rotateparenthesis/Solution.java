package level2.rotateparenthesis;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {

    public int solution(String s) {
        int answer = 0;

        boolean regex = s.matches("[(){}\\[\\]]*");
        if (!regex) return answer;

        for (int i = 0; i < s.length(); i++) {
            if (parenthesisCheck(s)) answer++;

            // 회전
            char firstString = s.charAt(0);
            String sub = s.substring(1);
            s = sub + firstString;
        }

        return answer;
    }

    private static boolean parenthesisCheck(String s) {
        Stack<Character> parenthesisStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // stack이 비어있을 경우 추가
            if (parenthesisStack.empty()) {
                parenthesisStack.push(s.charAt(i));
            } else {
                // 열린 괄호인지 확인
                if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                    parenthesisStack.push(s.charAt(i));
                } else {
                    // stack에서 열린 괄호 꺼냄
                    char compareParenthesis = parenthesisStack.pop();

                    // 괄호 비교
                    if ((compareParenthesis == '[' && s.charAt(i) != ']') ||
                            (compareParenthesis == '{' && s.charAt(i) != '}') ||
                                    (compareParenthesis == '(' && s.charAt(i) != ')')
                    ) {
                        return false;
                    }
                }
            }
        }

        return parenthesisStack.empty();
    }

    @Test
    public void answerTest() {
        String s = "}}}";
        Assert.assertEquals(0, solution(s));
    }
}
