package level2.materevmove;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Solution {

    public int solution(String s)
    {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.empty()) {
                st.push(s.charAt(i));
                continue;
            } else {
                char stackWord = st.peek();

                if (stackWord != s.charAt(i)) {
                    st.push(s.charAt(i));
                } else {
                    st.pop();
                }
            }
        }

        return (st.empty()) ? 1 : 0;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals(1, solution("baabaa"));
        Assert.assertEquals(0, solution("cdcd"));
    }
}
