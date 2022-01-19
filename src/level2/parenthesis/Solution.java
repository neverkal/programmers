package level2.parenthesis;

import org.junit.Assert;
import org.junit.Test;

public class Solution {

    public static StringBuilder sb = new StringBuilder();

    public String solution(String p) {
        String answer = "";

        answer = validateParenthesis(p);
        return answer;
    }

    public static String validateParenthesis(String p) {
        int idx = splitString(p);

        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (validateString(u)) {
            sb.append(u);
        } else {
            sb.append("(");
            if(!v.equals("")) {
                validateParenthesis(v);
                v = "";
            }
            sb.append(")");
            sb.append(setValidateGrammer(u));
        }

        if(!v.equals("")) {
            validateParenthesis(v);
        }

        return sb.toString();
    }

    public static String setValidateGrammer(String p) {
        String[] split = p.split("");
        StringBuilder splitBuilder = new StringBuilder();

        for (int i = 1; i < split.length - 1; i++) {
            if(split[i].equals("(")) splitBuilder.append(")");
            else splitBuilder.append("(");
        }

        return splitBuilder.toString();
    }

    public static boolean validateString(String p) {
        String[] strings = p.split("");
        int count = 0;

        for (String str : strings) {
            if (str.equals("(")) count++;
            else count--;

            if (count < 0) return false;
        }
        return true;
    }

    public static int splitString(String p) {
        String[] strings = p.split("");

        int idx = 0;
        int cnt = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("(")) {
                cnt += 1;
            } else {
                cnt -= 1;
            }

            if (cnt == 0) {
                idx = i + 1;
                break;
            }
        }

        return idx;
    }

    @Test
    public void answerTest() {
        Assert.assertEquals("()(())()", solution("()))((()"));
    }
}
