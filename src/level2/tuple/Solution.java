package level2.tuple;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Solution {

    public int[] solution(String s) {
        int[] answer;

        // 초기 배열 만들기
        String sRemove = s.substring(1, s.length() - 1);

        // 배열 분리
        StringBuilder listString = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        boolean open = false;

        for (int i = 0; i < sRemove.length(); i++) {
            if ('{' == sRemove.charAt(i)) {
                open = true;
                listString.append(sRemove.charAt(i));
            } else if ('}' == sRemove.charAt(i)) {
                open = false;
                listString.append(sRemove.charAt(i));
                list.add(listString.toString());

                listString = new StringBuilder();
            } else if (',' == sRemove.charAt(i)) {
                if (open) listString.append(sRemove.charAt(i));
            } else {
                listString.append(sRemove.charAt(i));
            }
        }

        String[] sSplit = list.toArray(new String[list.size()]);
        answer = new int[sSplit.length];

        for (int i = 0; i < sSplit.length; i++) {
            for (String value : sSplit) {
                String splitRemove = value.substring(1, value.length() - 1);
                String[] splitSplit = splitRemove.split(",");

                if (i + 1 == splitSplit.length) {
                    for (int x = 0; x < splitSplit.length; x++) {
                        int finalX = x;
                        boolean answerContain = IntStream.of(answer).anyMatch(v -> v == Integer.parseInt(splitSplit[finalX]));

                        if (!answerContain) {
                            answer[i] = Integer.parseInt(splitSplit[x]);
                            break;
                        }
                    }
                    break;
                }
            }
        }

        return answer;
    }

    @Test
    public void answerTest() {
        int[] answer = {3, 2, 4, 1};
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        Assert.assertArrayEquals(answer, solution(s));
    }
}
