package level2.biggestnumber;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] numberString = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            numberString[i] = String.valueOf(numbers[i]);
        }

        //내림차순 정렬
        Arrays.sort(numberString, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        //값이 0인 경우
        if (numberString[0].equals("0")) return "0";

        //0이 아니면 문자열을 더해준다.
        for(String s: numberString) answer.append(s);

        return answer.toString();
    }

    @Test
    public void answerTest() {
        int[] numbers = {6, 10, 2};
        Assert.assertEquals("6210", solution(numbers));
    }

}
